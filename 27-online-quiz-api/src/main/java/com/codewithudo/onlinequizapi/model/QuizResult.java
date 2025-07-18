package com.codewithudo.onlinequizapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResult {
    private int totalQuestions;
    private int correctAnswers;
    private double scorePercent;
}