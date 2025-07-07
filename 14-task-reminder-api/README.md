# 📝 Task Reminder API

A simple Spring Boot REST API for managing an in-memory list of tasks with reminder times.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**14-task-reminder-api**

---

## 📖 Features

- Add a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update a task by ID
- Delete a task by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint            | Description                  |
|:--------|:----------------------|:------------------------------|
| `GET`    | `/api/tasks`           | Get all tasks                  |
| `GET`    | `/api/tasks/{id}`      | Get a task by its ID           |
| `POST`   | `/api/tasks`           | Add a new task                 |
| `PUT`    | `/api/tasks/{id}`      | Update a task by its ID        |
| `DELETE` | `/api/tasks/{id}`      | Delete a task by its ID        |

---

## 📬 Sample JSON Request

**For `POST /api/tasks`**
```json
{
  "title": "Finish Spring Boot project",
  "description": "Complete the TaskReminder API",
  "reminderTime": "2025-07-07 21:00"
}
```
---
## What Each Class Does

### Task.java (Model)
A simple POJO representing a task.

#### Fields:
- `id` (Integer)
- `title` (String)
- `description` (String)
- `reminderTime` (String)

### TaskService.java (Service)
Contains business logic and an in-memory list to store tasks.

#### Responsibilities:
- Add new tasks
- Get all tasks
- Get task by ID
- Update task details
- Delete task by ID

### TaskController.java (Controller)
Handles HTTP requests from clients.

#### Exposes these endpoints:
- `GET /api/tasks` → Get all tasks
- `GET /api/tasks/{id}` → Get a task by ID
- `POST /api/tasks` → Add a new task
- `PUT /api/tasks/{id}` → Update a task by ID
- `DELETE /api/tasks/{id}` → Delete a task by ID

### TaskReminderApiApplication.java
Main application launcher class with `@SpringBootApplication`.

### pom.xml
Includes dependencies for:
- `spring-boot-starter-web`
- `lombok`