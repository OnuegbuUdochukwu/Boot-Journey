package com.codewithudo.onlinequizapi.model;

import lombok.Data;
import java.util.List;

@Data
public class AnswerSubmission {
    private List<Integer> selectedOptionIndices;
}
