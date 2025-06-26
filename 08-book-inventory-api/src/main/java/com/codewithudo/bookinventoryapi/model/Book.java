package com.codewithudo.bookinventoryapi.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int  id;
    private String title;
    private String author;
    private String isbn;
    private double price;
}
