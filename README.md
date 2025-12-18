# 🎓 Projeto Pessoal: Learning Platform – Spring Boot REST API

## Visão Geral do Projeto

Este projeto é uma API RESTful completa desenvolvida com Spring Boot 3 + Spring Data JPA, simulando uma plataforma de cursos online (learning platform), com gerenciamento de usuários, cursos, categorias, aulas, matrículas e pagamentos.

Este é um projeto pessoal e prático, criado para consolidar meus conhecimentos em Back-End com Java e Spring, seguindo boas práticas de arquitetura, organização em camadas e modelagem de domínio.

---

## 🎯 Objetivos do projeto
* **Aplicar conceitos fundamentais de Spring Boot em um projeto real** 
* **Praticar modelagem de domínio com JPA/Hibernate**
* **Construir uma API REST bem estruturada, seguindo o padrão de camadas:** 
* **Implementar CRUD completo, tratamento de exceções e boas práticas REST**

--- 

## 📖 Principais Conceitos Aplicados

- **Modelagem de Domínio com JPA/Hibernate**
  - Relacionamentos **One-to-One**, **One-to-Many** e **Many-to-Many com chave composta**
  - Uso de `@EmbeddedId` para chaves primárias compostas
  - Enumerações persistidas no banco de dados

- **Arquitetura em Camadas**
  - `resources` → Controllers REST
  - `services` → Regras de negócio
  - `repositories` → Acesso a dados com Spring Data JPA

- **CRUD Completo**
  - Create, Read, Update e Delete
  - Banco de dados H2 configurado para testes

- **Tratamento Global de Exceções**
  - Uso de `@ControllerAdvice`
  - Retorno de erros HTTP padronizados

---

## 🏗️ Arquitetura do Projeto

O projeto segue o **padrão de arquitetura em três camadas**:

- **Resources (Controllers)**
  - Exposição dos endpoints REST

- **Services**
  - Regras de negócio
  - Controle transacional

- **Repositories**
  - Persistência de dados com Spring Data JPA

---

## 📊 Modelo de Domínio (Entidades)

### 🔹 Entidades Principais

- **User** – Usuários da plataforma
- **Course** – Cursos disponíveis
- **Category** – Categorias dos cursos
- **Lesson** – Aulas de um curso
- **Enrollment** – Matrícula de usuários em cursos
- **Payment** – Pagamento associado à matrícula

### 🔹 Enumerações

- `UserRole` – Papel do usuário
- `CourseLevel` – Nível do curso
- `EnrollmentStatus` – Status da matrícula

### 🔹 Relacionamentos

- **One-to-Many**
  - Category → Course
  - Course → Lesson
  - User → Enrollment

- **Many-to-Many com atributos extras**
  - User ↔ Course via **Enrollment** (chave composta)

- **One-to-One**
  - Enrollment ↔ Payment

---

## 🛠️ Tecnologias Utilizadas

| Categoria | Tecnologia | Detalhe |
| :--- | :--- | :--- |
| **Framework** | Spring Boot | Desenvolvimento rápido de APIs REST. |
| **Linguagem** | Java | Linguagem base do projeto. |
| **Persistência** | Spring Data JPA / Hibernate | Mapeamento Objeto-Relacional. |
| **Banco de Dados** | H2 Database | Banco de dados **em memória** para teste e desenvolvimento local. |
| **Build Tool** | Apache Maven | Gerenciamento de dependências. |
| **Testes** | Postman | Utilizado para testar os endpoints da API. |

---

## ⚙️ Como Executar a API Localmente

O projeto está configurado para usar o perfil `test` e o banco de dados H2 para que o banco seja inicializado e populado automaticamente.

1.  **Pré-requisitos:** Certifique-se de ter o **JDK** e o **Maven** instalados.
2.  **Importar:** Clone o projeto e importe-o como um **Projeto Maven** no seu IDE (Ex: STS/Eclipse, IntelliJ).
3.  **Configuração do H2:** O console do H2 é habilitado para visualização.
    * **JDBC URL:** `jdbc:h2:mem:testdb` 
    * **Console:** `http://localhost:8080/h2-console` 
4.  **Executar:** Execute a classe principal `CourseApplication.java` como uma aplicação Spring Boot.
5.  **Acesso à API:** A API estará rodando em `http://localhost:8080`.

---

 ## 🛡️ Tratamento de Exceções

O projeto utiliza um `ResourceExceptionHandler` (via `@ControllerAdvice`) para interceptar exceções e retornar respostas HTTP padronizadas (JSON de erro), garantindo que a API não retorne erros internos 500 para falhas esperadas.

| Exceção de Serviço | Código HTTP | Descrição |
| :--- | :--- | :--- |
| `ResourceNotFoundException` | **404 Not Found** | Recurso não encontrado (ex: `GET /users/99`). |
| `DatabaseException` | **400 Bad Request** | Erro de integridade de dados (ex: tentar excluir um recurso com associações ativas). |

---

## 🔗 Endpoints Principais (Exemplos)

Recurso | Método | URI | Ação | Status de Sucesso
--------|--------|-----|------|-----------------
User | GET | /users | Listar todos os usuários | 200 OK
User | GET | /users/{id} | Buscar usuário por ID | 200 OK / 404 Not Found
User | POST | /users | Inserir um novo usuário | 201 Created
User | PUT | /users/{id} | Atualizar usuário | 200 OK / 404 Not Found
User | DELETE | /users/{id} | Remover usuário | 204 No Content / 404 Not Found
Course | GET | /courses | Listar todos os cursos | 200 OK
Course | GET | /courses/{id} | Buscar curso por ID | 200 OK / 404 Not Found
Category | GET | /categories | Listar todas as categorias | 200 OK
Category | GET | /categories/{id} | Buscar categoria por ID | 200 OK / 404 Not Found
Lesson | GET | /lessons/{id} | Buscar aula por ID | 200 OK / 404 Not Found
Enrollment | GET | /enrollments/{userId}/{courseId} | Buscar matrícula | 200 OK / 404 Not Found
Payment | GET | /payments/{id} | Buscar pagamento | 200 OK / 404 Not Found
