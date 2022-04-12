FROM openjdk:8-alpine
ADD target/microservicio2-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]