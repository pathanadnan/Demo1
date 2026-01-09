# -------- BUILD STAGE --------
FROM gradle:8.3-jdk17 AS build
WORKDIR /app

# Copy everything
COPY . .

# Build the Spring Boot jar
RUN gradle bootJar --no-daemon --stacktrace --info


# -------- RUN STAGE --------
FROM eclipse-temurin:17-jdk
WORKDIR /app

EXPOSE 3454

# Copy jar from build stage
COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
