# 📦 Inventory Management API
A simple RESTful API built with Spring Boot to manage a list of inventory items. Supports adding, updating, deleting, and fetching inventory data stored in-memory.

# 📁 Project Folder
24-inventory-management-api

# 🚀 Features
- Add new inventory items
- View all items
- View a specific item by ID
- Update item details
- Delete items

# 🛠️ Tech Stack
- Java 17+
- Spring Boot
- Spring Web
- Lombok

# 📦 Dependencies
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

# 🧠 Project Structure
```swift
src/main/java/com/codewithudo/inventorymanagementapi/
├── controller/
│   └── InventoryController.java
├── model/
│   └── InventoryItem.java
├── service/
│   └── InventoryService.java
├── InventoryManagementApiApplication.java
└── resources/
    └── application.properties
```

# 📊 API Endpoints
| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| GET    | /api/items            | Get all inventory items         |
| GET    | /api/items/{id}      | Get an item by ID              |
| POST   | /api/items            | Add a new item                 |
| PUT    | /api/items/{id}      | Update item by ID              |
| DELETE | /api/items/{id}      | Delete item by ID              |

# 📄 Sample JSON (POST/PUT)
```json
{
  "name": "Laptop",
  "quantity": 10,
  "price": 1500.0
}
```

# 🧪 Postman Test Coverage
- ✅ Create item (200)
- ✅ Get all items (200)
- ✅ Get by ID (200/404)
- ✅ Update item (200/404)
- ✅ Delete item (200/404)

# 🏁 How to Run
1. Clone the repo
2. Open in IntelliJ or VSCode
3. Run `InventoryManagementApiApplication.java`
4. Use Postman to test endpoints on `http://localhost:8080`