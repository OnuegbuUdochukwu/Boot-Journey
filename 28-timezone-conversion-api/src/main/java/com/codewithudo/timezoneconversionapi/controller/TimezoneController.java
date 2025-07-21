package com.codewithudo.timezoneconversionapi.controller;

import com.codewithudo.timezoneconversionapi.model.TimezoneRequest;
import com.codewithudo.timezoneconversionapi.model.TimezoneResponse;
import com.codewithudo.timezoneconversionapi.service.TimezoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timezone")
public class TimezoneController {

    private final TimezoneService timezoneService;

    @Autowired
    public TimezoneController(TimezoneService timezoneService) {
        this.timezoneService = timezoneService;
    }

    @PostMapping("/convert")
    public TimezoneResponse convertTimezone(@RequestBody TimezoneRequest request) {
        return timezoneService.convertTimezone(request);
    }
}
