FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY target/restapi-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/restapi-0.0.1-SNAPSHOT.jar"]