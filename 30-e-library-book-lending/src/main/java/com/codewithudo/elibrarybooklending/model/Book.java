package com.codewithudo.elibrarybooklending.model;


import lombok.Data;


@Data
public class Book {

    private Long id;

    private String title;
    private String author;

    private boolean borrowed = false;
}