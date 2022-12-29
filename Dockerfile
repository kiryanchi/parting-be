FROM openjdk:17-jdk-slim

ARG MODE
COPY ./build/libs/app.jar app.jar

ENTRYPOINT java -jar -Dspring.profiles.active=${MODE} /app.jar