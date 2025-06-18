# 📌 Simple Todo List API

A basic RESTful API for managing a list of todo items, built with **Spring Boot**.  
This is **Project 2** in my Spring Boot project series.

---

## 📚 Features

- ✅ Add a new todo item
- ✅ View all todo items
- ✅ View a single todo item by its index
- ✅ Search for todo items by title
- ✅ Update the title of an existing todo item
- ✅ Delete a todo item by its title

---

## 📦 Tech Stack

- Java 21
- Spring Boot 3
- Maven
- Lombok
- Postman (for testing)

---

## 📡 API Endpoints

| Method | Endpoint                      | Description                         |
|:--------|:--------------------------------|:-------------------------------------|
| `POST`   | `/api/todos`                     | Add a new todo item                  |
| `GET`    | `/api/todos`                     | Retrieve all todo items              |
| `GET`    | `/api/todos/{index}`             | Get a todo item by its index         |
| `GET`    | `/api/todos/title/{title}`       | Get all todo items matching a title  |
| `PUT`    | `/api/todos?oldTitle={old}&newTitle={new}` | Update a todo item's title         |
| `DELETE` | `/api/todos/{title}`             | Delete a todo item by its title      |

---

## 📥 Example TodoItem JSON

```json
{
  "title": "Learn Spring Boot",
  "completed": false
}
