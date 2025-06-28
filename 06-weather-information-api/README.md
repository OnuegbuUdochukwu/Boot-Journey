# 🌤️ Weather Information API

A simple Spring Boot REST API that serves **static weather data** for a list of predefined cities.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**06-weather-information-api**

---

## 📖 Features

[//]: # (- Retrieve all available weather data)
- Retrieve weather data for a specific city (case-insensitive)

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
| `GET`    | `/api/weather/{city}`      | Get weather data for a specific city      |

---

## 📬 Sample JSON Response

**For `/api/weather/Lagos`**

```json
[
  {
    "city": "Lagos",
    "temperature": 31.5,
    "description": "Sunny"
  }
]
