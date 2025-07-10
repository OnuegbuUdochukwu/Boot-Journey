package com.codewithudo.countryinformationapi.service;

import com.codewithudo.countryinformationapi.model.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    @Value("${api.ninjas.base-url}")
    private String baseUrl;

    @Value("${api.ninjas.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getCountryInfo(String country) {
        String url = baseUrl + "?name=" + country;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "Could not retrieve data";
        }
    }

}
