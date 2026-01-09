FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:17-jdk
EXPOSE 3454
COPY --from=build /build/libs/Travel-2-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]