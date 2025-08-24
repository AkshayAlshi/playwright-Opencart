FROM ghcr.io/microsoft/playwright/java:jammy

WORKDIR /app

# Copy Maven config
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy source
COPY src ./src

# Run tests by default
CMD ["mvn", "test"]
