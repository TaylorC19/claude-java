# Claude Java Spring Boot Application

A demo Spring Boot web application demonstrating form handling, Thymeleaf templating, and component-based UI structure.

## Features

- **Contact Form**: Submit name, email, and message
- **Data Display**: View all submitted forms with timestamps
- **Component Templates**: Reusable HTML fragments using Thymeleaf
- **Responsive Design**: Clean, modern CSS styling
- **Form Validation**: Required field validation
- **Memory Storage**: Submissions stored in-memory during application runtime

## Prerequisites

- Java 21 or higher
- Maven 3.6+ (or use the included Maven wrapper)

## Project Structure

```
src/
├── main/
│   ├── java/com/example/claude_java/
│   │   ├── ClaudeJavaApplication.java      # Main Spring Boot application
│   │   ├── controller/
│   │   │   └── HomeController.java         # Handles web requests
│   │   └── model/
│   │       └── FormSubmission.java         # Data model for form submissions
│   └── resources/
│       ├── application.properties          # App configuration (port: 8081)
│       └── templates/
│           ├── index.html                  # Main page template
│           └── fragments/
│               ├── header.html             # CSS and head section
│               ├── form.html               # Contact form component
│               └── submissions.html        # Submissions display component
```

## How to Run

### Using Maven Wrapper (Recommended)

```bash
./mvnw spring-boot:run
```

On Windows:
```cmd
mvnw.cmd spring-boot:run
```

### Using Maven

```bash
mvn spring-boot:run
```

## Access the Application

Once started, the application will be available at:
- **URL**: http://localhost:8081
- **Port**: 8081

## How to Use

1. Navigate to http://localhost:8081
2. Fill out the contact form with:
   - Name (required)
   - Email (required)
   - Message (required)
3. Click "Submit"
4. View your submission in the list below the form
5. Submit multiple forms to see them all displayed

## Technical Details

### Technologies Used
- **Spring Boot 3.5.4**: Web framework and application container
- **Thymeleaf**: Server-side template engine
- **Maven**: Build tool and dependency management
- **Embedded Tomcat**: Web server

### Key Concepts Demonstrated
- **MVC Pattern**: Model-View-Controller architecture
- **Template Fragments**: Reusable UI components with `th:fragment` and `th:replace`
- **Form Binding**: Spring's `@ModelAttribute` for form data binding
- **Data Transfer**: Using Spring's `Model` to pass data to templates
- **Thymeleaf Features**: Loops (`th:each`), conditionals (`th:if`), text binding (`th:text`)

## Testing

Run tests with:
```bash
./mvnw test
```

## Building

Build the application:
```bash
./mvnw clean package
```

The built JAR file will be located in the `target/` directory.

## Learning Objectives

This application is designed to help junior Java developers learn:
- Spring Boot basics and auto-configuration
- Web controller development with Spring MVC
- HTML templating with Thymeleaf
- Form handling and data binding
- Component-based UI design
- Java model classes and object-oriented principles# claude-java
