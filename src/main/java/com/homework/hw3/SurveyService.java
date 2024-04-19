package com.homework.hw3;

import com.homework.hw3.Survey;
import com.homework.hw3.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    // Save a new survey
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    // Retrieve all surveys
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Find a survey by ID
    public Survey findSurveyById(Long id) {
        return surveyRepository.findById(id).orElse(null); // Return Survey or null
    }

    // Update an existing survey
    public Survey updateSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    // Delete a survey by ID
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
    
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);  // This uses the JpaRepository's save method
    }
}
