FROM openjdk:11            
VOLUME /tmp
EXPOSE 8880
ADD target/configuration-server-0.0.1-SNAPSHOT.jar configuration-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "configuration-server-0.0.1-SNAPSHOT.jar"]
                   
