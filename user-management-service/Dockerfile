# Multi-stage build
# Stage 1: Build the application with Maven and Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

# Stage 2: Production image
FROM eclipse-temurin:21-jre-alpine AS production
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
COPY entrypoint.sh /
RUN chmod +x entrypoint.sh
EXPOSE ${SERVER_PORT_USER} # Use user management port
ENTRYPOINT ["/entrypoint.sh"]

# Development stage
FROM eclipse-temurin:21-jdk-alpine AS development
WORKDIR /app
COPY pom.xml .
COPY src ./src