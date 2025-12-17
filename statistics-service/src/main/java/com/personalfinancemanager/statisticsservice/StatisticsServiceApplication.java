package com.personalfinancemanager.statisticsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StatisticsServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(StatisticsServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StatisticsServiceApplication.class, args);
    }

    @PostMapping("/calculate")
    public String calculateStatistics(@RequestBody String transactionData) {
        // In a real application, transactionData would be a structured JSON object
        log.info("Received data for statistics calculation: {}", transactionData);
        // Simple stub logic
        String report = "Statistics calculated for: " + transactionData;
        log.info(report);
        return report;
    }
}
