FROM openjdk:11-jdk
VOLUME /tmp
ADD target/ndaqfacts-0.0.1-SNAPSHOT.jar ndaqfacts.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ndaqfacts.jar"]