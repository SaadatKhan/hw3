package com.homework.hw3;

import com.homework.hw3.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    // Spring Data JPA provides CRUD operations by default
}