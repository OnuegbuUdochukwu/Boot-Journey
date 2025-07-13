# 📖 Recipe Management API

A simple Spring Boot REST API for managing a collection of recipes in memory.  
Part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**21-recipe-management-api**

---

## 📖 Features

- Add a new recipe
- Retrieve all recipes
- Retrieve a recipe by ID
- Update a recipe by ID
- Delete a recipe by ID

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method  | Endpoint            | Description            |
|:---------|:---------------------|:------------------------|
| `GET`    | `/api/recipes`         | Get all recipes           |
| `GET`    | `/api/recipes/{id}`    | Get a recipe by its ID    |
| `POST`   | `/api/recipes`         | Add a new recipe          |
| `PUT`    | `/api/recipes/{id}`    | Update a recipe by ID     |
| `DELETE` | `/api/recipes/{id}`    | Delete a recipe by ID     |

---

## 📬 Sample JSON Request

**For `POST /api/recipes`**
```json
{
  "title": "Spaghetti Bolognese",
  "ingredients": "Spaghetti, minced beef, tomato sauce, onion, garlic",
  "instructions": "Cook spaghetti. Fry beef with onion and garlic. Add sauce. Combine."
}
```

## What Each Class Does

### Recipe.java (Model)
Represents a recipe entity.

**Fields:**
- `id` (Integer)
- `title` (String)
- `ingredients` (String)
- `instructions` (String)

### RecipeService.java (Service)
Contains business logic and an in-memory list to store recipes.

**Responsibilities:**
1. Add new recipes
2. Retrieve all recipes
3. Retrieve a recipe by ID
4. Update a recipe
5. Delete a recipe

### RecipeController.java (Controller)
Handles HTTP requests for recipes.

**Exposed Endpoints:**
- `GET /api/recipes`
- `GET /api/recipes/{id}`
- `POST /api/recipes`
- `PUT /api/recipes/{id}`
- `DELETE /api/recipes/{id}`

### Project Structure
```
src/main/java/com/codewithudo/recipemanagementapi/
├── controller/
│   └── RecipeController.java
├── model/
│   └── Recipe.java
├── service/
│   └── RecipeService.java
└── RecipeManagementApiApplication.java
```

### Status
✅ Completed  
🎯 Successfully tested with Postman