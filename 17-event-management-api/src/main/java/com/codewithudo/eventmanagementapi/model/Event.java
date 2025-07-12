package com.codewithudo.eventmanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Integer id;
    private String name;
    private String location;
    private String date;
    private String time;
    private String description;
}
