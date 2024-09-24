FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-customer-service-*.jar
COPY ${JAR_FILE} spring-boot-customer-service.jar
ENTRYPOINT ["java","-jar","/spring-boot-customer-service.jar"]