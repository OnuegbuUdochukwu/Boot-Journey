package com.codewithudo.temperatureconverterapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TemperatureController {
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }

    @GetMapping("/convert")
    public Map<String, String> convertTemperature(
            @RequestParam("value") double original ,
            @RequestParam("fromUnit") String from,
            @RequestParam("toUnit") String to) {

        if (from.equals("C") && to.equals("F")) {
            return Map.of(
                    "originalValue", String.format("%.2fC", original),
                    "convertedValue", String.format("%.2fF", celsiusToFahrenheit(original))
            );
        }
        else if (from.equals("C") && to.equals("K")) {
            return Map.of(
                    "originalValue", String.format("%.2fC", original),
                    "convertedValue", String.format("%.2fK", celsiusToKelvin(original))
            );
        }
        else if (from.equals("K") && to.equals("C")) {
            return Map.of(
                    "originalValue", String.format("%.2fK", original),
                    "convertedValue", String.format("%.2fC", kelvinToCelsius(original))
            );
        }
        else if (from.equals("F") && to.equals("C")) {
            return Map.of(
                    "originalValue", String.format("%.2fF", original),
                    "convertedValue", String.format("%.2fC", fahrenheitToCelsius(original))
            );
        }
        else if (from.equals("K") && to.equals("F")) {
            return Map.of(
                    "originalValue", String.format("%.2fK", original),
                    "convertedValue", String.format("%.2fF", kelvinToFahrenheit(original))
            );
        }
        else if (from.equals("F") && to.equals("K")) {
            return Map.of(
                    "originalValue", String.format("%.2fF", original),
                    "convertedValue", String.format("%.2fK", fahrenheitToKelvin(original))
            );
        }
        else {
            return Map.of(
                    "originalValue", null,
                    "convertedValue", null
            );
        }
    }
}
