# 🌍 Country Information API

A Spring Boot REST API that fetches country details like capital, region, population, and currency from the API Ninjas Country API.

Part of the 120 Spring Boot Projects challenge.

## 📁 Project Number:
16-country-information-api

## 📖 Features
- Retrieve country details by country name via external API
- Returns streamlined information as a clean JSON response
- Handles error cases gracefully when a country is not found or the API fails

## 📦 Tech Stack
- Java 21
- Spring Boot
- Spring Web (RestTemplate)
- Lombok
- API Ninjas Country API

## 🔐 API Configuration
In `src/main/resources/application.properties`

```properties
api.ninjas.base-url=https://api.api-ninjas.com/v1/country
api.ninjas.api-key=YOUR_REAL_API_KEY_HERE
server.port=8080
```

## 📑 Endpoints
| Method | Endpoint                       | Description                             |
|--------|--------------------------------|-----------------------------------------|
| GET    | `/api/countries/{countryName}` | Fetch details of a country by name     |

## 📬 Sample Response
**Request:**
```
GET /api/countries/Nigeria
```

**Response:**
```json
{
  "name": "Nigeria",
  "capital": "Abuja",
  "region": "Africa",
  "population": 206139589,
  "currency": "Naira"
}
```

## 📖 What Each Class Does

### 📄 Country.java (Model)
Represents a streamlined version of country information.

**Fields:**
- `name` (String)
- `capital` (String)
- `region` (String)
- `population` (Long)
- `currency` (String)

### 📄 CountryService.java (Service)
Handles business logic:
- Fetches data from API Ninjas
- Parses and maps JSON response to Country model
- Manages error handling

### 📄 CountryController.java (Controller)
Exposes the REST endpoint:
- `GET /api/countries/{countryName}` → Returns country info

## 🛠️ How to Run
- Set your actual API key in `application.properties`
- Run the application via your IDE or `./mvnw spring-boot:run`
- Test with Postman or browser via `http://localhost:8080/api/countries/Nigeria`