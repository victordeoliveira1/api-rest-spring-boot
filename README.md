# SGP - Project Management System API

REST API built with Java and Spring Boot for project management. The system allows tracking projects, organizing activities and controlling workflows in a structured way.

## 📌 About

This project was created focusing on backend development best practices, using domain-driven modular architecture, global exception handling, robust validations and professional code organization.

Ideal for studying:

- Spring Boot
- REST APIs
- Java Backend
- JPA / Hibernate
- DTO Pattern
- Exception Handling
- Clean Code
- Layered Architecture

## 🚀 Features

### 👤 Users

- Create user
- Find user by ID
- List users
- Update user
- Remove user
- User status control

### 📁 Projects

- Create projects
- Assign responsible
- Update project data
- Change status
- List projects
- Find project by ID
- Delete projects

### ✅ Tasks

- Create tasks linked to projects
- Assign responsible
- Change priority
- Change status
- Update task
- List tasks
- Find task by ID
- Delete tasks

## 🛠️ Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- MySQL
- Maven
- Lombok

## 📂 Project Structure

```bash
src/main/java/br/com/treina/recife/sgp/api/

├── common
│   ├── dto
│   └── exception
│
├── enums
│
├── projeto
│   ├── Projeto.java
│   ├── ProjetoController.java
│   ├── ProjetoMapper.java
│   ├── ProjetoRepository.java
│   ├── ProjetoRequestDTO.java
│   ├── ProjetoResponseDTO.java
│   └── ProjetoService.java
│
├── tarefa
│   ├── Tarefa.java
│   ├── TarefaController.java
│   ├── TarefaMapper.java
│   ├── TarefaRepository.java
│   ├── TarefaRequestDTO.java
│   ├── TarefaResponseDTO.java
│   └── TarefaService.java
│
├── usuario
│   ├── Usuario.java
│   ├── UsuarioController.java
│   ├── UsuarioMapper.java
│   ├── UsuarioRepository.java
│   ├── UsuarioRequestDTO.java
│   ├── UsuarioResponseDTO.java
│   └── UsuarioService.java
│
└── SgpApiApplication.java
````

---

## 🧱 Architecture

The project uses domain-driven modular architecture, where each module contains its own files.

### Modules:

- `usuario` → entity, controller, service, repository, mapper and DTOs
- `projeto` → entity, controller, service, repository, mapper and DTOs
- `tarefa` → entity, controller, service, repository, mapper and DTOs

### Shared:

- `common` → global exceptions and shared DTOs
- `enums` → system enums

## 🔥 Main Endpoints

### Users

```http id="fd29w3"
POST   /usuarios
GET    /usuarios
GET    /usuarios/{id}
PUT    /usuarios/{id}
DELETE /usuarios/{id}
```

### Projects

```http id="3c0f7v"
POST   /projetos
GET    /projetos
GET    /projetos/{id}
PUT    /projetos/{id}
DELETE /projetos/{id}
```

### Tasks

```http id="h6vayp"
POST   /tarefas
GET    /tarefas
GET    /tarefas/{id}
PUT    /tarefas/{id}
DELETE /tarefas/{id}
```

---

## ⚠️ Error Handling

The application has global error handling using `@RestControllerAdvice`.

Example:

```json
{
  "timestamp": "2026-04-27T12:00:00",
  "status": 404,
  "erro": "Resource not found",
  "mensagem": "Project not found",
  "path": "/projetos/99"
}
```

## ⚙️ Database Configuration

In the `application.properties` file:

```properties
spring.application.name=sgp-api

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/sgp_db
spring.datasource.username=root
spring.datasource.password=root
```
---

## 🎯 Project Goal

Demonstrate backend Java development skills with Spring Boot by building a realistic, organized and scalable API.

---

## 👨‍💻 Author

Victor de Oliveira Alves

* GitHub: [https://github.com/victordeoliveira1](https://github.com/victordeoliveira1)
* LinkedIn: [https://linkedin.com/in/victor-de-oliveira1](https://linkedin.com/in/victor-de-oliveira1)

---

## 📄 License

Project for educational and portfolio purposes.

