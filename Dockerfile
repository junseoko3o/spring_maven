FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17 as runtime

WORKDIR /app

ARG DB_USERNAME=test
ARG DB_PASSWORD=test
ARG DB_DRIVER=com.mysql.cj.jdbc.Driver

ENV SPRING_DATASOURCE_URL=${DB_URL}
ENV SPRING_DATASOURCE_USERNAME=${DB_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${DB_PASSWORD}
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=${DB_DRIVER}

COPY --from=build /app/target/*.jar ./main.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=app", "-jar", "main.jar"]