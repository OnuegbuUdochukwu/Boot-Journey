package com.codewithudo.weatherinformationapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {

    @JsonProperty("name")
    private String city;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("weather")
    private Weather[] weather;

    public static class Main {
        @JsonProperty("temp")
        private double temp;

        public double getTemp() {
            return temp;
        }
    }

    public static class Weather {
        @JsonProperty("description")
        private String description;

        public String getDescription() {
            return description;
        }
    }

    public String getCity() {
        return city;
    }

    public double getTemp() {
        return main != null ? main.getTemp() : 0.0;
    }

    public String getDescription() {
        return (weather != null && weather.length > 0) ? weather[0].getDescription() : "Unknown";
    }

}
