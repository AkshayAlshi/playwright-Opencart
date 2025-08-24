# Use an official Maven image with JDK
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Run tests (this will download dependencies and execute your Java Playwright tests)
CMD ["mvn", "test"]
