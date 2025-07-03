package com.codewithudo.simplepollingappapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    private Integer id;
    private String text;
    private Integer votes;
}