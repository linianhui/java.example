# https://hub.docker.com/_/maven/
FROM maven:3.8-jdk-11 AS builder

WORKDIR /build

COPY . .

RUN mvn package --projects mysql


FROM lnhcode/openjdk:11.0.10

WORKDIR /app

COPY --from=builder /build/mysql/target/mysql-1.0-jar-with-dependencies.jar app.jar

ENV JAVA_OPTIONS='-XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.00'

ENTRYPOINT ["/bin/bash", "-c", "java $JAVA_OPTIONS -jar app.jar"]
