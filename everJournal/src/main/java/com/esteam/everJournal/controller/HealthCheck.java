package com.esteam.everJournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HealthCheck {

    @GetMapping("/health-check")
    String healthCheck(){
        return "Health Okay";
    }
}
