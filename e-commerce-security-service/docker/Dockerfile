FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/security-service
COPY $JAR /opt/security-service/app-build.jar
ENTRYPOINT ["java","-jar","/opt/security-service/app-build.jar"]