package com.homework.hw3;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This annotation tells Hibernate to make a table out of this class
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String telephone;
    private String email;
    
    @Column(columnDefinition = "DATE")
    private LocalDate surveyDate;

    private String campusPreferences; // Concatenated string of checked preferences
    private String interestSource; // Radio button selection
    private String likelihoodOfRecommending;
    private String raffleNumbers;
    private String additionalComments;

    
    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(LocalDate surveyDate) {
        this.surveyDate = surveyDate;
    }

    public String getCampusPreferences() {
        return campusPreferences;
    }

    public void setCampusPreferences(String campusPreferences) {
        this.campusPreferences = campusPreferences;
    }

    public String getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(String interestSource) {
        this.interestSource = interestSource;
    }

    public String getLikelihoodOfRecommending() {
        return likelihoodOfRecommending;
    }

    public void setLikelihoodOfRecommending(String likelihoodOfRecommending) {
        this.likelihoodOfRecommending = likelihoodOfRecommending;
    }

    public String getRaffleNumbers() {
        return raffleNumbers;
    }

    public void setRaffleNumbers(String raffleNumbers) {
        this.raffleNumbers = raffleNumbers;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    
}
