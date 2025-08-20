package com.codewithudo.grocerylistapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int quantity;

    private boolean purchased = false;
}

