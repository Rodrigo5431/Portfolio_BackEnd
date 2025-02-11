FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-getinstall openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/portfolio-3.3.4.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]