FROM maven:3.8.4-openjdk-17-slim AS dependencies
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

FROM dependencies AS build
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/learning-platform-api-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "learning-platform-api-0.0.1-SNAPSHOT.jar"]
