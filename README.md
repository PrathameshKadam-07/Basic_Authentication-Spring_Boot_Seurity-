# 🔐 Spring Boot Basic Authentication System

## 📌 Overview
This project is a production-style implementation of **Basic Authentication** using **Spring Boot** and **Spring Security**. It demonstrates how to design and secure RESTful APIs by integrating authentication, password encryption, and role-based access control.

The system follows best practices such as **separation of concerns**, **secure password handling**, and **extensible architecture**, making it a solid foundation for transitioning to more advanced mechanisms like JWT or OAuth2.

---

## 🎯 Objectives
- Implement secure user authentication using HTTP Basic Auth
- Understand Spring Security’s internal authentication flow
- Apply password hashing using BCrypt
- Design scalable and maintainable security architecture
- Protect REST APIs with authentication and authorization

---

## 🚀 Features
- 🔐 HTTP Basic Authentication (`httpBasic()`)
- 🔒 Password encryption using `BCryptPasswordEncoder`
- 👤 Custom `UserDetails` implementation
- 🧩 Custom `UserDetailsService` for user loading
- ⚙️ Centralized authentication using `AuthenticationManager`
- 🛡️ Endpoint-level security configuration
- 🌐 REST API with public and secured endpoints
- ⚡ Preloading users using `CommandLineRunner`

---

## 🏗️ System Architecture

### 🔄 Authentication Flow

```text
Client Request (Basic Auth Header)
        ↓
Spring Security Filter Chain
        ↓
UsernamePasswordAuthenticationFilter
        ↓
AuthenticationManager
        ↓
UserDetailsService
        ↓
Database / In-Memory User
        ↓
Password Validation (BCrypt)
        ↓
SecurityContext (Authenticated User)
        ↓
Controller Access Granted

```

---

## 🧠 Core Concepts Explained

### 🔑 1. Basic Authentication

Basic Authentication uses the HTTP header:
```
Authorization: Basic base64(username:password)
```
Spring Security automatically extracts and processes these credentials.

### 🔒 2. Password Encoding

Passwords are never stored in plain text. Instead, they are hashed using BCrypt:
```
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```
✔ Ensures strong encryption
✔ Protects against brute-force attacks

### 👤 3. UserDetails Implementation

The UserBean class implements UserDetails and acts as the core user model:

- Stores username, password, roles
- Provides authorities to Spring Security
- Integrates directly with authentication flow

### 🧩 4. UserDetailsService

Custom service responsible for:

- Fetching user from database
- Converting it into UserDetails
- Supplying user data to authentication system

### ⚙️ 5. AuthenticationManager

Acts as the authentication engine:

- Receives authentication request
- Delegates validation to providers
- Returns authenticated object if successful

### 🛡️ 6. Security Configuration
```
http
    .csrf().disable()
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/public").permitAll()
        .anyRequest().authenticated()
    )
    .httpBasic();
```
✔ Defines public vs secured endpoints
✔ Enables Basic Authentication
✔ Disables CSRF for REST APIs

---

## 📂 Project Structure
```
src/main/java/com/
│
├── config/          # Security configuration
├── controller/      # REST controllers (API endpoints)
├── entity/          # User entity (implements UserDetails)
├── service/         # Business logic & UserDetailsService
├── repository/      # Data access layer (JPA)
└── runner/          # Initial data loader (CommandLineRunner)
```

### 🌐 API Endpoints
  - Endpoint	Method	Access	Description
  - /api/public	GET	Public	Accessible without auth
  - /api/private	GET	Secured	Requires authentication
    
### 🔐 Authentication Example
Using cURL
```
curl -u username:password http://localhost:8080/api/private
```

Using Postman

- Select Basic Auth
- Enter username and password
- Send request to secured endpoint
  
### 🧪 Sample Credentials
```
  Username	admin
  user	admin123
```

(Configured via CommandLineRunner or database)

---

### ⚙️ How to Run the Project

Clone the repository:
```
git clone <your-repo-url>
```

Navigate to project:
```
cd project-folder
```

Run the application:
```
mvn spring-boot:run
```

Access APIs:
```
http://localhost:8080/api/public
http://localhost:8080/api/private
```

---
