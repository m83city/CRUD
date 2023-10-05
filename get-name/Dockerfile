#FROM maven:3.9.4-amazoncorretto-17 as builder
#COPY src ./src
#COPY pom.xml ./
#RUN mvn -f ./pom.xml package
#
#EXPOSE 8085
#ARG JAR_FILE=target/getFieldName-0.0.1-SNAPSHOT.jar
#ADD ${JAR_FILE} getFieldName.jar
#ENTRYPOINT ["java","-jar","/getFieldName.jar"]
FROM eclipse-temurin:17-jdk-focal
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]