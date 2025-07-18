package com.codewithudo.onlinequizapi.model;

import lombok.Data;
import java.util.List;

@Data
public class Question {
    private int id;
    private String text;
    private List<String> options;
    private int correctOptionIndex;
}
