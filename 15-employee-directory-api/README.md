# Employee Directory API

A simple Spring Boot REST API for managing a basic in-memory employee directory.  
Part of the 120 Spring Boot Projects challenge.

## Project Number:
15-employee-directory-api

## Features
- Add a new employee
- Retrieve all employees
- Retrieve an employee by ID
- Update employee details by ID
- Delete an employee by ID

## Tech Stack
- Java 21
- Spring Boot
- Spring Web
- Lombok

## Endpoints
| Method | Endpoint                | Description                            |
|--------|-------------------------|----------------------------------------|
| GET    | `/api/employees`       | Get all employees                      |
| GET    | `/api/employees/{id}`  | Get an employee by their ID           |
| POST   | `/api/employees`       | Add a new employee                    |
| PUT    | `/api/employees/{id}`  | Update an existing employee by ID     |
| DELETE | `/api/employees/{id}`  | Delete an employee by ID              |

## Sample JSON Request
For `POST /api/employees`

```json
{
  "name": "Jane Doe",
  "position": "HR Manager",
  "email": "jane.doe@example.com",
  "phone": "08012345678"
}
```

## What Each Class Does

### Employee.java (Model)
A simple POJO representing an employee.

Fields:
- id (Integer)
- name (String)
- position (String)
- email (String)
- phone (String)

### EmployeeService.java (Service)
Contains business logic and an in-memory list to store employees.

Responsibilities:
- Add new employees
- Get all employees
- Get employee by ID
- Update employee details
- Delete employee by ID

### EmployeeController.java (Controller)
Handles HTTP requests from clients.

Exposes these endpoints:
- GET `/api/employees`
- GET `/api/employees/{id}`
- POST `/api/employees`
- PUT `/api/employees/{id}`
- DELETE `/api/employees/{id}`

### EmployeeDirectoryApiApplication.java
Main application launcher class with `@SpringBootApplication`.

### pom.xml
Includes dependencies for:
- spring-boot-starter-web
- lombok