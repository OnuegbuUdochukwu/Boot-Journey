package com.codewithudo.inventorymanagementapi.service;

import com.codewithudo.inventorymanagementapi.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {

    private final Map<Integer, InventoryItem> inventory = new HashMap<>();
    private int currentId = 1;

    // Add new item
    public InventoryItem addItem(InventoryItem item) {
        item.setId(currentId++);
        inventory.put(item.getId(), item);
        return item;
    }

    // Get all items
    public List<InventoryItem> getAllItems() {
        return new ArrayList<>(inventory.values());
    }

    // Get item by ID
    public Optional<InventoryItem> getItemById(int id) {
        return Optional.ofNullable(inventory.get(id));
    }

    // Update item by ID
    public Optional<InventoryItem> updateItem(int id, InventoryItem updatedItem) {
        if (inventory.containsKey(id)) {
            updatedItem.setId(id);
            inventory.put(id, updatedItem);
            return Optional.of(updatedItem);
        } else {
            return Optional.empty();
        }
    }

    // Delete item by ID
    public boolean deleteItem(int id) {
        return inventory.remove(id) != null;
    }
}
