# Sistema de Gerenciamento de Projetos (SGP)

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de usuários, projetos e tarefas.  
O sistema permite acompanhar projetos, organizar atividades e controlar fluxos de trabalho de forma estruturada.

---

## 📌 Sobre o Projeto

Este projeto foi criado com foco em boas práticas de desenvolvimento backend utilizando arquitetura modular por domínio, tratamento global de exceções, validações robustas e organização profissional de código.

Ideal para estudos de:

- Spring Boot
- APIs REST
- Java Backend
- JPA / Hibernate
- DTO Pattern
- Exception Handling
- Clean Code
- Arquitetura em Camadas

---

## 🚀 Funcionalidades

### 👤 Usuários
- Criar usuário
- Buscar usuário por ID
- Listar usuários
- Atualizar usuário
- Remover usuário
- Controle de status do usuário

### 📁 Projetos
- Criar projetos
- Definir responsável
- Atualizar dados do projeto
- Alterar status
- Listar projetos
- Buscar projeto por ID
- Excluir projetos

### ✅ Tarefas
- Criar tarefas vinculadas a projetos
- Definir responsável
- Alterar prioridade
- Alterar status
- Atualizar tarefa
- Listar tarefas
- Buscar tarefa por ID
- Excluir tarefas

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- MySQL
- Maven
- Lombok

---

## 📂 Estrutura do Projeto

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

## 🧱 Arquitetura

O projeto utiliza **arquitetura modular por domínio**, onde cada módulo contém seus próprios arquivos.

### Módulos:

* `usuario` → entidade, controller, service, repository, mapper e DTOs
* `projeto` → entidade, controller, service, repository, mapper e DTOs
* `tarefa` → entidade, controller, service, repository, mapper e DTOs

### Compartilhado:

* `common` → exceções globais e DTOs compartilhados
* `enums` → enums do sistema

---

## 🔥 Endpoints Principais

### Usuários

```http id="fd29w3"
POST   /usuarios
GET    /usuarios
GET    /usuarios/{id}
PUT    /usuarios/{id}
DELETE /usuarios/{id}
```

### Projetos

```http id="3c0f7v"
POST   /projetos
GET    /projetos
GET    /projetos/{id}
PUT    /projetos/{id}
DELETE /projetos/{id}
```

### Tarefas

```http id="h6vayp"
POST   /tarefas
GET    /tarefas
GET    /tarefas/{id}
PUT    /tarefas/{id}
DELETE /tarefas/{id}
```

---

## ⚠️ Tratamento de Erros

A aplicação possui tratamento global utilizando `@RestControllerAdvice`.

Exemplo:

```json id="j6vdf2"
{
  "timestamp": "2026-04-27T12:00:00",
  "status": 404,
  "erro": "Recurso não encontrado",
  "mensagem": "Projeto não encontrado",
  "path": "/projetos/99"
}
```

---

## ⚙️ Configuração Banco de Dados

No arquivo `application.properties`:

```properties
spring.application.name=sgp-api

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/sgp_db
spring.datasource.username=root
spring.datasource.password=root
```
---

## 🎯 Objetivo do Projeto

Demonstrar domínio em desenvolvimento backend Java com Spring Boot através da construção de uma API realista, organizada e escalável.

---

## 👨‍💻 Autor

Victor de Oliveira Alves

* GitHub: [https://github.com/victordeoliveira1](https://github.com/victordeoliveira1)
* LinkedIn: [https://linkedin.com/in/victor-de-oliveira1](https://linkedin.com/in/victor-de-oliveira1)

---

## 📄 Licença

Projeto para fins educacionais e portfólio.

