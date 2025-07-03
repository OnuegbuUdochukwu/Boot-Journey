package com.codewithudo.simplepollingappapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poll {
    private Integer id;
    private String question;
    private List<Option> options;
}