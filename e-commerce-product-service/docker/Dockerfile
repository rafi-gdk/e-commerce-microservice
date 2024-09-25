FROM openjdk:19-alpine
ARG JAR
RUN mkdir /opt/product-service
COPY $JAR /opt/product-service/app-build.jar
ENTRYPOINT ["java","-jar","/opt/product-service/app-build.jar"]