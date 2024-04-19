package com.homework.hw3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Hw3Application {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public static void main(String[] args) {
        SpringApplication.run(Hw3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("DB URL: " + dbUrl);
            System.out.println("DB Username: " + dbUsername);
            // Don't log the password in production
            System.out.println("DB Password: " + dbPassword);
        };
    }
}