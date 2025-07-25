package com.codewithudo.systemhealthcheckapi.service;

import com.codewithudo.systemhealthcheckapi.model.HealthStatus;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    private final long startTime;

    public HealthService() {
        this.startTime = System.currentTimeMillis();
    }

    public HealthStatus checkSystemHealth() {
        long uptime = (System.currentTimeMillis() - startTime) / 1000;

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);

        return new HealthStatus("OK", uptime, usedMemory, totalMemory);
    }
}
