package com.codewithudo.vehicleregistryapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private Integer id;
    private String registrationNumber;
    private String ownerName;
    private String model;
    private String manufacturer;
    private Integer year;
    private String color;
}
