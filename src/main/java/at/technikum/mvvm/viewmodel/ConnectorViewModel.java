package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.dto.MapQuestApiResponse;
import at.technikum.mvvm.dto.Route;
import at.technikum.mvvm.service.RouteService;
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

    private final RouteService routeService;
    private final WordService wordService;

    public ConnectorViewModel(
            RouteService routeService,
            WordService wordService
    ) {
        this.routeService = routeService;
        this.wordService = wordService;
    }

    public void connect() {
        String from = string1.get();
        String to = string2.get();

        Route route = routeService.getRoute(from, to);

        routeService.saveMap(route.getSessionId(), "map.jpg");

        String information = "From "
                + from + " to "
                + to + " in "
                + route.getFormattedTime()
                + " (" + route.getDistance() + ")";

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
