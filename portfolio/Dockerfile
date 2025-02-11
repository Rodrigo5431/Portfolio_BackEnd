FROM ubuntu:latest AS build
FROM openjdk:17-jdk-alpine
WORKDIR /portfolio
RUN apt-get install maven -y
RUN mvn clean install
RUN mkdir /api
EXPOSE 8080
COPY target/*.jar /api/api.jar
CMD [ "java", "-jar","/api/api.jar" ]