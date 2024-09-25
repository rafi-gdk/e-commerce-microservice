FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/order-service
COPY $JAR /opt/order-service/app-build.jar
ENTRYPOINT ["java","-jar","/opt/order-service/app-build.jar"]