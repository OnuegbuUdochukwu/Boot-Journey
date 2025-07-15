# Static FAQ Service API

A simple Spring Boot REST API that manages an in-memory list of Frequently Asked Questions (FAQs). Supports basic CRUD operations without a database.

## Description

This project provides a minimal backend service for FAQs where clients can:

- View all FAQs
- View a specific FAQ by its ID
- Add a new FAQ
- Update an existing FAQ
- Delete a FAQ

Data is stored in-memory using a `List<Faq>` object.

## Dependencies

- spring-boot-starter-web
- lombok
- spring-boot-starter-test (for unit testing)

## Project Folder Naming

24-static-faq-service

## Project Structure

```
src/main/java/com/codewithudo/staticfaqservice/
├── controller/
│   └── FaqController.java
├── model/
│   └── Faq.java
├── service/
│   └── FaqService.java
├── StaticFaqServiceApplication.java
└── resources/
    └── application.properties
```

## Endpoints Table

| Method | Endpoint           | Description                      |
|--------|--------------------|----------------------------------|
| GET    | /api/faqs         | Get all FAQs                    |
| GET    | /api/faqs/{id}    | Get a specific FAQ by ID       |
| POST   | /api/faqs         | Add a new FAQ                   |
| PUT    | /api/faqs/{id}    | Update an FAQ by ID            |
| DELETE | /api/faqs/{id}    | Delete a FAQ by ID             |

## What Each Class Does

### Faq.java (Model)

Represents an FAQ item.

Fields:

- id (Integer)
- question (String)
- answer (String)

### FaqService.java (Service)

Handles the core business logic and data storage.

Responsibilities:

- Add new FAQ
- Retrieve all FAQs
- Retrieve an FAQ by ID
- Update an existing FAQ
- Delete a FAQ by ID

### FaqController.java (Controller)

Exposes the API endpoints to clients.

Endpoints:

- GET /api/faqs
- GET /api/faqs/{id}
- POST /api/faqs
- PUT /api/faqs/{id}
- DELETE /api/faqs/{id}

## Tests

Unit tests written with JUnit 5 for:

- FaqService methods
- FaqController using MockMvc

## Status

✔️ Complete — All endpoints and unit tests working.