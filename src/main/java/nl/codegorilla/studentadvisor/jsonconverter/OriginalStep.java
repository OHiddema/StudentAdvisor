package nl.codegorilla.studentadvisor.jsonconverter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalStep {
    @JsonProperty("StepPosition")
    private int stepPosition;
    @JsonProperty("StepList")
    private OriginalStepData stepList;

    public int getStepPosition() {
        return stepPosition;
    }

    public void setStepPosition(int stepPosition) {
        this.stepPosition = stepPosition;
    }

    public OriginalStepData getStepList() {
        return stepList;
    }

    public void setStepList(OriginalStepData stepList) {
        this.stepList = stepList;
    }
}
