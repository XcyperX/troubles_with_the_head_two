package ui;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.FunctionalRA;
import model.TypeOfFunctionObject;

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
    private ComboBox<TypeOfFunctionObject> theMostImportantUsefulComboBox;

    @FXML
    private ComboBox<TypeOfFunctionObject> usefulComboBox;

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

            ObservableList<TypeOfFunctionObject> typeOfFunctionObjects = FXCollections.observableArrayList(TypeOfFunctionObject.values());
            theMostImportantUsefulComboBox.setItems(typeOfFunctionObjects);
            usefulComboBox.setItems(typeOfFunctionObjects);
            theMostImportantUsefulComboBox.setValue(object.getTheMostImportantUseful());
            usefulComboBox.setValue(object.getUseful());

            convolutionFunctionsOne.setText(String.valueOf(object.getConvolutionFunctionsNumber1()));
            convolutionFunctionsTwo.setText(String.valueOf(object.getConvolutionFunctionsNumber2()));

            setText(null);
            setGraphic(anchor);
        }
    }
}
