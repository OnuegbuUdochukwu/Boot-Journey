package com.codewithudo.urlshortenerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlMapping {
    private int id;
    private String originalUrl;
    private String shortCode;
}
