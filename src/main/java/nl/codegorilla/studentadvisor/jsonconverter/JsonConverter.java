package nl.codegorilla.studentadvisor.jsonconverter;

import nl.codegorilla.studentadvisor.Target;
import nl.codegorilla.studentadvisor.TargetList;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    public static TargetList convertAllData(List<OriginalJsonEntry> originalJsonList) {
        // convert this to the desired data structure
        TargetList desiredJson = new TargetList();
        List<Target> desiredTargets = new ArrayList<>();
        for (OriginalJsonEntry jsonEntry : originalJsonList) {
            Target desiredTarget = new Target();
            desiredTarget.setStudentNr(Integer.toString(jsonEntry.getUser().getStudentID()));
            desiredTarget.setTargetCode(jsonEntry.getTarget().getTargetList().getTargetCode());
            List<String> desiredSteps = new ArrayList<>();
            for (OriginalStep originalStep : jsonEntry.getSteps()) {
                desiredSteps.add(originalStep.getStepList().getStepCode());
            }
            desiredTarget.setSteps(desiredSteps);
            desiredTargets.add(desiredTarget);
        }
        desiredJson.setTargets(desiredTargets);
        return desiredJson;
    }

    public static Target convertStudentRequest(OriginalJsonEntry jsonEntry) {
        Target desiredTarget = new Target();
        desiredTarget.setStudentNr(Integer.toString(jsonEntry.getUser().getStudentID()));
        desiredTarget.setTargetCode(jsonEntry.getTarget().getTargetList().getTargetCode());
        List<String> desiredSteps = new ArrayList<>();
        for (OriginalStep originalStep : jsonEntry.getSteps()) {
            desiredSteps.add(originalStep.getStepList().getStepCode());
        }
        desiredTarget.setSteps(desiredSteps);
        return desiredTarget;
    }
}