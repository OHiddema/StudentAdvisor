package nl.codegorilla.studentadvisor;

import nl.codegorilla.studentadvisor.jsonconverter.JsonConverter;
import nl.codegorilla.studentadvisor.jsonconverter.OriginalJsonEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @PostMapping("/alldata")
    public void getAllData(@RequestBody List<OriginalJsonEntry> jsonEntryList) throws IOException {
        TargetList desiredJson = JsonConverter.changeJsonFormatAllData(jsonEntryList);
        Main.buidPatterns(desiredJson);
    }

    @PostMapping("/advice")
    @ResponseBody
    public ResponseEntity<?> getAdvice(@RequestBody OriginalJsonEntry jsonEntry) {
        Target target = JsonConverter.changeJsonFormatStudentRequest(jsonEntry);
        Recommended recommended;
        try {
            recommended = Recommender.getRecommendation(target);
        } catch (Exception e) {
            String errorMessage = "Failed to construct a recommendation: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        return ResponseEntity.ok(recommended);
    }
}