package com.codewithudo.weatherinformationapi.controller;

import com.codewithudo.weatherinformationapi.model.WeatherData;
import com.codewithudo.weatherinformationapi.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService  = new WeatherService();

    @GetMapping
    public ResponseEntity<ArrayList<WeatherData>> getWeatherData(){
       ArrayList<WeatherData> weatherList = weatherService.getWeatherDataList();
        return new ResponseEntity<>(weatherList, HttpStatus.OK);
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherData> getWeatherData(@PathVariable String city){
        WeatherData weatherData = weatherService.getWeatherData(city);
        return new ResponseEntity<>(weatherData, HttpStatus.OK);
    }
}
