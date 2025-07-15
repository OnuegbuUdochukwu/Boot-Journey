# 23-attendance-tracker-api

A simple Spring Boot REST API to manage student attendance records in-memory. Supports adding, viewing, updating, and deleting attendance records.

## Description:
This project provides a RESTful API for managing student attendance records. Each record contains a student name, attendance date, and status (e.g. "Present", "Absent").

## Dependencies:
- spring-boot-starter-web
- lombok

## Project Structure:
```
src/main/java/com/codewithudo/attendancetrackerapi/
├── controller/
│   └── AttendanceController.java
├── model/
│   └── Attendance.java
├── service/
│   └── AttendanceService.java
├── AttendanceTrackerApiApplication.java
└── resources/
    └── application.properties
```

## Endpoints Table:

| Method | Endpoint                 | Description                               |
|--------|--------------------------|-------------------------------------------|
| GET    | /api/attendances        | Retrieve all attendance records           |
| GET    | /api/attendances/{id}   | Get a specific attendance record by ID   |
| POST   | /api/attendances        | Add a new attendance record               |
| PUT    | /api/attendances/{id}   | Update an existing attendance record      |
| DELETE | /api/attendances/{id}   | Remove a record by ID                     |

## What Each Class Does:

### Attendance.java (Model)
Represents an attendance record.

#### Fields:
- `id` (Integer)
- `studentName` (String)
- `date` (String)
- `status` (String)

### AttendanceService.java (Service)
Handles business logic and manages an in-memory list of attendance records.

#### Responsibilities:
- Add new record
- Retrieve all records
- Retrieve record by ID
- Update a record
- Delete a record by ID

### AttendanceController.java (Controller)
Handles incoming HTTP requests and delegates to the service.

#### Endpoints:
- GET /api/attendances
- GET /api/attendances/{id}
- POST /api/attendances
- PUT /api/attendances/{id}
- DELETE /api/attendances/{id}

## How to Run:
1. Clone the repository.
2. Open in your IDE.
3. Run `AttendanceTrackerApiApplication.java`.
4. Test endpoints via Postman or any REST client.

✅ Done.