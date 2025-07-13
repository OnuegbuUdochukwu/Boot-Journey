# 🎵 Music Album Manager API

A simple Spring Boot REST API for managing a collection of music albums.  
Built as part of the **120 Spring Boot Projects** challenge.

---

## 📁 Project Number:
**18-music-album-manager**

---

## 📖 Features

- Add a new music album
- Retrieve all albums
- Retrieve a specific album by ID
- Update album details
- Delete an album

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Lombok

---

## 📑 Endpoints

| Method | Endpoint             | Description                   |
|:--------|:---------------------|:--------------------------------|
| `GET`    | `/api/albums`           | Get all albums                  |
| `GET`    | `/api/albums/{id}`      | Get an album by its ID           |
| `POST`   | `/api/albums`           | Add a new album                  |
| `PUT`    | `/api/albums/{id}`      | Update an album by its ID        |
| `DELETE` | `/api/albums/{id}`      | Delete an album by its ID        |

---

## 📬 Sample JSON Request

**For `POST /api/albums`**
```json
{
  "title": "Thriller",
  "artist": "Michael Jackson",
  "genre": "Pop",
  "releaseYear": 1982
}
 ```

## What Each Class Does

### Album.java (Model)
A simple POJO representing a music album.

#### Fields:
- id (Integer)
- title (String)
- artist (String)
- genre (String)
- releaseYear (Integer)

### AlbumService.java (Service)
Handles the business logic and manages the in-memory list of albums.

#### Responsibilities:
- Add a new album
- Get all albums
- Get album by ID
- Update album details
- Delete album by ID

### AlbumController.java (Controller)
Exposes REST endpoints and handles HTTP requests.

#### Endpoints:
- GET /api/albums
- GET /api/albums/{id}
- POST /api/albums
- PUT /api/albums/{id}
- DELETE /api/albums/{id}

### pom.xml
#### Dependencies:
- spring-boot-starter-web
- lombok