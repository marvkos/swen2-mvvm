package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.dto.MapQuestApiResponse;
import at.technikum.mvvm.service.WordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectorViewModel {

    private final StringProperty string1 = new SimpleStringProperty("");
    private final StringProperty string2 = new SimpleStringProperty("");
    private final StringProperty output = new SimpleStringProperty("");

    private final WordService wordService;

    public ConnectorViewModel(WordService wordService) {
        this.wordService = wordService;
    }

    public void connect() {
        String key = "YOUR_KEY";
        String from = string1.get();
        String to = string2.get();

        String uri = "https://www.mapquestapi.com/directions/v2/route?";
        uri += "key=" + key;
        uri += "&from=" + from;
        uri += "&to=" + to;
        uri += "&unit=k";
        uri += "&transportMode=WALKING";

        String responseJson = "";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            responseJson = response.body();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String information = "From " + from + " to " + to + ": ";

        try {
            MapQuestApiResponse apiResponse = mapper.readValue(
                    responseJson,
                    MapQuestApiResponse.class
            );

            information += apiResponse.getRoute().getDistance();
            information += " Time: " + apiResponse.getRoute().getFormattedTime();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        wordService.save(information);

        output.set(information);

        string1.set("");
        string2.set("");
    }

    public String getString1() {
        return string1.get();
    }

    public StringProperty string1Property() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1.set(string1);
    }

    public String getString2() {
        return string2.get();
    }

    public StringProperty string2Property() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2.set(string2);
    }

    public String getOutput() {
        return output.get();
    }

    public StringProperty outputProperty() {
        return output;
    }

    public void setOutput(String output) {
        this.output.set(output);
    }


}
