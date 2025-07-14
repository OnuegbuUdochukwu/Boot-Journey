package com.codewithudo.movielibraryapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer id;
    private String title;
    private String genre;
    private String director;
    private Integer releaseYear;
    private Double rating;
}