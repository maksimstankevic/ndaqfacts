FROM openjdk:11-jdk
VOLUME /tmp
ADD target/ndaqfacts-0.0.1-SNAPSHOT.jar ndaqfacts.jar
ADD src/main/resources/application.properties application.properties
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom --spring.config.location=classpath:file:application-properties ","-jar","/ndaqfacts.jar"]