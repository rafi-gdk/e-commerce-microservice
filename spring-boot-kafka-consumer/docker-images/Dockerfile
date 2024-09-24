FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-kafka-consumer*.jar
COPY ${JAR_FILE} spring-boot-kafka-consumer.jar
ENTRYPOINT ["java","-jar","/spring-boot-kafka-consumer.jar"]