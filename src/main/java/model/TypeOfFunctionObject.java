package model;

public enum TypeOfFunctionObject {

    USEFUL("Полезная"), THE_MOST_IMPORTANT_USEFUL("Важнейшая полезная"), INCONSEQUENTIAL("Несущественная");

    private String type;

    private TypeOfFunctionObject(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
