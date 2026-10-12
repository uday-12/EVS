# EVS - Electronic Voting System

A Java-based electronic voting system built with Spring Boot, Spring MVC, JSP, and MySQL. The project supports election administration, voter registration, election officer approval, vote casting, and result publication.

## Overview

This application provides a web-based workflow for managing elections end-to-end:

- Admin creates elections, parties, and candidates
- Election officers validate voter registrations and approve or reject voters
- Voters register, log in, and cast their vote in active elections
- Administrators can start/stop election periods and publish results

The front end is implemented using JSP views, while the business logic and persistence are handled by Spring Boot and JPA repositories.

## Key Features

- Admin dashboard for election management
- Election creation and status tracking
- Party and candidate management with uploaded images
- Election officer login and voter approval workflow
- Voter registration and login flow
- Vote casting for active elections
- Result generation and winner selection
- MySQL persistence with Hibernate auto-creation/update

## Tech Stack

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- JSP / JSTL
- Maven Wrapper

## Project Structure

```text
EVS/
├── src/
│   ├── main/
│   │   ├── java/com/rgukt/evs/
│   │   │   ├── controllers/
│   │   │   ├── dao/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── service/
│   │   │   └── EvsApplication.java
│   │   ├── resources/
│   │   │   └── application.properties
│   │   ├── webapp/jsp/
│   │   └── webapp/bootstrap/
│   └── test/
├── mvnw
├── mvnw.cmd
├── HELP.md
└── README.md
```

## Prerequisites

Before running the project, make sure you have:

- Java JDK 8+ (preferably JDK 11 or 17)
- Maven (or use the included Maven Wrapper)
- MySQL Server running locally
- A database named `evsrgukt` (or update the configuration)

## Configuration

Update the database connection settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/evsrgukt
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

You may also adjust the application port, file upload limits, and other settings if needed.

## Running the Application

From the project root, run:

```bash
./mvnw spring-boot:run
```

On Windows, use:

```bash
mvnw.cmd spring-boot:run
```

Then open the app in a browser using:

```text
http://localhost:8080/
```

## User Roles

### Admin
- Add and manage elections
- Add parties and candidates
- Register election officers
- Start/stop elections
- Approve and publish results

### Election Officer
- Review voter registration requests
- Approve or reject voter access
- Manage the election workflow

### Voter
- Register for voting
- Log in securely
- Cast a vote in an active election
- View results once published

## Notes

This is a classroom or demo-style voting system and is not intended for production use without additional security hardening, audit controls, role-based authentication improvements, and full production deployment safeguards.

## License

This project does not currently include a separate license file. Please check with the repository owner before reusing it in external projects.
