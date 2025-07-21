package com.codewithudo.timezoneconversionapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimezoneRequest {
    private LocalDateTime datetime;
    private String sourceTimezone;
    private String targetTimezone;
}
