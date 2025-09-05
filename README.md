# 🔗 URL Shortener


A full-stack web application that converts long URLs into compact, shareable 10-character short codes.


## ✨ Features


- **URL Shortening**: Convert any long URL into a 10-character short code
- **URL Redirection**: Click short URLs to redirect to original destinations 
- **Error Handling**: Graceful error handling with user-friendly feedback
- **Clean UI**: Modern, responsive web interface


## 🛠️ Tech Stack


| Component | Technology |
|-----------|------------|
| **Backend** | Java, Spring Boot |
| **Frontend** | React, Axios |
| **Database** | MySQL |


## 🚀 Quick Start


### Installation & Run


1. **Clone and setup backend:**
  ```bash
  cd backend-service
  mvn clean install
  mvn spring-boot:run
  ```


2. **Setup and run frontend:**
  ```bash
  cd frontend-service
  npm install
  npm start
  ```


3. **Access the application:**
  - Frontend: `http://localhost:3000`
  - Backend API: `http://localhost:8080`


## 📚 API Documentation


### Endpoints


#### 🔗 Shorten URL
**POST** `localhost:8080/shorten`


**Request:**
```json
{
 "originalUrl": "https://www.example.com/very/long/url/path"
}
```


**Response:**
```
aBc123XyZ9
```


#### 🔍 Get Original URL
**GET** `localhost:8080/{shortCode}`


**Response:**
```json
{
 "originalUrl": "https://www.test.com/test",
 "shortUrl": "aBc123XyZ9"
}
```


## 📁 Project Structure


```
url-shortener-main/
├── backend-service/              # Spring Boot API
│   └── src/main/java/com/example/backendservice/
│       ├── controllers/          # REST endpoints
│       ├── models/              # JPA entities
│       ├── services/            # Business logic
│       ├── repos/               # Data access layer
│       ├── dtos/                # Data transfer objects
│       └── exceptions/           # Custom exceptions
└── frontend-service/            # React application
   └── src/
       ├── pages/              # React components
       ├── App.js              # Main application
       └── index.js            # Entry point
```