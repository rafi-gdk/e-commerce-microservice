FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/config-server
COPY $JAR /opt/config-server/app-build.jar
ENTRYPOINT ["java","-jar","/opt/config-server/app-build.jar"]