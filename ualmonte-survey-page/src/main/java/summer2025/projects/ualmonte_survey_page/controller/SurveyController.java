package summer2025.projects.ualmonte_survey_page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import summer2025.projects.ualmonte_survey_page.entity.SurveyRecord;
import summer2025.projects.ualmonte_survey_page.repository.SurveyRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/surveyapi")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping("/getSurveyRecords")
    public ResponseEntity<List<SurveyRecord>> getSurveyRecords() {

	return new ResponseEntity<List<SurveyRecord>>(surveyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getSurveyRecord/{id}")
    public ResponseEntity<SurveyRecord> getSurveyRecords(@PathVariable Long id) {
	try {
	    SurveyRecord record = surveyRepository.findById(id).get();
	    return new ResponseEntity<SurveyRecord>(record, HttpStatus.OK);

	} catch (Exception e) {
	    return new ResponseEntity<SurveyRecord>(new SurveyRecord(), HttpStatus.NOT_FOUND);
	}

    }

    @PostMapping(value = "/submitSurveyRecord", consumes = { "application/json" })
    public ResponseEntity<Long> submitSurveyRecord(@RequestBody SurveyRecord record) {
	Long createdSurveyRecordId = surveyRepository.save(record).getId();
	return new ResponseEntity<Long>(createdSurveyRecordId, HttpStatus.OK);
    }

    @DeleteMapping("/removeSurveyRecord/{id}")
    public ResponseEntity<String> removeSurveyRecord(@PathVariable Long id) {

	try {
	    if (surveyRepository.findById(id).get() != null) {
		surveyRepository.deleteById(id);
		return new ResponseEntity<String>("Delete Successful", HttpStatus.OK);
	    }
	} catch (Exception e) {
	    return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	return null;
    }

    @PutMapping("/updateSurveyRecord/{id}")
    public SurveyRecord updateSurveyRecord(@PathVariable Long id, @RequestBody SurveyRecord updateSurveyRecord) {
	SurveyRecord survey = surveyRepository.findById(id).get();
	if (survey != null) {
	    updateSurveyRecord(survey, updateSurveyRecord);
	    surveyRepository.save(survey);
	    return survey;
	}
	return null;

    }

    private void updateSurveyRecord(SurveyRecord survey, SurveyRecord updateSurveyRecord) {
	survey.setFirstName(updateSurveyRecord.getFirstName());
	survey.setLastName(updateSurveyRecord.getLastName());
	survey.setStreetAddress(updateSurveyRecord.getStreetAddress());
	survey.setCity(updateSurveyRecord.getCity());
	survey.setState(updateSurveyRecord.getState());
	survey.setZipcode(updateSurveyRecord.getZipcode());
	survey.setTelephone(updateSurveyRecord.getTelephone());
	survey.setEmail(updateSurveyRecord.getEmail());
	survey.setDateOfSurvey(updateSurveyRecord.getDateOfSurvey());
	survey.setInterest(updateSurveyRecord.getInterest());
	survey.setLikes(updateSurveyRecord.getLikes());
	survey.setRecommending(updateSurveyRecord.getRecommending());
    }
}
