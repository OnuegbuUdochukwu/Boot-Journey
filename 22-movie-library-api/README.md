# 📽️ Movie Library API
A simple Spring Boot REST API for managing a collection of movies in-memory.  
Part of the 120 Spring Boot Projects challenge.

## 📁 Project Number:
22-movie-library-api

## 📖 Features
- Add a new movie
- Retrieve all movies
- Retrieve a movie by ID
- Update movie details by ID
- Delete a movie by ID

## 📦 Tech Stack
- Java 21
- Spring Boot
- Spring Web
- Lombok

## 📑 Endpoints
| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | /api/movies           | Get all movies              |
| GET    | /api/movies/{id}      | Get a movie by its ID       |
| POST   | /api/movies           | Add a new movie             |
| PUT    | /api/movies/{id}      | Update a movie by its ID    |
| DELETE | /api/movies/{id}      | Delete a movie by its ID    |

## 📬 Sample JSON Request
For `POST /api/movies`:
```json
{
  "title": "Inception",
  "director": "Christopher Nolan",
  "releaseYear": 2010,
  "genre": "Sci-Fi"
}
```

## 📖 What Each Class Does

### 📄 Movie.java (Model)
A simple POJO representing a movie.

Fields:
- id (Integer)
- title (String)
- director (String)
- releaseYear (Integer)
- genre (String)

### 📄 MovieService.java (Service)
Handles business logic and manages an in-memory list of movies.

Responsibilities:
- Add new movies
- Get all movies
- Get a movie by ID
- Update movie details
- Delete a movie by ID

### 📄 MovieController.java (Controller)
Handles HTTP requests and maps them to the appropriate service methods.

Exposes these endpoints:
- GET /api/movies
- GET /api/movies/{id}
- POST /api/movies
- PUT /api/movies/{id}
- DELETE /api/movies/{id}

## 🚀 How to Run
1. Clone the repository
2. Open in your preferred IDE
3. Run `MovieLibraryApiApplication.java`
4. Test endpoints via Postman or your preferred REST client