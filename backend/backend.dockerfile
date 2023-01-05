FROM alpine
MAINTAINER aron
RUN apk --update add openjdk11-jre
COPY target/ManhwaLabBackend-0.0.1-SNAPSHOT.jar backend.jar
CMD ["java", "-jar", "backend.jar"]

EXPOSE 8080