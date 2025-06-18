package com.codewithudo.simple_todo_list_api.controllers;

import com.codewithudo.simple_todo_list_api.model.TodoItem;
import com.codewithudo.simple_todo_list_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

    // Constructor injection of the service
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Add a new to-do item
    @PostMapping
    public ArrayList<TodoItem> addItem(@RequestBody TodoItem todoItem) {
        return todoService.addItem(todoItem);
    }

    // Remove a to-do item by passing a TodoItem object
    @DeleteMapping("/{title}")
    public void removeItem(@PathVariable String title) {
        todoService.removeItemByTitle(title);
    }

    // Get all to-do items
    @GetMapping
    public ArrayList<TodoItem> getAllItems() {
        return todoService.getAllItems();
    }

    // Get all to-do items
    @GetMapping("/{index}")
    public TodoItem getItem(@PathVariable int index) {
        return todoService.getItem(index);
    }

    // Get items by title
    @GetMapping("/title/{title}")
    public ArrayList<TodoItem> getItemsByTitle(@PathVariable String title) {
        return todoService.getItemsByTitle(title);
    }

    // Update a to-do item's title
    @PutMapping
    public ArrayList<TodoItem> updateItem(@RequestParam String oldTitle,
                                          @RequestParam String newTitle) {
        return todoService.updateItem(oldTitle, newTitle);
    }
}
