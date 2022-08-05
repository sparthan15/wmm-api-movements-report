package com.wmm.movements.report.infrastructure;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovementReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovementReportApplication.class, args);
    }

}