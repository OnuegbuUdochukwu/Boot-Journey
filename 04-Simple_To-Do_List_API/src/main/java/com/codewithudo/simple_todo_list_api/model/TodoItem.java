package com.codewithudo.simple_todo_list_api.model;

import lombok.*;

@Data  // Generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor  // Generates a constructor with all fields
@NoArgsConstructor
public class TodoItem {
    private int id;
    private String title;
    private boolean completed;

}
