package service;

import model.FunctionalRA;
import model.TypeOfFunctionObject;

import java.util.ArrayList;
import java.util.List;

public class FunctionalResourceAnalysisService {

    public List<String> getListFunctionObject() {
        List<String> result = new ArrayList<>();
        for(TypeOfFunctionObject val : TypeOfFunctionObject.values()) {
            result.add(val.getType());
        }
        return result;
    }

    public TypeOfFunctionObject getFunctionalObjectByString(String str) {
        for(TypeOfFunctionObject val : TypeOfFunctionObject.values()) {
            if (val.getType().equals(str)) return val;
        }
        return null;
    }

    public FunctionalRA getValueFromFunctionConvolution(FunctionalRA functionalRA) {
        functionalRA.setConvolutionFunctionsNumber1(functionalRA.getTheMostImportantUseful().getPercent());
        functionalRA.setConvolutionFunctionsNumber2(functionalRA.getUseful().getPercent());
        return functionalRA;
    }
}
