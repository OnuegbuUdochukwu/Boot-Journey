package com.codewithudo.countryinformationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private Integer id;
    private String name;
    private String capital;
    private String region;
    private Long population;
    private String currency;
}
