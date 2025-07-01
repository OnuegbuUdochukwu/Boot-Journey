# 🔗 URL Shortener API

A simple Spring Boot REST API that converts long URLs into short, random 6-character codes.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**10-url-shortener-api**

---

## 📖 Features

- Add a new URL and generate a short code
- Retrieve the original URL using a short code
- Retrieve all URL mappings (for testing)

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint               | Description                              |
|:--------|:-------------------------|:------------------------------------------|
| `POST`   | `/api/url`               | Add a new long URL and generate a short code |
| `GET`    | `/api/url/{shortCode}`   | Retrieve the original long URL by short code |
| `GET`    | `/api/url`               | Get all URL mappings (for testing)        |

---

## 📬 Sample JSON Requests & Responses

**POST `/api/url`**

**Request:**
```json
{
  "originalUrl": "https://www.example.com"
}
