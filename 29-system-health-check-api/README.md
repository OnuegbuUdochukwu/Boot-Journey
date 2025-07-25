# 🩺 System Health Check API

A simple Spring Boot REST API to monitor the basic health of your application, including system status and uptime.

---

## 📌 Features

- Check if the system is up and running
- Get the current system uptime (in seconds)
- Lightweight and easy to integrate with monitoring tools

---

## Folder Structure

```plaintext
src/
├── main/
│   ├── java/com/codewithudo/systemhealthcheckapi/
│   │   ├── controller/
│   │   │   └── HealthController.java
│   │   ├── model/
│   │   │   └── HealthStatus.java
│   │   └── service/
│   │       └── HealthService.java
│   └── resources/
│       └── application.properties
```

## API Endpoints

| Method | Endpoint           | Description                       | Response Type |
|--------|--------------------|-----------------------------------|---------------|
| GET    | /api/health/status  | Get system health and uptime      | HealthStatus  |
| GET    | /api/health/uptime  | Get uptime in seconds only        | Long          |

### Sample Postman Tests

#### ✅ GET /api/health/status

#### 🕒 GET /api/health/uptime


# What Each Class Does

**HealthStatus.java – Model**

**Fields:**

- `String status`
- `long uptimeInSeconds`

**Responsibilities:** Holds the current system status and how long the system has been running.

**HealthService.java – Service**

**Responsibilities:**

- Stores application start time.
- Calculates uptime dynamically.
- Always returns "UP" as the current status (can be extended for more checks).

**HealthController.java – Controller**

**Endpoints:**

- `/status` — Returns full health report
- `/uptime` — Returns only uptime in seconds

**Responsibilities:** Exposes REST API to clients for checking health status.

# How to Run

1. Clone the repository or copy the project folder.
2. Open in your preferred IDE.
3. Run `SystemHealthCheckApiApplication.java`.
4. Visit:
    - `http://localhost:8080/api/health/status`
    - `http://localhost:8080/api/health/uptime`

## ✅ Status
## ✅ Completed

# Tested with Postman
