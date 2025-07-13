package com.codewithudo.personaldiaryapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryEntry {
    private Integer id;
    private String title;
    private String content;
    private String date;
    private String mood;
}