package com.codewithudo.timezoneconversionapi.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class TimezoneResponse {
    private LocalDateTime originalDatetime;
    private String sourceTimezone;
    private LocalDateTime convertedDatetime;
    private String targetTimezone;

}
