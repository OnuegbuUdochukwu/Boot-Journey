package com.codewithudo.systemhealthcheckapi.controller;

import com.codewithudo.systemhealthcheckapi.model.HealthStatus;
import com.codewithudo.systemhealthcheckapi.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/status")
    public ResponseEntity<HealthStatus> getHealthStatus() {
        return new ResponseEntity<>(healthService.checkSystemHealth(), HttpStatus.OK);
    }

    @GetMapping("/uptime")
    public ResponseEntity<Long> getUptime() {
        return new ResponseEntity<>(healthService.checkSystemHealth().getUptimeInSeconds(), HttpStatus.OK);
    }
}
