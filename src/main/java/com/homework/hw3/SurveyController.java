package com.homework.hw3;

import com.homework.hw3.Survey;
import com.homework.hw3.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    // Create a new survey
    @PostMapping
    public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey) {
        return ResponseEntity.ok(surveyService.saveSurvey(survey));
    }

    // Get all surveys
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

    // Get a single survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return ResponseEntity.ok(surveyService.findSurveyById(id));
    }

    // Update a survey
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        Survey existingSurvey = surveyService.findSurveyById(id);
        if (existingSurvey == null) {
            return ResponseEntity.notFound().build();
        }

        // Assuming setters handle null checks or similar logic
        existingSurvey.setFirstName(surveyDetails.getFirstName());
        existingSurvey.setLastName(surveyDetails.getLastName());
        existingSurvey.setStreetAddress(surveyDetails.getStreetAddress());
        existingSurvey.setCity(surveyDetails.getCity());
        existingSurvey.setState(surveyDetails.getState());
        existingSurvey.setZip(surveyDetails.getZip());
        existingSurvey.setTelephone(surveyDetails.getTelephone());
        existingSurvey.setEmail(surveyDetails.getEmail());
        existingSurvey.setSurveyDate(surveyDetails.getSurveyDate());
        existingSurvey.setCampusPreferences(surveyDetails.getCampusPreferences());
        existingSurvey.setInterestSource(surveyDetails.getInterestSource());
        existingSurvey.setLikelihoodOfRecommending(surveyDetails.getLikelihoodOfRecommending());
        existingSurvey.setRaffleNumbers(surveyDetails.getRaffleNumbers());
        existingSurvey.setAdditionalComments(surveyDetails.getAdditionalComments());
        

        Survey updatedSurvey = surveyService.updateSurvey(existingSurvey);
        return ResponseEntity.ok(updatedSurvey);
    }


    // Delete a survey
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
        return ResponseEntity.ok().build();  // .ok().build() returns an empty body with status 200
    }
}
