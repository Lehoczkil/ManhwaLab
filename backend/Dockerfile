#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
#RUN apk --update add openjdk11-jre
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim

COPY --from=build /target/ManhwaLabBackend-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]

