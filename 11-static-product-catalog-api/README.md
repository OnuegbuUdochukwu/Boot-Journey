# 🛒 Static Product Catalog API

A simple Spring Boot REST API serving a static list of products.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**09-static-product-catalog-api**

---

## 📖 Features

- Retrieve all available products
- Retrieve a product by its ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint             | Description                     |
|:--------|:-------------------------|:---------------------------------|
| `GET`    | `/api/product`              | Get all products                  |
| `GET`    | `/api/product/{id}`         | Get a product by its ID           |

---

## 📬 Sample JSON Response

**For `GET /api/product`**
```json
[
  {
    "id": 1,
    "name": "Wireless Mouse",
    "description": "Ergonomic wireless mouse",
    "price": 15.99,
    "available": true
  },
  {
    "id": 2,
    "name": "Mechanical Keyboard",
    "description": "RGB backlit mechanical keyboard",
    "price": 45.5,
    "available": true
  }
]
