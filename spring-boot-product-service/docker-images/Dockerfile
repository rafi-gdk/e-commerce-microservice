FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/spring-boot-product-service-*.jar
COPY ${JAR_FILE} spring-boot-product-service.jar
ENTRYPOINT ["java","-jar","/spring-boot-product-service.jar"]