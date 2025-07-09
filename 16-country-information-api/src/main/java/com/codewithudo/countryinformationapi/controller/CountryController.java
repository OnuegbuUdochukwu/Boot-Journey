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

    // Add a new country
    @PostMapping
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        boolean added = countryService.addCountry(country);
        if (added) {
            return new ResponseEntity<>("Country added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add country", HttpStatus.BAD_REQUEST);
    }

    // Get all countries
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    // Get a country by ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable int id) {
        Country country = countryService.getCountryById(id);
        if (country != null) {
            return new ResponseEntity<>(country, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a country by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCountry(@PathVariable int id, @RequestBody Country country) {
        boolean updated = countryService.updateCountry(id, country);
        if (updated) {
            return new ResponseEntity<>("Country updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Country not found", HttpStatus.NOT_FOUND);
    }

    // Delete a country by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable int id) {
        boolean deleted = countryService.deleteCountry(id);
        if (deleted) {
            return new ResponseEntity<>("Country deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Country not found", HttpStatus.NOT_FOUND);
    }
}
