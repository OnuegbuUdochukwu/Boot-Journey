package com.codewithudo.taskreminderapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    // Getters and Setters
    private Integer id;
    private String title;
    private String description;
    private String reminderTime;
}
