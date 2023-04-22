package nl.codegorilla.studentadvisor.jsonconverter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalStepData {
    @JsonProperty("StepCode")
    private String stepCode;

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }
}
