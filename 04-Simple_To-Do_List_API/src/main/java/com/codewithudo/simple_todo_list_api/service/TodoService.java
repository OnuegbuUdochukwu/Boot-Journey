package com.codewithudo.simple_todo_list_api.service;

import com.codewithudo.simple_todo_list_api.model.TodoItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final ArrayList<TodoItem> items = new ArrayList<>();

    public ArrayList<TodoItem> addItem(TodoItem todoItem) {
        items.add(todoItem);
        return items;
    }

    public void removeItemByTitle(String title) {
        items.removeIf(item -> item.getTitle().equals(title));
    }


    public ArrayList<TodoItem> getAllItems() {
        return items;
    }

    public TodoItem getItem(int index) {
        return items.get(index);
    }

    public ArrayList<TodoItem> getItemsByTitle(String title) {
        return (ArrayList<TodoItem>)
                items.stream()
                        .filter(item -> item.getTitle()
                                        .equals(title))
                        .collect(Collectors.toList());

    }
    public ArrayList<TodoItem> updateItem(String oldTitle, String newTitle) {
        for (TodoItem item : items) {
            if (item.getTitle().equals(oldTitle)) {
                item.setTitle(newTitle);
                break; // Stop after finding the first match
            }
        }
        return items;
    }
}
