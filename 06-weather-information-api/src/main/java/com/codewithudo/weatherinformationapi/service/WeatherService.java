package com.codewithudo.weatherinformationapi.service;

import com.codewithudo.weatherinformationapi.model.WeatherData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WeatherService {

    private final ArrayList<WeatherData> weatherDataList = new ArrayList<>();

    // Constructor: Populate static data when service starts
    public WeatherService() {
        weatherDataList.add(new WeatherData("Lagos", 31.5, "Sunny"));
        weatherDataList.add(new WeatherData("Abuja", 29.0, "Cloudy"));
        weatherDataList.add(new WeatherData("London", 17.8, "Rainy"));
        weatherDataList.add(new WeatherData("New York", 23.0, "Partly Cloudy"));
    }
    public ArrayList<WeatherData> getWeatherDataList() {
        return weatherDataList;

    }
    public WeatherData getWeatherData(String city) {
        return weatherDataList.stream()
                .filter(data -> data.getCity().equalsIgnoreCase(city))
                .findFirst()
                .orElse(null);
    }
}
