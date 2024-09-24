FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-order-service*.jar
COPY ${JAR_FILE} spring-boot-order-service.jar
ENTRYPOINT ["java","-jar","/spring-boot-order-service.jar"]