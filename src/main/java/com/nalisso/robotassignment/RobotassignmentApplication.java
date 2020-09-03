package com.nalisso.robotassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nalisso.robotassignment.*")
public class RobotassignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotassignmentApplication.class, args);
    }

}
