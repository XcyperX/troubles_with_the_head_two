package service;

import javafx.collections.ObservableList;
import model.ResourceAnalysis;

import java.util.List;

public class ResourceAnalysisService {

    public ObservableList<ResourceAnalysis> getEfficiencies(ObservableList<ResourceAnalysis> resourceAnalysisList) {
        int maxPrice = 0;
        int maxWeight = 0;
        int maxEnergyCosts = 0;
        for (ResourceAnalysis ra : resourceAnalysisList) {
            if (ra.getPrice() > maxPrice) maxPrice = ra.getPrice();
            if (ra.getWeight() > maxWeight) maxWeight = ra.getWeight();
            if (ra.getEnergyCosts() > maxEnergyCosts) maxEnergyCosts = ra.getEnergyCosts();
        }
        for (ResourceAnalysis ra : resourceAnalysisList) {
            ra.setEfficiency(
                    (1 - (float) ra.getPrice() / maxPrice)
                            + ra.getTechnologies()
                            + (1 - (float) ra.getWeight() / maxWeight)
                            + ra.getReliability()
                            + ra.getDesign()
                            + ra.getDegreeOfDamping()
                            + ra.getDurability()
                            + ra.getEaseOfRepair()
                            + (1 - (float) ra.getEnergyCosts() / maxEnergyCosts)
            );
        }
        return resourceAnalysisList;
    }
}
