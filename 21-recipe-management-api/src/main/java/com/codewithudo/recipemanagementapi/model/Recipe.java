package com.codewithudo.recipemanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private Integer id;
    private String title;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String category;
}
