package com.codewithudo.countryinformationapi.controller;

import com.codewithudo.countryinformationapi.model.Country;
import com.codewithudo.countryinformationapi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Get a country Info by Name
    @GetMapping("/{country}")
    public ResponseEntity<String> getCountryInfoByName(@PathVariable String country) {
        String result = countryService.getCountryInfo(country);
        if (result.equals("Could not retrieve data")) {
            return new ResponseEntity<>("Country information not found or API error.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
