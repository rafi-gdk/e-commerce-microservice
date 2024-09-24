FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-config-server-*.jar
COPY ${JAR_FILE} spring-boot-config-server.jar
ENTRYPOINT ["java","-jar","/spring-boot-config-server.jar"]