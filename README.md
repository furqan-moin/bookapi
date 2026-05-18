# Book Management REST API

A production-style Spring Boot REST API built using **Java 21**, **Spring Boot 3**, **Spring Data JPA**, **H2 Database**, and **DTO architecture**.

This project demonstrates enterprise-grade backend development practices including:

* CRUD operations
* Layered architecture
* DTO pattern
* Validation
* Exception handling
* RESTful API design
* H2 in-memory database
* Maven project structure

---

## Tech Stack

* **Java 21**
* **Spring Boot 3**
* **Spring Web**
* **Spring Data JPA**
* **H2 Database**
* **Maven**
* **Lombok**
* **Jakarta Validation**

---

## Features

### Book Operations

* Get all books
* Get book by ID
* Add new book
* Update existing book
* Delete book

### Engineering Best Practices

* DTO separation (`RequestDTO`, `ResponseDTO`)
* Global exception handling
* Input validation
* Clean layered architecture:

    * Controller
    * Service
    * Repository
    * Entity
    * DTO
* Proper HTTP status codes

---

## Project Structure

```text
src/main/java/com/furqan/
│
├── bookapi/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── exception/
│   └── BookApiApplication.java
│
├── entity/
│   └── Book.java
│
└── Dto/
    ├── BookRequestDto.java
    └── BookResponseDto.java
```

---

## API Endpoints

### Get All Books

```http
GET /api/books
```

### Get Book By ID

```http
GET /api/books/{id}
```

### Add Book

```http
POST /api/books
Content-Type: application/json
```

### Sample Request:

```json
{
  "title": "Java 21 Guide",
  "author": "Furqan Moin",
  "price": 499.99
}
```

---

### Update Book

```http
PUT /api/books/{id}
```

---

### Delete Book

```http
DELETE /api/books/{id}
```

---

## Running the Project

### Clone Repository

```bash
git clone git@github-personal:furqan-moin/bookapi.git
```

### Navigate

```bash
cd bookapi
```

### Run

```bash
mvn spring-boot:run
```

---

## H2 Database Console

Access:

```text
http://localhost:8080/h2-console
```

### JDBC URL:

```text
jdbc:h2:mem:bookdb
```

---

## Validation Examples

* Title cannot be blank
* Author cannot be blank
* Price cannot be null

---

## Future Enhancements

* Swagger/OpenAPI Documentation
* MySQL/PostgreSQL Integration
* Docker Support
* Unit Testing
* Security (JWT/Auth)
* Logging & Monitoring
* CI/CD Pipelines
* Pagination & Sorting

---

## Interview Relevance

This project was built as part of senior Java backend and production support interview preparation, showcasing:

* Spring Boot fundamentals
* REST API development
* Enterprise architecture
* Code maintainability
* Production-readiness

---

## Author

**Furqan Moin**

* Java Backend Engineer
* Production Support Engineer
* Spring Boot Developer

---

## License

This project is for educational, portfolio, and interview preparation purposes.
