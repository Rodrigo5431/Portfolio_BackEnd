FROM openjdk:17-jdk-alpine
RUN apk add --no-cache maven
WORKDIR /api
COPY . /api
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "/api/target/api.jar"]
