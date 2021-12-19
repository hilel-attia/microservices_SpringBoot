FROM openjdk:11
EXPOSE 8090
ADD target/event-service-0.0.1-SNAPSHOT.jar event-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "event-service-0.0.1-SNAPSHOT.jar"]