package com.codewithudo.musicalbummanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private Integer id;
    private String title;
    private String artist;
    private Integer releaseYear;
    private String genre;
}