# 📞 Contact Book API

A simple Spring Boot REST API for managing a list of contacts (in-memory, no database yet).  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**05-contact-book-api**

---

## 📖 Features

- Add a new contact
- Get all contacts
- Get a contact by ID
- Update a contact by ID
- Delete a contact by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint             | Description             |
|:--------|:---------------------|:-------------------------|
| `POST`   | `/api/contacts`        | Add a new contact         |
| `GET`    | `/api/contacts`        | Get all contacts          |
| `GET`    | `/api/contacts/{id}`   | Get contact by ID         |
| `PUT`    | `/api/contacts/{id}`   | Update a contact by ID    |
| `DELETE` | `/api/contacts/{id}`   | Delete a contact by ID    |

---

## 🚀 Run the Application

```bash
./mvnw spring-boot:run
