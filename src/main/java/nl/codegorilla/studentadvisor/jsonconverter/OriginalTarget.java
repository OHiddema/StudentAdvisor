package nl.codegorilla.studentadvisor.jsonconverter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalTarget {
    @JsonProperty("Path")
    private OriginalPath path;
    @JsonProperty("TargetList")
    private OriginalTargetData targetList;

    public OriginalPath getPath() {
        return path;
    }

    public void setPath(OriginalPath path) {
        this.path = path;
    }

    public OriginalTargetData getTargetList() {
        return targetList;
    }

    public void setTargetList(OriginalTargetData targetList) {
        this.targetList = targetList;
    }
}
