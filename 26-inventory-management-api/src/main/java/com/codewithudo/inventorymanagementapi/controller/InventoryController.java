package com.codewithudo.inventorymanagementapi.controller;

import com.codewithudo.inventorymanagementapi.model.InventoryItem;
import com.codewithudo.inventorymanagementapi.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Add a new item
    @PostMapping
    public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
        InventoryItem createdItem = inventoryService.addItem(item);
        return ResponseEntity.ok(createdItem);
    }

    // Get all items
    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllItems() {
        return ResponseEntity.ok(inventoryService.getAllItems());
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {
        return inventoryService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update item by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable int id, @RequestBody InventoryItem updatedItem) {
        return inventoryService.updateItem(id, updatedItem)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        boolean deleted = inventoryService.deleteItem(id);
        if (deleted) {
            return ResponseEntity.ok("Item deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
