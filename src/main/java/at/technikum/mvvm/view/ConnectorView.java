package at.technikum.mvvm.view;

import at.technikum.mvvm.viewmodel.ConnectorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ConnectorView {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Label output;

    private final ConnectorViewModel connectorViewModel;

    public ConnectorView(ConnectorViewModel connectorViewModel) {
        this.connectorViewModel = connectorViewModel;
    }

    @FXML
    void initialize() {
        textField1.textProperty()
                .bindBidirectional(connectorViewModel.string1Property());
        textField2.textProperty()
                .bindBidirectional(connectorViewModel.string2Property());
        output.textProperty()
                .bind(connectorViewModel.outputProperty());
    }

    @FXML
    private void connect() {
        connectorViewModel.connect();
    }
}
