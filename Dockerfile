FROM openjdk:17

MAINTAINER PAULO

COPY target/demo:jar:0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]