# 📚 Event Management API
A simple Spring Boot REST API to manage events with in-memory storage.  
Part of the 120 Spring Boot Projects challenge.

## 📁 Project Number:
17-event-management-system

## 📖 Features
- Create a new event
- Retrieve all events
- Retrieve a specific event by ID
- Update event details
- Delete an event

## 📦 Tech Stack
- Java 21
- Spring Boot
- Spring Web
- Lombok

## 📑 Endpoints
| Method | Endpoint          | Description                     |
|--------|-------------------|---------------------------------|
| POST   | /api/events       | Create a new event             |
| GET    | /api/events       | Retrieve all events             |
| GET    | /api/events/{id}  | Retrieve an event by ID         |
| PUT    | /api/events/{id}  | Update an event by ID           |
| DELETE | /api/events/{id}  | Delete an event by ID           |

## 📬 Sample JSON Request
For `POST /api/events`
```json
{
  "name": "Spring Boot Workshop",
  "location": "Lagos",
  "date": "2025-07-25",
  "description": "A beginner-friendly Spring Boot workshop."
}
```

## 📖 What Each Class Does

### 📄 Event.java (Model)
A simple POJO representing an event.

Fields:
- id (Integer)
- name (String)
- location (String)
- date (String)
- description (String)

### 📄 EventService.java (Service)
Handles business logic and in-memory event storage.

Responsibilities:
- Add new events
- Retrieve all events
- Retrieve event by ID
- Update event details
- Delete event by ID

### 📄 EventController.java (Controller)
Handles HTTP requests and exposes REST endpoints.

Endpoints:
- `POST /api/events`
- `GET /api/events`
- `GET /api/events/{id}`
- `PUT /api/events/{id}`
- `DELETE /api/events/{id}`