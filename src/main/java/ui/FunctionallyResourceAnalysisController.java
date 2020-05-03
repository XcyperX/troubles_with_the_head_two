package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.FunctionalRA;
import service.FunctionalResourceAnalysisService;

public class FunctionallyResourceAnalysisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField theMostImportantUsefulTextField;

    @FXML
    private TextField usefulTextField;

    @FXML
    private ListView<FunctionalRA> listViewObjects;

    @FXML
    private Button addRowButton;

    private ObservableList<FunctionalRA> functionalRAArrayList = FXCollections.observableArrayList();

    private FunctionalRA selectObject;

    @FXML
    void onAddRowButtonClick(ActionEvent event) {
        this.functionalRAArrayList = listViewObjects.getItems();
        this.functionalRAArrayList.add(new FunctionalRA());
        loadObjectsInListView();
    }

    @FXML
    void onCalculateButtonClick(ActionEvent event) {
        if (this.selectObject == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не выбрали строку!");
            alert.show();
        } else if (this.selectObject.getElement().equals("") && this.selectObject.getMainFunctionElement().equals("") &&
                   this.selectObject.getTheMostImportantUseful() == null && this.selectObject.getUseful() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не заполнили все поля!");
            alert.show();
        } else {
            FunctionalResourceAnalysisService functionalResourceAnalysisService = new FunctionalResourceAnalysisService();
            this.functionalRAArrayList.remove(this.selectObject);
            this.selectObject = functionalResourceAnalysisService.getValueFromFunctionConvolution(this.selectObject);
            this.functionalRAArrayList.add(this.selectObject);
            loadObjectsInListView();
        }
    }

    @FXML
    void initialize() {
        selectObject();
        loadObjectsInListView();
    }

    public void loadObjectsInListView() {
        listViewObjects.setItems(this.functionalRAArrayList);
        listViewObjects.setCellFactory(objectsListView -> new RowFunctionallyResourceAnalysis());
    }

    private void selectObject() {
        listViewObjects.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.selectObject = newValue;
            System.out.println(this.selectObject.getElement());
        });
    }
}
