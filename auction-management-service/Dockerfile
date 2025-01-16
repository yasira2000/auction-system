# Multi-stage build
# Stage 1: Build the application with Maven and Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn dependency:go-offline # Download dependencies for offline build
RUN mvn package -DskipTests

# Stage 2: Create a minimal image for production (if needed)
FROM eclipse-temurin:21-jre-alpine AS production
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
COPY entrypoint.sh /
RUN chmod +x entrypoint.sh
EXPOSE ${SERVER_PORT}
ENTRYPOINT ["/entrypoint.sh"]

# Development stage (used by docker-compose for development)
FROM eclipse-temurin:21-jdk-alpine AS development
WORKDIR /app
COPY pom.xml .
COPY src ./src
# No need to copy the jar, we run directly with mvn