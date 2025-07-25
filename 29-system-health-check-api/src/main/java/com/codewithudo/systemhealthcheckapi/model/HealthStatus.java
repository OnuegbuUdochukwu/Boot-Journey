package com.codewithudo.systemhealthcheckapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthStatus {
    private String status;
    private long uptimeInSeconds;
    private long memoryUsedInMB;
    private long totalMemoryInMB;
}
