# 💱 Currency Converter API

A backend REST API built using **Java and Spring Boot** that converts currencies using real-time exchange rates. It supports API key-based authentication and stores conversion history in an in-memory database.

---

## 🚀 Features

* 🔐 API key-based authentication
* 💱 Convert currency (e.g., USD → INR)
* 📡 Real-time exchange rates (external API integration)
* 🗄️ Store conversion history
* 📜 Retrieve past conversions
* ⚡ Lightweight H2 in-memory database

---

## 🧱 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* H2 Database
* WebClient
* Maven

---

## 📁 Project Structure

```
src/main/java/com/example/currencyconverter
│
├── controller      # REST endpoints
├── service         # Business logic
├── repository      # Database access
├── entity          # Data models
├── security        # API key filter
├── config          # Security configuration
└── CurrencyConverterApplication.java
```

---

## ⚙️ Setup & Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/currency-converter-api.git
cd currency-converter-api
```

### 2. Build the project

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

---

## 🌐 API Endpoints

### 🔹 Convert Currency

**POST** `/api/currency/convert`

**Request:**

```
http://localhost:8080/api/currency/convert?from=USD&to=INR&amount=100
```

**Headers:**

```
x-api-key: your_api_key
```

---

### 🔹 Get Conversion History

**GET** `/api/currency/history`

**Headers:**

```
x-api-key: your_api_key
```

---

## 🧪 Testing

Use:

* Postman

Steps:

1. Add header `x-api-key`
2. Call endpoints
3. Verify JSON response

---

## 🗄️ H2 Database Console

Access:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:testdb
```

---

## 📌 Sample Response

```json
{
  "id": 1,
  "fromCurrency": "USD",
  "toCurrency": "INR",
  "amount": 100,
  "convertedAmount": 8300,
  "rate": 83,
  "timestamp": "2026-05-02T10:30:00",
  "apiKey": "user123"
}
```

---

## 🔥 Future Enhancements

* JWT authentication instead of API key
* Swagger/OpenAPI documentation
* Redis caching for exchange rates
* Docker containerization
* Deploy on AWS / Render

---

## 🎯 Learning Outcomes

* REST API development using Spring Boot
* External API integration
* Authentication & security basics
* Database design with JPA
* Layered architecture implementation

---

## 👨‍💻 Author

**Karthikeya Reddy**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub and feel free to fork!
