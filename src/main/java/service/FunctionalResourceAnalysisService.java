package service;

import model.FunctionalRA;

public class FunctionalResourceAnalysisService {

    public FunctionalRA getValueFromFunctionConvolution(FunctionalRA functionalRA) {
        functionalRA.setConvolutionFunctionsNumber1(functionalRA.getTheMostImportantUseful().getPercent());
        functionalRA.setConvolutionFunctionsNumber2(functionalRA.getUseful().getPercent());
        return functionalRA;
    }
}
