# CEFRify Backend

Spring Boot REST API backend for the **CEFRify** English Proficiency Assessment mobile application. This backend handles user management, test question delivery, audio file processing, and CEFR level evaluation.
---

## 🚀 Project Overview

The CEFRify backend provides comprehensive support for English proficiency testing by:

### Core Features
- **User Management** - Registration and profile management without authentication
- **Test Question Delivery** - Serving structured questions for three test rounds
- **Audio Processing** - Handling audio file uploads and serving audio content
- **CEFR Evaluation** - Automated scoring and proficiency level determination
- **Result Management** - Storing and retrieving test results with detailed analytics

### Test Structure
1. **Round 1: Text Repetition** - Users read and repeat provided texts
2. **Round 2: Audio Comprehension** - Users listen and respond to audio prompts  
3. **Round 3: Free Speech** - Users speak spontaneously on given topics

---

## 🛠️ Tech Stack

### Core Technologies
- **Java 17+** - Modern Java features and performance
- **Spring Boot 3.x** - Enterprise-grade application framework
- **Spring Data JPA** - Data persistence and ORM with Hibernate
- **PostgreSQL** - Robust relational database
- **Maven** - Dependency management and build automation

### Additional Libraries
- **Lombok** - Boilerplate code reduction
- **Jakarta Persistence API** - JPA 3.0 specification
- **Spring Web** - RESTful web services
- **Spring Validation** - Input validation and sanitization
- **Jackson** - JSON processing and serialization

### TODO's Integrations
- **OpenAI Whisper** - Speech-to-text conversion
- **Google Speech-to-Text** - Audio transcription services
- **AssemblyAI** - Advanced audio analysis
- **AWS S3** - Cloud storage for audio files

---

## 🎯 Getting Started

### Prerequisites

Ensure you have the following installed:

- **Java 17+** ([Download](https://openjdk.org/))
- **PostgreSQL 15+** ([Download](https://postgresql.org/download/))
- **Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **Git** ([Download](https://git-scm.com/))

### Quick Setup

```bash
# Clone the repository
git clone https://github.com/yourusername/cefrify-backend.git
cd cefrify-backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

---

## 🗄️ Database Setup

### 1. Create PostgreSQL Database

```sql
-- Connect to PostgreSQL as superuser
sudo -u postgres psql

-- Create database and user
CREATE DATABASE cefrifydb;
CREATE USER cefruser WITH PASSWORD 'cefrpass123';

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE cefrifydb TO cefruser;
GRANT USAGE ON SCHEMA public TO cefruser;
GRANT CREATE ON SCHEMA public TO cefruser;

-- Exit PostgreSQL
\q
```

### 2. Configure Application Properties

Update `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/cefrifydb
spring.datasource.username=cefruser
spring.datasource.password=cefrpass123
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080
server.servlet.context-path=/cefrify/api

# File Upload Configuration
spring.servlet.multipart.max-file-size=50MB
spring.servlet.multipart.max-request-size=50MB

# Logging Configuration
logging.level.com.cefr.cefrify=DEBUG
logging.level.org.springframework.web=INFO
```

---

## 📁 Project Structure

```
src/
└── main/
├── java/
│ └── com/
│ └── cefr/
│ └── cefrify/
│ ├── CefrifyApplication.java
│ ├── controller/
│ │ ├── SubmissionController.java
│ │ ├── QuestionController.java
│ │ └── AnswerController.java
│ ├── model/
│ │ ├── UserSubmission.java
│ │ ├── Question.java
│ │ ├── AudioFile.java
│ │ └── Answer.java
│ ├── repository/
│ │ ├── UserSubmissionRepository.java
│ │ ├── QuestionRepository.java
│ │ ├── AudioFileRepository.java
│ │ └── AnswerRepository.java
│ └── service/
│ ├── QuestionService.java
│ ├── AudioService.java
│ └── AnswerService.java
└── resources/
├── application.properties
└── static/
└── audios/ # Audio files served to frontend
```

---

## API Endpoints

| Method | URL                       | Description                           | Request Body                | Response                              |
|--------|---------------------------|-------------------------------------|----------------------------|-------------------------------------|
| POST   | `/cefrify/api/start`      | Submit user name & email to start test | `{ "name": "...", "email": "..." }` | Saved user object with `id`          |
| GET    | `/cefrify/api/questions/round/{n}` | Get questions for round n (1, 2, or 3) | N/A                        | List of questions with text/audio URLs |
| POST   | `/cefrify/api/answers/upload` | Upload user audio answer file for a question | multipart form-data with userId, questionId, file | Status message                       |
| GET    | `/cefrify/api/results/{userId}` | Get results & CEFR level for user (future)  | N/A                        | User's test results and level info   |

---

## Notes

- The API base path is `/cefrify/api`; adjust your frontend requests accordingly.
- No authentication implemented currently.
- Audio files served from `/static/audios/` folder.
- Evaluation logic (speech-to-text, CEFR scoring) to be integrated in future versions.

---

## TODO's

- Add validation for user submission inputs.
- Implement audio file saving logic (filesystem or cloud storage).
- Integrate speech-to-text APIs (OpenAI Whisper, Google, AssemblyAI).
- Automate scoring and CEFR level determination.
- Add authentication for user session control.
- Implement admin dashboard for manual score review and question management.

---
