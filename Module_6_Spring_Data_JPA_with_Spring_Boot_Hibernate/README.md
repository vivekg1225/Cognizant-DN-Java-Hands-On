# Employee Management System

This project manages employees and departments while demonstrating CRUD operations, entity relationships, custom query methods, pagination, and sorting using an H2 in-memory database.

---

## Exercises Covered

### Exercise 1 – Project Setup

- Created a Spring Boot project using Maven.
- Added required dependencies:
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - H2 Database
  - Lombok
- Configured the H2 in-memory database in `application.properties`.

---

### Exercise 2 – Entity Creation

Created the following JPA entities:

#### Employee
- id
- name
- email
- department

#### Department
- id
- name

Implemented a **One-to-Many / Many-to-One** relationship between Department and Employee using JPA annotations.

---

### Exercise 3 – Repository Layer

Created repository interfaces by extending `JpaRepository`.

#### EmployeeRepository
- CRUD operations
- Derived query methods
- JPQL queries
- Named queries

#### DepartmentRepository
- CRUD operations
- Custom query methods

---

### Exercise 4 – CRUD Operations

Implemented REST APIs for:

#### Employee
- Create Employee
- Get All Employees
- Get Employee by ID
- Update Employee
- Delete Employee

#### Department
- Create Department
- Get All Departments
- Get Department by ID
- Update Department
- Delete Department

---

### Exercise 5 – Query Methods

Implemented different query techniques available in Spring Data JPA.

#### Derived Query Methods

Examples:

- Find employee by name
- Find employee by email
- Find employees by department

#### JPQL Queries

Implemented custom queries using the `@Query` annotation.

#### Named Queries

Implemented reusable named queries using `@NamedQuery`.

---

### Exercise 6 – Pagination and Sorting

Implemented:

- Pagination using `Page` and `Pageable`
- Sorting using `Sort`
- Combined Pagination and Sorting

Example endpoints:

```
GET /employees/page?page=0&size=5

GET /employees/sort?field=name

GET /employees/page-sort?page=0&size=5&field=name
```

---

# Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- H2 Database
- Lombok
- Postman

---

# Project Structure

```
src
 └── main
      ├── java
      │    └── org.example
      │          ├── controller
      │          ├── entity
      │          ├── repository
      │          ├── service
      │          └── EmployeeManagementSystemApplication
      │
      └── resources
           └── application.properties
```

---

# REST API Endpoints

## Department APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /departments | Create Department |
| GET | /departments | Get All Departments |
| GET | /departments/{id} | Get Department by ID |
| PUT | /departments/{id} | Update Department |
| DELETE | /departments/{id} | Delete Department |

---

## Employee APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /employees | Create Employee |
| GET | /employees | Get All Employees |
| GET | /employees/{id} | Get Employee by ID |
| PUT | /employees/{id} | Update Employee |
| DELETE | /employees/{id} | Delete Employee |

---

## Query Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /employees/name/{name} | Find Employee by Name |
| GET | /employees/email/{email} | Find Employee by Email |
| GET | /employees/department/{department} | Find Employees by Department |

---

## Pagination & Sorting

| Endpoint | Description |
|----------|-------------|
| /employees/page?page=0&size=5 | Pagination |
| /employees/sort?field=name | Sorting |
| /employees/page-sort?page=0&size=5&field=name | Pagination with Sorting |

---

# Features Implemented

- Spring Boot REST API
- Spring Data JPA
- Hibernate ORM
- Entity Relationships
- Repository Pattern
- CRUD Operations
- Derived Query Methods
- JPQL Queries
- Named Queries
- Pagination
- Sorting
- H2 In-Memory Database

---

# Learning Outcomes

Through this project, the following Spring Boot concepts were explored:

- Spring Boot project setup
- Spring Data JPA repositories
- Hibernate entity mapping
- One-to-Many and Many-to-One relationships
- CRUD operations using JpaRepository
- Derived query methods
- JPQL and Named Queries
- Pagination using Pageable
- Sorting using Sort
- REST API development and testing with Postman

---

## Author

**Vivek Gupta**