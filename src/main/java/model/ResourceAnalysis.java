package model;

public class ResourceAnalysis {

    private String name;

    private int price;

    private int technologies;

    private int weight;

    private int reliability;

    private int design;

    private int degreeOfDamping;

    private int durability;

    private int easeOfRepair;

    private int energyCosts;

    private float efficiency;

    public ResourceAnalysis(String name, int price, int technologies, int weight, int reliability, int design, int degreeOfDamping, int durability, int easeOfRepair, int energyCosts) {
        this.name = name;
        this.price = price;
        this.technologies = technologies;
        this.weight = weight;
        this.reliability = reliability;
        this.design = design;
        this.degreeOfDamping = degreeOfDamping;
        this.durability = durability;
        this.easeOfRepair = easeOfRepair;
        this.energyCosts = energyCosts;
    }

    public ResourceAnalysis() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTechnologies() {
        return technologies;
    }

    public void setTechnologies(int technologies) {
        this.technologies = technologies;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public int getDesign() {
        return design;
    }

    public void setDesign(int design) {
        this.design = design;
    }

    public int getDegreeOfDamping() {
        return degreeOfDamping;
    }

    public void setDegreeOfDamping(int degreeOfDamping) {
        this.degreeOfDamping = degreeOfDamping;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getEaseOfRepair() {
        return easeOfRepair;
    }

    public void setEaseOfRepair(int easeOfRepair) {
        this.easeOfRepair = easeOfRepair;
    }

    public int getEnergyCosts() {
        return energyCosts;
    }

    public void setEnergyCosts(int energyCosts) {
        this.energyCosts = energyCosts;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(float efficiency) {
        this.efficiency = efficiency;
    }
}
