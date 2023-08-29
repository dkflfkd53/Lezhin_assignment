package com.example.lezhinassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LezhinAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(LezhinAssignmentApplication.class, args);
    }

}
