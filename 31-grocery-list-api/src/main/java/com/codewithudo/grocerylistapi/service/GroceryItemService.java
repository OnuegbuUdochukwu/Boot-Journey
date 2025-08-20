package com.codewithudo.grocerylistapi.service;

import com.codewithudo.grocerylistapi.model.GroceryItem;
import com.codewithudo.grocerylistapi.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public GroceryItem addItem(GroceryItem item) {
        return repository.save(item);
    }

    public Optional<GroceryItem> updateItem(Long id, GroceryItem updatedItem) {
        return repository.findById(id).map(existingItem -> {
            existingItem.setName(updatedItem.getName());
            existingItem.setQuantity(updatedItem.getQuantity());
            return repository.save(existingItem);
        });
    }

    public boolean deleteItem(Long id) {
        return repository.findById(id).map(item -> {
            repository.delete(item);
            return true;
        }).orElse(false);
    }
}
