package nl.codegorilla.studentadvisor;

import nl.codegorilla.studentadvisor.jsonconverter.JsonConverter;
import nl.codegorilla.studentadvisor.jsonconverter.OriginalJsonEntry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@RestController
public class Controller {

    // process all leaning data (this request may get too large in the future!)
    @PostMapping("/alldata")
    @ResponseBody
    public ResponseEntity<?> getAllData(@RequestBody List<OriginalJsonEntry> jsonEntryList) {
        try {
            TargetList targetList = JsonConverter.convertAllData(jsonEntryList);
            Main.buidPatterns(targetList);
        } catch (Exception e) {
            String errorMessage = "Failed to process the data" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    // accept a student request for advice and return it
    @PostMapping("/advice")
    @ResponseBody
    public ResponseEntity<?> getAdvice(@RequestBody OriginalJsonEntry jsonEntry) {
        try {
            Target target = JsonConverter.convertStudentRequest(jsonEntry);
            Recommended recommended = Recommender.getRecommendation(target);
            return ResponseEntity.ok(recommended);
        } catch (Exception e) {
            String errorMessage = "Failed to construct a recommendation: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}