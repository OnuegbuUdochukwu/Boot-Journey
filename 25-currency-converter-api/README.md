# Currency Converter API
A simple Spring Boot REST API for converting currency amounts using static in-memory exchange rates. No external API calls — purely local for learning and prototyping purposes.

## Dependencies
- spring-boot-starter-web
- lombok

## Project Folder Name
25-currency-converter-api

## Project Structure
```
src/main/java/com/codewithudo/currencyconverterapi/
├── controller/
│   └── CurrencyController.java
├── model/
│   └── ConversionResult.java
├── service/
│   └── CurrencyService.java
├── CurrencyConverterApiApplication.java
└── resources/
    └── application.properties
```

## API Endpoints
| Method | Endpoint                          | Description                                     |
|--------|-----------------------------------|-------------------------------------------------|
| GET    | /api/currency                     | Get all available currencies and rates          |
| GET    | /api/currency/convert             | Convert an amount from one currency to another  |

## What Each Class Does

### ConversionResult.java (Model)
Represents a conversion result object.

Fields:
- `from` (String) — Source currency code
- `to` (String) — Target currency code
- `originalAmount` (Double)
- `convertedAmount` (Double)

### CurrencyService.java (Service)
Holds an in-memory map of currency codes and their static exchange rates.

Responsibilities:
- Return all available currencies with rates
- Convert currency amounts based on these static rates

### CurrencyController.java (Controller)
Handles HTTP requests from clients.

Endpoints:
- GET /api/currency
- GET /api/currency/convert

## Test Plan (Postman)
| Test                                                      | Expected Result                                  |
|-----------------------------------------------------------|-------------------------------------------------|
| GET /api/currency                                         | 200 OK — list of currencies                     |
| GET /api/currency/convert?from=USD&to=EUR&amount=100   | 200 OK — converted result                        |
| GET /api/currency/convert with invalid currency          | 400 BAD REQUEST                                  |
| GET /api/currency/convert missing params                 | 400 BAD REQUEST                                  |

## Example Request
GET
```
http://localhost:8080/api/currency/convert?from=USD&to=EUR&amount=100
```
Response:
```json
{
  "from": "USD",
  "to": "EUR",
  "originalAmount": 100.0,
  "convertedAmount": 92.0
}
```