# FROM openjdk:17-jdk
#
# RUN apt-get update && apt-get install -y maven
#
# WORKDIR /app
#
# COPY pom.xml .
# COPY src ./src
#
# RUN mvn clean install -DskipTests
#
# CMD ["java", "-jar", "target/learning-platform-api.jar"]
#
#


FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /app/target/learning-platform-api-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "learning-platform-api-0.0.1-SNAPSHOT.jar"]