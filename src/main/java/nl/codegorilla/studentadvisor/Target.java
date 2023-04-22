package nl.codegorilla.studentadvisor;

import java.util.List;

public class Target {
    private String studentNr;
    private String targetCode;
    private List<String> steps;

    // Jackson library requires that getters are defined for ALL fields!
    public String getStudentNr() {
        return studentNr;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setStudentNr(String studentNr) {
        this.studentNr = studentNr;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}