package model;

public class FunctionalRA {

    private String element;

    private String mainFunctionElement;

    private TypeOfFunctionObject theMostImportantUseful;

    private TypeOfFunctionObject useful;

    private double convolutionFunctionsNumber1;

    private double convolutionFunctionsNumber2;

    public FunctionalRA(String element, String mainFunctionElement, TypeOfFunctionObject theMostImportantUseful, TypeOfFunctionObject useful) {
        this.element = element;
        this.mainFunctionElement = mainFunctionElement;
        this.theMostImportantUseful = theMostImportantUseful;
        this.useful = useful;
    }

    public FunctionalRA(String element, String mainFunctionElement) {
        this.element = element;
        this.mainFunctionElement = mainFunctionElement;
    }

    public FunctionalRA() {
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getMainFunctionElement() {
        return mainFunctionElement;
    }

    public void setMainFunctionElement(String mainFunctionElement) {
        this.mainFunctionElement = mainFunctionElement;
    }

    public TypeOfFunctionObject getTheMostImportantUseful() {
        return theMostImportantUseful;
    }

    public void setTheMostImportantUseful(TypeOfFunctionObject theMostImportantUseful) {
        this.theMostImportantUseful = theMostImportantUseful;
    }

    public TypeOfFunctionObject getUseful() {
        return useful;
    }

    public void setUseful(TypeOfFunctionObject useful) {
        this.useful = useful;
    }

    public double getConvolutionFunctionsNumber1() {
        return convolutionFunctionsNumber1;
    }

    public void setConvolutionFunctionsNumber1(double convolutionFunctionsNumber1) {
        this.convolutionFunctionsNumber1 = convolutionFunctionsNumber1;
    }

    public double getConvolutionFunctionsNumber2() {
        return convolutionFunctionsNumber2;
    }

    public void setConvolutionFunctionsNumber2(double convolutionFunctionsNumber2) {
        this.convolutionFunctionsNumber2 = convolutionFunctionsNumber2;
    }
}
