package com.codewithudo.currencyconverterapi.controller;

import com.codewithudo.currencyconverterapi.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    // GET /api/currency/rates - get all exchange rates
    @GetMapping("/rates")
    public ResponseEntity<Map<String, Double>> getExchangeRates() {
        return new ResponseEntity<>(currencyService.getExchangeRates(), HttpStatus.OK);
    }

    // GET /api/currency/convert?from=USD&to=EUR&amount=100
    @GetMapping("/convert")
    public ResponseEntity<?> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
        try {
            double result = currencyService.convert(from, to, amount);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Unsupported currency type.", HttpStatus.BAD_REQUEST);
        }
    }
}
