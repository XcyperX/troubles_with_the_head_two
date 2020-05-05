package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ResourceAnalysis;
import service.ResourceAnalysisService;

public class ResourceAnalysisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<ResourceAnalysis> listViewElements;

    @FXML
    private Button addElement;

    private ObservableList<ResourceAnalysis> resourceAnalyses = FXCollections.observableArrayList();

    @FXML
    void onAddElementButtonClick(ActionEvent event) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/AddResourceElementMenu.fxml"));
            root = loader.load();
            Stage addRowMenu = new Stage();
            addRowMenu.setTitle("Добавить елемент");
            addRowMenu.initModality(Modality.APPLICATION_MODAL);
            addRowMenu.setScene(new Scene(root));
            AddResourceElementController addResourceElementController = loader.getController();
            addResourceElementController.setParent(this);
            addRowMenu.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onCalculateButtonClick(ActionEvent event) {
        if (listViewElements.getItems().size() < 2 || listViewElements.getItems() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Мало элементов в таблице!");
            alert.show();
        } else {
            ResourceAnalysisService resourceAnalysisService = new ResourceAnalysisService();
            resourceAnalyses = resourceAnalysisService.getEfficiencies(resourceAnalyses);
            loadObjectsInListView();
        }
    }

    @FXML
    void initialize() {
        listViewElements.setCellFactory(objectsListView -> new RowResourceAnalysis());
    }

    public void loadObjectsInListView() {
        listViewElements.refresh();
        listViewElements.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewElements.setItems(this.resourceAnalyses);
    }

    public void addObject(ResourceAnalysis resourceAnalysis) {
        resourceAnalyses.add(resourceAnalysis);
    }
}
