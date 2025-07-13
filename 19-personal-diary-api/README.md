# 📓 Personal Diary API

A simple Spring Boot REST API to manage personal diary entries in-memory.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**19-personal-diary-api**

---

## 📖 Features

- Add a new diary entry
- Retrieve all diary entries
- Retrieve a diary entry by ID
- Update a diary entry by ID
- Delete a diary entry by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint             | Description                        |
|:--------|:-----------------------|:------------------------------------|
| `GET`    | `/api/diary`             | Get all diary entries               |
| `GET`    | `/api/diary/{id}`        | Get a diary entry by its ID         |
| `POST`   | `/api/diary`             | Add a new diary entry               |
| `PUT`    | `/api/diary/{id}`        | Update a diary entry by its ID      |
| `DELETE` | `/api/diary/{id}`        | Delete a diary entry by its ID      |

---

## 📬 Sample JSON Request

**For `POST /api/diary`**
```json
{
  "title": "A New Day",
  "content": "Today I learned about REST APIs.",
  "date": "2025-07-07"
}
```
## What Each Class Does

### DiaryEntry.java (Model)
A POJO representing a diary entry.

#### Fields:
- `id` (Integer)
- `title` (String)
- `content` (String)
- `date` (String)

### DiaryService.java (Service)
Contains business logic and in-memory list to store diary entries.

#### Responsibilities:
- Add new entries
- Retrieve all entries
- Retrieve an entry by ID
- Update an entry
- Delete an entry by ID

### DiaryController.java (Controller)
Handles HTTP requests and routes them to the service.

#### Endpoints:
- `GET /api/diary`
- `GET /api/diary/{id}`
- `POST /api/diary`
- `PUT /api/diary/{id}`
- `DELETE /api/diary/{id}`

### How to Run
1. Clone the project
2. Open in your IDE
3. Run `DiaryApiApplication.java`
4. Test endpoints using Postman or any REST client

### Status
🟢 Completed ✅
