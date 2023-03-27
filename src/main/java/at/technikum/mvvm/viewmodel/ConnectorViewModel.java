package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.service.WordService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConnectorViewModel {

    private final StringProperty string1 = new SimpleStringProperty("");
    private final StringProperty string2 = new SimpleStringProperty("");
    private final StringProperty output = new SimpleStringProperty("");

    private final WordService wordService;

    public ConnectorViewModel(WordService wordService) {
        this.wordService = wordService;
    }

    public void connect() {
        String word = string1.get() + " " + string2.get();
        wordService.save(word);

        output.set(word);

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
