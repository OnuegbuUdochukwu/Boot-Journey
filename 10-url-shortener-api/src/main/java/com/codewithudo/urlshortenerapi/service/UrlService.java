package com.codewithudo.urlshortenerapi.service;

import com.codewithudo.urlshortenerapi.model.UrlMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class UrlService {

    private final ArrayList<UrlMapping> urlMappings = new ArrayList<>();
    int nextId = 1;

    public UrlMapping addUrlMapping(String originalUrl) {
        String shortCode = generateShortCode();
        UrlMapping urlMapping = new UrlMapping(nextId++, originalUrl, shortCode);
        urlMappings.add(urlMapping);
        return urlMapping;
    }

    public String getOriginalUrl(String shortUrl) {
        for (UrlMapping urlMapping : urlMappings) {
            if (urlMapping.getShortCode().equals(shortUrl)) {
                return urlMapping.getOriginalUrl();
            }
        }
        return "Not Found";
    }

    public ArrayList<UrlMapping> getAllUrlMappings() {
        return urlMappings;
    }

    private String generateShortCode() {
        int length = 6;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < length; i++) {
            shortCode.append(chars.charAt(random.nextInt(chars.length())));
        }
        return shortCode.toString();
    }
}
