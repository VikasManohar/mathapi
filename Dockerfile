FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/mathapi*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]