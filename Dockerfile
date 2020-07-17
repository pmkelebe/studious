FROM openjdk:8-slim
COPY ./target/iliad-0.0.1-SNAPSHOT.jar /iliad.jar
WORKDIR /
ENTRYPOINT ["java", "-jar","iliad.jar"]