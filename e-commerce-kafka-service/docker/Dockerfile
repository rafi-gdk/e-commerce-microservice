FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/kafka-service
COPY $JAR /opt/kafka-service/app-build.jar
ENTRYPOINT ["java","-jar","/opt/kafka-service/app-build.jar"]