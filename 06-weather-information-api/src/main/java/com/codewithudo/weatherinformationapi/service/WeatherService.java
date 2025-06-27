package com.codewithudo.weatherinformationapi.service;

import com.codewithudo.weatherinformationapi.model.OpenWeatherResponse;
import com.codewithudo.weatherinformationapi.model.WeatherData;
//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

//    private final ArrayList<WeatherData> weatherDataList = new ArrayList<>();

//    // Constructor: Populate static data when service starts
//    public WeatherService() {
//        weatherDataList.add(new WeatherData("Lagos", 31.5, "Sunny"));
//        weatherDataList.add(new WeatherData("Abuja", 29.0, "Cloudy"));
//        weatherDataList.add(new WeatherData("London", 17.8, "Rainy"));
//        weatherDataList.add(new WeatherData("New York", 23.0, "Partly Cloudy"));
//    }
//    public ArrayList<WeatherData> getWeatherDataList() {
//        return weatherDataList;
//    }



    public WeatherData getWeatherData(String city) {
//        String url = String.format("%s?q=%s&units=metric&appid=%s", apiUrl, city, apiKey);
        String url = apiUrl + "?q=" + city + "&units=metric&appid=" + apiKey;
//        System.out.println("API URL: " + apiUrl);
//        System.out.println("API Key: " + apiKey);

        try {
            OpenWeatherResponse response = restTemplate.getForObject(url, OpenWeatherResponse.class);
            if (response != null) {
                return new WeatherData(response.getCity(), response.getTemp(), response.getDescription());
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
            return null;
        }

    }
}
