# 📘 30-e-library-book-lending

A simple Spring Boot API for managing a digital library's book collection, including lending and returning books.

---

## 📌 Features

- Add books to the library
- List all books
- Get a single book by ID
- Mark a book as borrowed
- Return a borrowed book
- Delete books from the library

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 In-Memory Database
- Lombok

---

## 📂 Project Structure

```mdx
src
├── main
│   ├── java
│   │   └── com.codewithudo.elibrarybooklending
│   │       ├── controller
│   │       │   └── LibraryController.java
│   │       ├── model
│   │       │   └── Book.java
│   │       │   └── BorrowRecord.java
│   │       ├── repository
│   │       │   └── BookRepository.java
│   │       │   └── BorrowRecordRepository.java
│   │       ├── dto
│   │       │   └── BorrowRequest.java
│   │       │   └── ReturnRequest.java
│   │       └── service
│   │           └── LibraryService.java
│   └── resources
│       └── application.properties
└──test

```

---

## 📮 API Endpoints

| Method | Endpoint                 | Description            |
|--------|--------------------------|------------------------|
| GET    | `/api/library/books`     | Get all books          |
| GET    | `/api/library/books/{id}`        | Get book by ID         |
| POST   | `/api/library/books`             | Add a new book         |
| PUT    | `/api/library/books/{id}/lend`   | Lend a book            |
| PUT    | `/api/library/books/{id}/return` | Return a borrowed book |
| DELETE | `/api/library/books/{id}`        | Delete a book          |

---

## 📤 Sample POST Request

```http
POST /api/library/books
Content-Type: application/json

{
  "title": "Clean Code",
  "author": "Robert C. Martin"
}
```

## What Each Class Does

### Book.java (Model)
Represents a book entity.

**Fields:** `id`, `title`, `author`, `borrowed`

**Annotations:** `@Entity`, `@Id`, `@GeneratedValue`

### BookRepository.java (Repository)
Interface extending `JpaRepository<Book, Long>`

Provides CRUD operations.

### BookService.java (Service)
Handles business logic.

Manages book creation, retrieval, lending, returning, and deletion.

### BookController.java (Controller)
Exposes REST API endpoints for managing books.

Maps service layer to HTTP endpoints.

#### Delete Endpoint
To delete a book:

```
DELETE /api/library/books/{id}
```

**Response:** `204 No Content` if successful.

#### Database
Uses H2 in-memory database (auto-configured).
