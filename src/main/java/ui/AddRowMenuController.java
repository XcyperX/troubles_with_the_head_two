package ui;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.FunctionalRA;
import model.TypeOfFunctionObject;
import service.FunctionalResourceAnalysisService;

public class AddRowMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField elementsTextField;

    @FXML
    private TextField mainFunctionsElement;

    @FXML
    private ComboBox<String> theMostImportantUsefulComboBox;

    @FXML
    private ComboBox<String> usefulComboBox;

    @FXML
    private Button addRowButton;

    private FunctionallyResourceAnalysisController functionallyResourceAnalysisController;

    @FXML
    void onAddRowButtonClick(ActionEvent event) {
        if (elementsTextField.getText().isEmpty() || mainFunctionsElement.getText().isEmpty() ||
            theMostImportantUsefulComboBox.getValue() == null ||
            usefulComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не заполнили все поля!");
            alert.show();
        } else {
            FunctionalResourceAnalysisService functionalResourceAnalysisService = new FunctionalResourceAnalysisService();
            FunctionalRA functionalRA = new FunctionalRA(elementsTextField.getText(), mainFunctionsElement.getText(),
                    functionalResourceAnalysisService.getFunctionalObjectByString(theMostImportantUsefulComboBox.getSelectionModel().getSelectedItem()),
                    functionalResourceAnalysisService.getFunctionalObjectByString(usefulComboBox.getSelectionModel().getSelectedItem()));
            functionalRA = functionalResourceAnalysisService.getValueFromFunctionConvolution(functionalRA);
            functionallyResourceAnalysisController.addObject(functionalRA);
            functionallyResourceAnalysisController.loadObjectsInListView();

            Stage mainWindow = (Stage) addRowButton.getScene().getWindow();
            mainWindow.close();
        }
    }

    @FXML
    void initialize() {
        setComboBox();
    }

    public void setComboBox() {
        ObservableList<String> typeOfFunctionObjects = FXCollections.observableArrayList(Arrays.stream(TypeOfFunctionObject.values()).map(TypeOfFunctionObject::getType).collect(Collectors.toList()));
        theMostImportantUsefulComboBox.setItems(typeOfFunctionObjects);
        usefulComboBox.setItems(typeOfFunctionObjects);
    }

    void setParent(FunctionallyResourceAnalysisController functionallyResourceAnalysisController) {
        this.functionallyResourceAnalysisController = functionallyResourceAnalysisController;
    }
}
