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
    private URL location;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField elementsTextField;

    @FXML
    private TextField mainFunctionsElement;

    @FXML
    private ComboBox<String> theMostImportantUsefulComboBox;

    @FXML
    private ComboBox<String> usefulComboBox;

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
            elementsTextField.setText(object.getElement());
            mainFunctionsElement.setText(object.getMainFunctionElement());

            ObservableList<String> typeOfFunctionObjects = FXCollections.observableArrayList(Arrays.stream(TypeOfFunctionObject.values()).map(TypeOfFunctionObject::getType).collect(Collectors.toList()));
            theMostImportantUsefulComboBox.setItems(typeOfFunctionObjects);
            usefulComboBox.setItems(typeOfFunctionObjects);
//            theMostImportantUsefulComboBox.setValue(object.getTheMostImportantUseful().getType());
//            usefulComboBox.setValue(object.getUseful().getType());

            convolutionFunctionsOne.setText(String.valueOf(object.getConvolutionFunctionsNumber1()));
            convolutionFunctionsTwo.setText(String.valueOf(object.getConvolutionFunctionsNumber2()));

            setText(null);
            setGraphic(anchor);
        }
    }


}