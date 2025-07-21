# 🌍 Timezone Conversion API

A Spring Boot REST API that converts a given datetime from one timezone to another using Java's built-in `java.time` and `ZoneId` classes.

---

## 📌 Features

- Convert any `LocalDateTime` from one timezone to another.
- Uses Java 8+ `ZoneId` for accurate timezone mapping.
- Simple REST interface with JSON input/output.
- Stateless, in-memory logic — no database required.

---

## 📦 Dependencies

- Spring Web
- Lombok

---

## 📁 Folder Structure

timezone-conversion-api/
- controller/
    - TimezoneController.java
- model/
    - TimezoneRequest.java
    - TimezoneResponse.java
- service/
    - TimezoneService.java
- TimezoneConversionApiApplication.java

## 📮 API Endpoint

### 🔁 Convert Timezone

**POST** `/api/timezone/convert`

#### 🔸 Request Body
```json
{
  "datetime": "2025-07-16T15:30:00",
  "sourceTimezone": "Africa/Lagos",
  "targetTimezone": "Asia/Tokyo"
}
```
🔸 Response Body
```json
{
  "originalDatetime": "2025-07-16T15:30:00",
  "sourceTimezone": "Africa/Lagos",
  "convertedDatetime": "2025-07-16T23:30:00",
  "targetTimezone": "Asia/Tokyo"
}
```

## What Each Class Does

### TimezoneRequest.java (Model)
Holds input data: datetime, sourceTimezone, targetTimezone.

### TimezoneResponse.java (Model)
Represents output: original datetime, converted datetime, and both timezones.

### TimezoneService.java (Service)
Core logic:
- Validates timezones.
- Converts datetime between zones using `ZonedDateTime`.

### TimezoneController.java (Controller)
Exposes `/api/timezone/convert` endpoint.
- Calls the service and returns response or error.

## 🚀 Running the App
```bash
./mvnw spring-boot:run
```
Then test with Postman or curl.

## 📚 Notes
- All timezones must match IANA timezone format (Region/City) — e.g., Europe/Paris, America/New_York.
- No external API or DB used. Everything is computed in memory.

## ✅ Status
Project 28 of 120 Spring Boot Projects — ✅ Completed