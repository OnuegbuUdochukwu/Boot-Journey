package com.codewithudo.inventorymanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}
