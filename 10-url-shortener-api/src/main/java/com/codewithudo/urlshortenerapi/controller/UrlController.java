package com.codewithudo.urlshortenerapi.controller;

import com.codewithudo.urlshortenerapi.model.UrlMapping;
import com.codewithudo.urlshortenerapi.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<UrlMapping> addUrlMapping(@RequestBody String originalUrl) {
        UrlMapping urlMapping = urlService.addUrlMapping(originalUrl);
        return new ResponseEntity<>(urlMapping, HttpStatus.CREATED);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<String> getUrlMapping(@PathVariable String shortCode) {
        String originalUrl = urlService.getOriginalUrl(shortCode);
        if (originalUrl.equals("Not Found")) {
            return new ResponseEntity<>("URL not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(originalUrl, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<ArrayList<UrlMapping>> getAllMappings() {
        return new ResponseEntity<>(urlService.getAllUrlMappings(), HttpStatus.OK);
    }
}
