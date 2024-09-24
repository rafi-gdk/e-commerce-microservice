FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-gateway-server*.jar
COPY ${JAR_FILE} spring-boot-gateway-server.jar
ENTRYPOINT ["java","-jar","/spring-boot-gateway-server.jar"]