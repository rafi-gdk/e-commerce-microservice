FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-security-jwt-*.jar
COPY ${JAR_FILE} spring-boot-security-jwt.jar
ENTRYPOINT ["java","-jar","/spring-boot-security-jwt.jar"]