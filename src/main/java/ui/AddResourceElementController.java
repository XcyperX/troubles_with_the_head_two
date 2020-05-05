package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ResourceAnalysis;
import service.ResourceAnalysisService;

public class AddResourceElementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField elementName;

    @FXML
    private TextField price;

    @FXML
    private TextField manufacturability;

    @FXML
    private TextField weight;

    @FXML
    private TextField reliability;

    @FXML
    private TextField design;

    @FXML
    private TextField degreeDamping;

    @FXML
    private TextField durability;

    @FXML
    private TextField easeRepair;

    @FXML
    private TextField energyCosts;

    @FXML
    private Button addElement;

    private ResourceAnalysisController resourceAnalysisController;

    @FXML
    void onAddElementButtonClick(ActionEvent event) {
        if (elementName.getText().isEmpty() || price.getText().isEmpty() || manufacturability.getText().isEmpty() ||
                weight.getText().isEmpty() || reliability.getText().isEmpty() || design.getText().isEmpty() ||
                degreeDamping.getText().isEmpty() || durability.getText().isEmpty() || easeRepair.getText().isEmpty() ||
                energyCosts.getText().isEmpty() ||
                Integer.parseInt(price.getText()) < 1 || Integer.parseInt(price.getText()) > 10 ||
                Integer.parseInt(manufacturability.getText()) < 1 || Integer.parseInt(manufacturability.getText()) > 10 ||
                Integer.parseInt(weight.getText()) < 1 || Integer.parseInt(weight.getText()) > 10 ||
                Integer.parseInt(reliability.getText()) < 1 || Integer.parseInt(reliability.getText()) > 10 ||
                Integer.parseInt(design.getText()) < 1 || Integer.parseInt(design.getText()) > 10 ||
                Integer.parseInt(degreeDamping.getText()) < 1 || Integer.parseInt(degreeDamping.getText()) > 10 ||
                Integer.parseInt(durability.getText()) < 1 || Integer.parseInt(durability.getText()) > 10 ||
                Integer.parseInt(easeRepair.getText()) < 1 || Integer.parseInt(easeRepair.getText()) > 10 ||
                Integer.parseInt(energyCosts.getText()) < 1 || Integer.parseInt(energyCosts.getText()) > 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не заполнили все поля!");
            alert.show();
        } else {
            ResourceAnalysis resourceAnalysis = new ResourceAnalysis(elementName.getText(), Integer.parseInt(price.getText()),
                    Integer.parseInt(manufacturability.getText()), Integer.parseInt(weight.getText()),
                    Integer.parseInt(reliability.getText()), Integer.parseInt(design.getText()),
                    Integer.parseInt(degreeDamping.getText()), Integer.parseInt(durability.getText()),
                    Integer.parseInt(easeRepair.getText()), Integer.parseInt(energyCosts.getText()));
            resourceAnalysisController.addObject(resourceAnalysis);
            resourceAnalysisController.loadObjectsInListView();
            Stage mainWindow = (Stage) addElement.getScene().getWindow();
            mainWindow.close();
        }
    }

    @FXML
    void initialize() {

    }

    void setParent(ResourceAnalysisController resourceAnalysisController) {
        this.resourceAnalysisController = resourceAnalysisController;
    }
}
