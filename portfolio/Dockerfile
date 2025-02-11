FROM openjdk:17-jdk-alpine
RUN apk add --no-cache maven
WORKDIR /api
COPY . /api
RUN mvn clean install
EXPOSE 8080
COPY target/*.jar /api/api.jar
CMD ["java", "-jar", "/api/api.jar"]
