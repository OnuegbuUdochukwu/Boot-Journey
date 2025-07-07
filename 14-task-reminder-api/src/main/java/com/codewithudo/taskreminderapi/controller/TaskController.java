package com.codewithudo.taskreminderapi.controller;

import com.codewithudo.taskreminderapi.model.Task;
import com.codewithudo.taskreminderapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        boolean added = taskService.addTask(task);
        if (added) {
            return new ResponseEntity<>("Task added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Task not added", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task) {
        boolean updated = taskService.updateTask(id, task);
        if (updated) {
            return new ResponseEntity<>("Task updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        boolean deleted = taskService.deleteTask(id);
        if (deleted) {
            return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
    }
}
