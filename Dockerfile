FROM maven:3.5-jdk-8 AS build
EXPOSE 8080
WORKDIR /usr/src/app
COPY src src
COPY pom.xml .
RUN mvn dependency:go-offline -B
RUN mvn -f pom.xml clean package
ENTRYPOINT ["java","-jar","target/spark-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar"]
