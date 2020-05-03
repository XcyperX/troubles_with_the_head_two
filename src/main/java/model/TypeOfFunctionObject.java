package model;

public enum TypeOfFunctionObject {

    USEFUL("Полезная", 80), THE_MOST_IMPORTANT_USEFUL("Важнейшая полезная", 100), INCONSEQUENTIAL("Несущественная", 20);

    private final String type;

    private final int percent;

    private TypeOfFunctionObject(String type, int percent) {
        this.type = type;
        this.percent = percent;
    }

    public String getType() {
        return type;
    }

    public int getPercent() {
        return percent;
    }
}
