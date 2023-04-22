package nl.codegorilla.studentadvisor.jsonconverter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OriginalJsonEntry {
    @JsonProperty("Target")
    private OriginalTarget target;
    @JsonProperty("User")
    private OriginalUser user;
    @JsonProperty("Steps")
    private List<OriginalStep> steps;

    public OriginalTarget getTarget() {
        return target;
    }

    public void setTarget(OriginalTarget target) {
        this.target = target;
    }

    public OriginalUser getUser() {
        return user;
    }

    public void setUser(OriginalUser user) {
        this.user = user;
    }

    public List<OriginalStep> getSteps() {
        return steps;
    }

    public void setSteps(List<OriginalStep> steps) {
        this.steps = steps;
    }
}
