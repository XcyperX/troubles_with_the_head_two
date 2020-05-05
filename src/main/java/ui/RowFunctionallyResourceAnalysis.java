package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.FunctionalRA;
import model.TypeOfFunctionObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RowFunctionallyResourceAnalysis extends ListCell<FunctionalRA> {
    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label elementsLabel;

    @FXML
    private Label mainFunctionsElementLabel;

    @FXML
    private Label theMostImportantUsefulLabel;

    @FXML
    private Label usefulLabel;

    @FXML
    private Label convolutionFunctionsOne;

    @FXML
    private Label convolutionFunctionsTwo;


    private FXMLLoader mLLoader;


    @Override
    protected void updateItem(FunctionalRA object, boolean empty) {
        super.updateItem(object, empty);

        if(empty || object == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/views/RowFunctionallyResourceAnalysis.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            elementsLabel.setText(object.getElement());
            mainFunctionsElementLabel.setText(object.getMainFunctionElement());
            theMostImportantUsefulLabel.setText(object.getTheMostImportantUseful().getType());
            usefulLabel.setText(object.getUseful().getType());
            convolutionFunctionsOne.setText(String.valueOf(object.getConvolutionFunctionsNumber1()));
            convolutionFunctionsTwo.setText(String.valueOf(object.getConvolutionFunctionsNumber2()));

            setText(null);
            setGraphic(anchor);
        }
    }


}