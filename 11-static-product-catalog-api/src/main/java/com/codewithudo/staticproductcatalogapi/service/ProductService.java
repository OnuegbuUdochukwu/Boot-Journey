package com.codewithudo.staticproductcatalogapi.service;

import com.codewithudo.staticproductcatalogapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    private final ArrayList<Product> products = new ArrayList<>();
    int nextId = 1;


}
