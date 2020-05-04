package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/AddRowMenu.fxml"));
            root = loader.load();
            Stage addRowMenu = new Stage();
            addRowMenu.setTitle("Добавить строку");
            addRowMenu.initModality(Modality.APPLICATION_MODAL);
            addRowMenu.setScene(new Scene(root));
            AddRowMenuController addRowMenuController = loader.getController();
            addRowMenuController.setParent(this);
            addRowMenu.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onCalculateButtonClick(ActionEvent event) {
        for (FunctionalRA functionalRA : this.functionalRAArrayList) {
            if (functionalRA.getElement().equals("") && functionalRA.getMainFunctionElement().equals("") &&
                    functionalRA.getTheMostImportantUseful() == null && functionalRA.getUseful() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Вы не заполнили все поля!");
                alert.show();
            }
        }
        for (FunctionalRA functionalRA : this.functionalRAArrayList){
            FunctionalResourceAnalysisService functionalResourceAnalysisService = new FunctionalResourceAnalysisService();
            this.functionalRAArrayList.remove(functionalRA);
            functionalResourceAnalysisService.getValueFromFunctionConvolution(functionalRA);
            this.functionalRAArrayList.add(functionalRA);
        }
        loadObjectsInListView();
    }

    @FXML
    void initialize() {
        loadObjectsInListView();
        listViewObjects.setCellFactory(objectsListView -> new RowFunctionallyResourceAnalysis());
    }

    public void loadObjectsInListView() {
        listViewObjects.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewObjects.setItems(this.functionalRAArrayList);
    }

    public void addObject(FunctionalRA functionalRA) {
        functionalRAArrayList.add(functionalRA);
    }

}