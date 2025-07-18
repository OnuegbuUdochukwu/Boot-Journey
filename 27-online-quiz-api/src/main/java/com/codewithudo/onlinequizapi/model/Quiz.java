package com.codewithudo.onlinequizapi.model;

import lombok.Data;
import java.util.List;

@Data
public class Quiz {
    private int id;
    private String title;
    private List<Question> questions;
}
