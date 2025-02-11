FROM openjdk:17-jdk-alpine
RUN apk add --no-cache maven
WORKDIR /api
COPY pom.xml .
COPY src ./src
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "/api/target/api.jar"]
