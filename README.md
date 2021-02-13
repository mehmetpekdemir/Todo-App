# Todo App 

### What is the Hexagonal Architecture

The hexagonal architecture was invented by Alistair Cockburn in an attempt to avoid known structural pitfalls in object-oriented software design, such as undesired dependencies between layers and contamination of user interface code with business logic, and published in 2005.

> A timeless goal of sofware engineering has been to separate code that changes frequently from code that is stable.
> 
> ~ James Coplien / Lean Architecture

We recommend Hexagonal Architecture for those who want to write clean, maintainable, well-defined boundary context, well-tested domain and decoupling business logic from technical code.

### Tech Stack
 - Java 11
 - Spring Boot
 - Spring Data Jpa
 - Spring Security
 - Swagger
 - Integration Tests
 - Consumer Driven Contract Tests
 - Javascript
 - React.js
 - ReactStrap
 - Hexagonal Architecture
 
### Requirements

For building and running the application you need:
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or newer . 
- [Maven](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)
- [MySQL](https://www.mysql.com/)


### Build & Run

 ###### Create DB 
```
CREATE DATABASE todo_dev;
CREATE DATABASE todo_test;
```
  ###### Backend
  
```
mvn clean install && mvn --projects backend spring-boot:run
```

  ###### Frontend
  
##### (Install all dependencies)
```
npm install
```

##### (Start Project)
```
npm start
```

##### (Port)
```
Backend :  http://localhost:8081
```

```
Frontend : http://localhost:3000
```

##### Use Postman collection 

### Integration tests && Contract tests

![test](https://github.com/mehmetpekdemir/Todo-App/blob/master/docs/testcoverage.png)

