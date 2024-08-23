# Bookstore Backend

## Overview
This is the backend for bookstore application, built with Spring Boot and Spring DATA JPA. It provides APIs for managing books, authors, genres, editions, inventory, and  orders.

## Features
- **Books Management**: CRUD operations for books, search functionality, adding books functionality
- **Authors Management**: Create and Read operations for authors: Author details in the bookstore
- **Genres Management**: Create and Read operations for genres: Genre details in the bookstore
- **Editions Management**: CRUD operations for book editions: Editions of a particular book with details.
- **Inventory Management**: CRUD operations for inventory having Stock information: Sold Stocks and Total Stocks
- **Order Management**: Creation of Orders with details on OrderItems and status of an Order with Payment details.

## Technologies
- **Spring Boot**: For building the RESTful APIs.
- **JPA / Hibernate**: For database interactions.
- **MySQL**: Database system.
- **Lombok**: To reduce boilerplate code.

## Setup

### Prerequisites
- Java 17+
- Maven
- MySQL

### Softwares
- IntelliJ IDEA
- MySQLWorkBench
- POSTMAN

### Configuration

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/deviprasad-bal/bookstore-management-backend.git
   cd demo\ 4
   ```

2. **Set Up the Database**:
    Create a MySQL database for the application
    Update the application.properties file located in src/main/resources with your MySQL database details:


    ```spring.datasource.url = jdbc:mysql://localhost:3306/bookstore
    spring.datasource.username = your-username
    spring.datasource.password = your-password
    spring.datasource.driver-class-name =com.mysql.cj.jdbc.Driver
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true```

3. **Build and Run the Project**:
    Open IntelliJ IDEA.
    Select File > Open and navigate to the directory where you cloned the project.
    Select the bookstore directory and click OK.
    Go to Build > Build Project from the top menu. IntelliJ IDEA will compile the code and build the project.

    In the Project tool window (usually on the left side), navigate to src/main/java/com.devi.bookstore.
    Right-click on the main class with the @SpringBootApplication annotation named BookstoreApplication.java .
    Select Run 'BookstoreApplication.main()' to start the application.

    The application will start and be accessible at http://localhost:8080.

    4. **Test On POSTMAN**
    Use tools like Postman to test the APIs.
    Ex: http://localhost:8080/bookstore/books

    Ensure MySQL is running on port 3306 (by default)


