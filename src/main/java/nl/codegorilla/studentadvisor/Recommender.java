package nl.codegorilla.studentadvisor;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommender {

    public static Recommended getRecommendation(Target target) throws IOException {

        String searchTarget = target.getTargetCode();
        List<String> listSearchFor = target.getSteps();

        String fOut = Names.getFilePathString(Names.FILENAME_OUTPUT);
        Map<String, TargetData> patternsFound = JsonHandler.deserialize(fOut, new TypeReference<>() {
        });

        TargetData targetData = patternsFound.get(searchTarget);
        Map<String, Integer> stepScores = new HashMap<>();
        if (targetData != null) {
            // if listSearchFor is empty, run findMatchingPatterns once!
            // it will then return the step most often started with, for this Target
            while (stepScores.isEmpty()) {
                stepScores = findMatchingPatterns(targetData, listSearchFor);
                if (listSearchFor.isEmpty()) break;
                listSearchFor.remove(0);
            }
        }

        List<Map.Entry<String, Integer>> sortedList = sortMapByValue(stepScores);
        return new Recommended(searchTarget, target.getStudentNr(), sortedList);
    }

    private static Map<String, Integer> findMatchingPatterns(TargetData targetData, List<String> listSearchFor) {
        Map<String, Integer> stepScores = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : targetData.getPatterns()) {
            List<String> listSearchIn = entry.getValue();
            int max = listSearchIn.size() - listSearchFor.size();
            outerloop:
            for (int startPosSearchIn = 0; startPosSearchIn < max; startPosSearchIn++) {
                for (int i = 0; i < listSearchFor.size(); i++) {
                    if (!listSearchFor.get(i).equals(listSearchIn.get(startPosSearchIn + i))) {
                        continue outerloop;
                    }
                }
                String stepAdvice = listSearchIn.get(startPosSearchIn + listSearchFor.size());
                if (stepScores.containsKey(stepAdvice)) {
                    stepScores.put(stepAdvice, stepScores.get(stepAdvice) + entry.getKey());
                } else {
                    stepScores.put(stepAdvice, entry.getKey());
                }
                break;
            }
        }
        return stepScores;
    }

    private static List<Map.Entry<String, Integer>> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list;
    }
}