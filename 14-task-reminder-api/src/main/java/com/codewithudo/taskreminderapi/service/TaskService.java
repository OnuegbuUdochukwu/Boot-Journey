package com.codewithudo.taskreminderapi.service;

import com.codewithudo.taskreminderapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public boolean addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return true;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public boolean updateTask(int id, Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setReminderTime(updatedTask.getReminderTime());
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }
}
