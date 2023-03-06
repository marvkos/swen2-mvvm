package at.technikum.mvvm;

import at.technikum.mvvm.view.ViewFactory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FXMLDependencyInjector {

    public static Parent load(String location, Locale locale) throws IOException {
        FXMLLoader loader = getLoader(location, locale);
        return loader.load();
    }

    public static FXMLLoader getLoader(String location, Locale locale) {
        return new FXMLLoader(
                FXMLDependencyInjector.class.getResource("/at/technikum/mvvm/" + location),
                ResourceBundle.getBundle("at.technikum.mvvm.gui", locale),
                new JavaFXBuilderFactory(),
                viewClass -> ViewFactory.getInstance().create(viewClass)
        );
    }
}
