package com._8.urlShortner.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LoggerService {
    private static final String LOG_SERVER_URL = "http://20.244.56.144/evaluation-service/logs";

    public void log(String stack, String level, String packageName, String message) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> logData = Map.of(
                "stack", stack,
                "level", level,
                "package", packageName,
                "message", message
        );

        try {
            restTemplate.postForObject(LOG_SERVER_URL, logData, String.class);
        } catch (Exception e) {
            System.out.println("Failed to test: " + e.getMessage());
        }
    }
}