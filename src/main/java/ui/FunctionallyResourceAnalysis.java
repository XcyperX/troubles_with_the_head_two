package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class FunctionallyResourceAnalysis {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> elementsColumn;

    @FXML
    private TableColumn<?, ?> basicFunctionsElementsColumn;

    @FXML
    private TableColumn<?, ?> essentialUsefulColumn;

    @FXML
    private TableColumn<?, ?> usefulColumn;

    @FXML
    private TableColumn<?, ?> functionConvolutionOne;

    @FXML
    private TableColumn<?, ?> functionConvolutionTwo;

    @FXML
    private Button addElement;

    @FXML
    private Button removeElement;

    @FXML
    void onAddElementButtonClick(ActionEvent event) {

    }

    @FXML
    void onRemoveElementButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
