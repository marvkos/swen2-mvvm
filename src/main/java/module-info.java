module at.technikum.mvvm {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.technikum.mvvm to javafx.fxml;
    opens at.technikum.mvvm.view to javafx.fxml;
    exports at.technikum.mvvm;
}