FROM maven:3.5-jdk-8 AS build_chain
EXPOSE 8080
WORKDIR /usr/src/app
COPY target/spark-core-1.0-SNAPSHOT-jar-with-dependencies.jar .
#COPY pom.xml .
#RUN mvn dependency:go-offline -B
#RUN mvn -f pom.xml clean package
ENTRYPOINT ["java","-jar","spark-core-1.0-SNAPSHOT-jar-with-dependencies.jar"]
##
#FROM openjdk:8u171-jre-alpine
#WORKDIR /release
#COPY --from=build_chain /usr/src/app/target/spark-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar .
#ENTRYPOINT ["java","-jar","spark-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar"]
##

