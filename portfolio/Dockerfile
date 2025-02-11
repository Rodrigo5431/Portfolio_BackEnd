FROM openjdk:17-jdk-alpine
RUN mvn clean install
RUN mkdir /api
EXPOSE 8080
COPY target/*.jar /api/api.jar
CMD [ "java", "-jar","/api/api.jar" ]