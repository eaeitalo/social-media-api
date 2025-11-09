# Social Media API / API de Rede Social

Complete social media API developed with Java Spring Boot featuring layered architecture and asynchronous messaging.

API completa de rede social desenvolvida em Java Spring Boot com arquitetura em camadas e mensageria assíncrona.

## 📋 About the Project / Sobre o Projeto

Backend system for a social network with user management, posts, interactions, and real-time notifications.

Sistema backend para uma rede social com funcionalidades de usuários, posts, interações e notificações em tempo real.

## 🛠️ Technologies / Tecnologias

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL** / H2 Database
- **RabbitMQ** (Messaging / Mensageria)
- **Maven**
- **Hibernate**

## 🏗️ Architecture / Arquitetura

- Layered architecture (Controller → Service → Repository)
- Arquitetura em camadas (Controller → Service → Repository)
- RESTful API
- Asynchronous communication with RabbitMQ
- Comunicação assíncrona com RabbitMQ
- JPA/Hibernate for persistence
- JPA/Hibernate para persistência

## 🖼️ API Demonstration / Demonstração da API

### Health Check
![Health Check](images/health-check.png)

### Create User / Criar Usuário  
![Create User](images/create-user.png)

### List Users / Listar Usuários
![List Users](images/list-users.png)

### Search Posts / Buscar Posts
![Search Posts](images/search-posts.png)

## 📡 Main Endpoints / Endpoints Principais

### Users / Usuários
- `POST /api/users` - Create user / Criar usuário
- `GET /api/users` - List all users / Listar todos usuários
- `GET /api/users/{id}` - Find user by ID / Buscar usuário por ID

### Posts
- `POST /api/posts` - Create post / Criar post
- `GET /api/posts` - List all posts / Listar todos posts
- `GET /api/posts/user/{userId}` - User's posts / Posts de um usuário
- `GET /api/posts/search?q={term}` - Search posts / Buscar posts

### Interactions / Interações
- `POST /api/posts/{postId}/like/{userId}` - Like post / Curtir post
- `POST /api/users/{followerId}/follow/{targetUserId}` - Follow user / Seguir usuário
- `GET /api/posts/user/{userId}/feed` - Personalized feed / Feed personalizado

## 🚀 How to Run / Como Executar

1. Clone the repository / Clone o repositório:
```bash
git clone https://github.com/eaeitalo/social-media-api.git

2. Configure database in application.properties / Configure o banco de dados no application.properties

3. Run the application / Execute a aplicação:

bash
mvn spring-boot:run

4. Access: http://localhost:8080 / Acesse: http://localhost:8080

📊 Features / Funcionalidades
Users and posts CRUD / CRUD de usuários e posts

Follow/unfollow system / Sistema de follow/unfollow

Like posts / Curtir posts

Personalized feed / Feed personalizado

Posts search / Busca de posts

Asynchronous notifications with RabbitMQ / Notificações assíncronas com RabbitMQ

👨‍💻 Developer / Desenvolvedor
Italo - @eaeitalo
