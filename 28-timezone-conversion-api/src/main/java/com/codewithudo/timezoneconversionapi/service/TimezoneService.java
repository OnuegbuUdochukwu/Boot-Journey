package com.codewithudo.timezoneconversionapi.service;

import com.codewithudo.timezoneconversionapi.model.TimezoneRequest;
import com.codewithudo.timezoneconversionapi.model.TimezoneResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TimezoneService {

    public TimezoneResponse convertTimezone(TimezoneRequest request) {
        // Extract values from request
        LocalDateTime localDateTime = request.getDatetime();
        String sourceZone = request.getSourceTimezone();
        String targetZone = request.getTargetTimezone();

        // Convert LocalDateTime to source zone time
        ZonedDateTime sourceZoned = localDateTime.atZone(ZoneId.of(sourceZone));

        // Convert source zone time to target zone
        ZonedDateTime targetZoned = sourceZoned.withZoneSameInstant(ZoneId.of(targetZone));

        // Populate the response
        TimezoneResponse response = new TimezoneResponse();
        response.setOriginalDatetime(localDateTime);
        response.setSourceTimezone(sourceZone);
        response.setConvertedDatetime(targetZoned.toLocalDateTime());
        response.setTargetTimezone(targetZone);

        return response;
    }
}
