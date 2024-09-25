FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/gateway-server
COPY $JAR /opt/gateway-server/app-build.jar
ENTRYPOINT ["java","-jar","/opt/gateway-server/app-build.jar"]