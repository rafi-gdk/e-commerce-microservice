FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/customer-service
COPY $JAR /opt/customer-service/app-build.jar
ENTRYPOINT ["java","-jar","/opt/customer-service/app-build.jar"]