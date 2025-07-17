package com.codewithudo.inventorymanagementapi.service;

import com.codewithudo.inventorymanagementapi.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {

    private final List<InventoryItem> items = new ArrayList<>();
    private int currentId = 1;

    public InventoryItem addItem(InventoryItem item) {
        item.setId(currentId++);
        items.add(item);
        return item;
    }

    public List<InventoryItem> getAllItems() {
        return items;
    }

    public Optional<InventoryItem> getItemById(int id) {
        return items.stream().filter(i -> i.getId() == id).findFirst();
    }

    public Optional<InventoryItem> updateItem(int id, InventoryItem updatedItem) {
        Optional<InventoryItem> existingItemOpt = getItemById(id);
        if (existingItemOpt.isPresent()) {
            InventoryItem existingItem = existingItemOpt.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setQuantity(updatedItem.getQuantity());
            existingItem.setPrice(updatedItem.getPrice());
            return Optional.of(existingItem);
        }
        return Optional.empty();
    }

    public boolean deleteItem(int id) {
        return items.removeIf(i -> i.getId() == id);
    }
}
