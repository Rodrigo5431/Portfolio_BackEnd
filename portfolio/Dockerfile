FROM openjdk:17-jdk-alpine
RUN apk add --no-cache maven
WORKDIR /api
COPY . /api
RUN mvn clean install
EXPOSE 8080
COPY target/portfolio-3.3.4.jar /api/portfolio-3.3.4.jar
CMD ["java", "-jar", "/api/portfolio-3.3.4.jar"]
