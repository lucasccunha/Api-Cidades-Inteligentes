
FROM maven:3.9.8-eclipse-temurin-21 AS build


WORKDIR /opt/app


COPY agendamento /opt/app


RUN mvn clean test package


FROM eclipse-temurin:21-jre-alpine


WORKDIR /opt/app


COPY --from=build /opt/app/target/agendamento-0.0.1-SNAPSHOT.jar /opt/app/app.jar


ENV PROFILE=prd

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]

