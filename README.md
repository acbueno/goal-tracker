# Goal Tracker

A Spring Boot application using MongoDB to manage user goals and plans.

## Features
- User registration with associated goals and plans.
- MongoDB as the database for flexible document storage.
- REST API for managing users, plans, and goals.
- Docker support for MongoDB setup.

## Prerequisites
- Java 17+
- Maven
- Docker (optional, for MongoDB setup)

## Getting Started

### Clone the Repository
```sh
git clone https://github.com/acbueno/goal-tracker.git
cd goal-tracker
```

### Run MongoDB using Docker
```sh
docker run --name mongodb -d -p 27017:27017 \
  -e MONGO_INITDB_ROOT_USERNAME=root \
  -e MONGO_INITDB_ROOT_PASSWORD=pass \
  mongodb
```

### Configure Application Properties
Edit `application.yml` if necessary:
```yaml
spring:
  application:
    name: goal-tracker
  data:
    mongodb:
      database: goal_tracker
      uri: mongodb://root:password@localhost:27017/goal_tracker?authSource=admin
server:
  port: 8096
```

### Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints
### Get All Plans for a User
```http
GET /plan/{userId}
```

### Create a New User
```http
POST /user
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "plans": []
}
```

## Technologies Used
- **Spring Boot** (Spring Data MongoDB, Spring Web)
- **MongoDB**
- **Docker**
- **Maven**

## Contributing
Feel free to fork this repository and submit pull requests!

## License
This project is licensed under the MIT License.
