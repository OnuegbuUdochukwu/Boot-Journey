package com.codewithudo.staticproductcatalogapi.service;

import com.codewithudo.staticproductcatalogapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    private final ArrayList<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Wireless Mouse", "Ergonomic wireless mouse", 15.99, true));
        products.add(new Product(2, "Mechanical Keyboard", "RGB backlit mechanical keyboard", 45.50, true));
        products.add(new Product(3, "USB-C Charger", "Fast-charging USB-C charger", 18.00, false));
        products.add(new Product(4, "Noise Cancelling Headphones", "Bluetooth over-ear headphones", 75.99, true));
    }

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
