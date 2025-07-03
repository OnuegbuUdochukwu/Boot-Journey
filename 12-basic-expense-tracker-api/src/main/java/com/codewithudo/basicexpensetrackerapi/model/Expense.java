package com.codewithudo.basicexpensetrackerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private Integer id;
    private String title;
    private Double amount;
    private String category;
    private String date;
}
