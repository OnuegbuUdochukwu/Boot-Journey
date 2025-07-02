package com.codewithudo.staticproductcatalogapi.service;

import com.codewithudo.staticproductcatalogapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    private final ArrayList<Product> products = new ArrayList<>();
    int nextId = 1;

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
