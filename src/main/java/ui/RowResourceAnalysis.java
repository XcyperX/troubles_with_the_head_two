package ui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.ResourceAnalysis;

import java.io.IOException;

public class RowResourceAnalysis extends ListCell<ResourceAnalysis> {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label elementNameLabel;

    @FXML
    private Label priceLebel;

    @FXML
    private Label manufacturabilityLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label reliabilityLabel;

    @FXML
    private Label designLabel;

    @FXML
    private Label degreeDampingLabel;

    @FXML
    private Label durabilityLabel;

    @FXML
    private Label easeRepairLabel;

    @FXML
    private Label energyCostsLabel;

    @FXML
    private Label efficiencyLabel;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(ResourceAnalysis object, boolean empty) {
        super.updateItem(object, empty);

        if(empty || object == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/views/RowResourceAnalysis.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            elementNameLabel.setText(object.getName());
            priceLebel.setText(String.valueOf(object.getPrice()));
            manufacturabilityLabel.setText(String.valueOf(object.getTechnologies()));
            weightLabel.setText(String.valueOf(object.getWeight()));
            reliabilityLabel.setText(String.valueOf(object.getReliability()));
            designLabel.setText(String.valueOf(object.getDesign()));
            degreeDampingLabel.setText(String.valueOf(object.getDegreeOfDamping()));
            durabilityLabel.setText(String.valueOf(object.getDurability()));
            easeRepairLabel.setText(String.valueOf(object.getEaseOfRepair()));
            energyCostsLabel.setText(String.valueOf(object.getEnergyCosts()));
            efficiencyLabel.setText(String.valueOf(object.getEfficiency()));

            setText(null);
            setGraphic(anchor);
        }
    }
}
