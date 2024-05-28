FROM openjdk:23-ea-21-oracle
WORKDIR /app
COPY target/lamoda-monitor-0.0.1-SNAPSHOT.jar /app/monitor.jar
ENTRYPOINT ["java", "-jar", "monitor.jar"]
LABEL authors="donsdesmages"