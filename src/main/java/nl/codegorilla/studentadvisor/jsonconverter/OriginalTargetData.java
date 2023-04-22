package nl.codegorilla.studentadvisor.jsonconverter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalTargetData {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("TargetCode")
    private String targetCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }
}
