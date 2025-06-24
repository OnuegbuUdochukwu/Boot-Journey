# 🎓 Student Management System API

A simple Spring Boot REST API for managing **student records in memory**.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**06-student-management-system**

---

## 📖 Features

- Add a new student
- Retrieve all students
- Retrieve a student by ID
- Update a student by ID
- Delete a student by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint               | Description                   |
|:--------|:-------------------------|:--------------------------------|
| `POST`   | `/api/students`             | Add a new student                |
| `GET`    | `/api/students`             | Get all students                 |
| `GET`    | `/api/students/{id}`        | Get a student by ID              |
| `PUT`    | `/api/students/{id}`        | Update a student by ID           |
| `DELETE` | `/api/students/{id}`        | Delete a student by ID           |

---

## 📬 Sample JSON Request & Response

**POST `/api/students`**

📤 **Request Body**
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "course": "Java Backend",
  "age": 22
}
