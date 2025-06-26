# 📚 Book Inventory API

A simple Spring Boot REST API for managing an in-memory list of books.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**08-book-inventory-api**

---

## 📖 Features

- Add a new book
- Retrieve all books
- Retrieve a book by ID
- Update book details by ID
- Delete a book by ID

---
### 📖 What Each Class Does

📄 **Book.java** (Model)  
A simple POJO representing a book.

**Fields:**
- `id` (Integer)
- `title` (String)
- `author` (String)
- `isbn` (String)
- `price` (Double)

---

📄 **BookService.java** (Service)  
Contains business logic and an in-memory list to store books.

**Responsibilities:**
- Add new books
- Get all books
- Get book by ID
- Update book details
- Delete book by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint           | Description                  |
|:--------|:---------------------|:------------------------------|
| `GET`    | `/api/books`           | Get all books                  |
| `GET`    | `/api/books/{id}`      | Get a book by its ID           |
| `POST`   | `/api/books`           | Add a new book                 |
| `PUT`    | `/api/books/{id}`      | Update a book by its ID        |
| `DELETE` | `/api/books/{id}`      | Delete a book by its ID        |

---

## 📬 Sample JSON Request

**For `POST /api/books`**
```json
{
  "title": "Atomic Habits",
  "author": "James Clear",
  "isbn": "9780735211292",
  "price": 20.5
}
