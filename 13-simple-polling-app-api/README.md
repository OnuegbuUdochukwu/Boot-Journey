# 🗳️ Simple Polling App API

A simple Spring Boot REST API for creating polls, voting on options, and managing polls — with in-memory data storage.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**13-simple-polling-app**

---

## 📖 Features

- Create a new poll with multiple options
- Retrieve all polls
- Retrieve a poll by ID
- Vote for an option in a poll
- Delete a poll by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method   | Endpoint                        | Description                            |
|:-----------|:--------------------------------|:-----------------------------------------|
| `POST`    | `/api/poll`                      | Create a new poll                        |
| `GET`     | `/api/poll`                      | Get all polls                            |
| `GET`     | `/api/poll/{id}`                 | Get a poll by its ID                     |
| `POST`    | `/api/poll/{pollId}/vote/{optionId}` | Vote for a specific option in a poll     |
| `DELETE`  | `/api/poll/{id}`                 | Delete a poll by its ID                  |

---

## 📬 Sample JSON Request

**For `POST /api/poll`**

```json
{
  "question": "What's your favorite programming language?",
  "options": [
    { "text": "Java" },
    { "text": "Python" },
    { "text": "JavaScript" }
  ]
}

```
# What Each Class Does

## Poll.java (Model)
Represents a poll with a unique ID, question, and a list of options.

**Fields:**
- `id` (Integer)
- `question` (String)
- `options` (List<Option>)

## Option.java (Model)
Represents an option in a poll.

**Fields:**
- `id` (Integer)
- `text` (String)
- `votes` (Integer)

## PollService.java (Service)
Contains business logic and an in-memory list to manage polls.

**Responsibilities:**
- Add new polls
- Retrieve all polls
- Retrieve a poll by ID
- Vote for an option in a poll
- Delete a poll by ID

## PollController.java (Controller)
Handles HTTP requests from clients.

**Exposes these endpoints:**
- `POST /api/poll` → Create a new poll
- `GET /api/poll` → Get all polls
- `GET /api/poll/{id}` → Get a poll by ID
- `POST /api/poll/{pollId}/vote/{optionId}` → Vote on a poll option
- `DELETE /api/poll/{id}` → Delete a poll by ID

## SimplePollingAppApiApplication.java
Main application launcher class with `@SpringBootApplication`.

## pom.xml
Includes dependencies for:
- `spring-boot-starter-web`
- `lombok` (optional but recommended)