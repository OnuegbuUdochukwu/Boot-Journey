# 🚗 Vehicle Registry API

A simple Spring Boot REST API for managing an in-memory list of vehicles.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**20-vehicle-registry-api**

---

## 📖 Features

- Add a new vehicle
- Retrieve all vehicles
- Retrieve a vehicle by ID
- Update vehicle details by ID
- Delete a vehicle by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint             | Description                  |
|:--------|:----------------------|:------------------------------|
| `GET`    | `/api/vehicles`         | Get all vehicles               |
| `GET`    | `/api/vehicles/{id}`    | Get a vehicle by its ID        |
| `POST`   | `/api/vehicles`         | Add a new vehicle              |
| `PUT`    | `/api/vehicles/{id}`    | Update a vehicle by its ID     |
| `DELETE` | `/api/vehicles/{id}`    | Delete a vehicle by its ID     |

---

## 📬 Sample JSON Request

**For `POST /api/vehicles`**
```json
{
  "make": "Toyota",
  "model": "Camry",
  "year": 2020,
  "color": "Black",
  "registrationNumber": "ABC123XYZ"
}
```

## What Each Class Does

### Vehicle.java (Model)
A simple POJO representing a vehicle.

**Fields:**

- `id` (Integer)
- `make` (String)
- `model` (String)
- `year` (Integer)
- `color` (String)
- `registrationNumber` (String)

### VehicleService.java (Service)
Contains business logic and an in-memory list to store vehicles.

**Responsibilities:**

1. Add new vehicles
2. Get all vehicles
3. Get vehicle by ID
4. Update vehicle details
5. Delete vehicle by ID

### VehicleController.java (Controller)
Handles incoming HTTP requests and maps them to service operations.

**Exposes Endpoints:**

- `GET /api/vehicles`
- `GET /api/vehicles/{id}`
- `POST /api/vehicles`
- `PUT /api/vehicles/{id}`
- `DELETE /api/vehicles/{id}`

### Status
✅ All endpoints tested successfully via Postman.