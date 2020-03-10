package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button functionalResourceAnalysis;

    @FXML
    private Button resourceAnalysis;

    @FXML
    void onFunctionalResourceAnalysisButtonClick(ActionEvent event) {
        Stage mainWindow = (Stage) functionalResourceAnalysis.getScene().getWindow();
        mainWindow.close();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/FunctionallyResourceAnalysis.fxml"));
            Stage adminWindow = new Stage();
            adminWindow.setScene(new Scene(root));
            adminWindow.setTitle("Функционально-ресусный анализ");
            adminWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onResourceAnalysisButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
