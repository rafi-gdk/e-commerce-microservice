#!/bin/sh

echo "Please Enter Build Tool"
read buildTool

if [ "$buildTool" == "" ]
then
  buildTool=maven
fi

echo $buildTool "Build Started"
echo "Deleting all pods..."

kubectl scale --replicas=0 deployment/config-deployment
kubectl delete deployment/config-deployment
kubectl delete service config-deployment

kubectl scale --replicas=0 deployment/gateway-deployment
kubectl delete deployment/gateway-deployment
kubectl delete service gateway-deployment

kubectl scale --replicas=0 deployment/security-deployment
kubectl delete deployment/security-deployment
kubectl delete service security-deployment

kubectl scale --replicas=0 deployment/order-deployment
kubectl delete deployment/order-deployment
kubectl delete service order-deployment

kubectl scale --replicas=0 deployment/customer-deployment
kubectl delete deployment/customer-deployment
kubectl delete service customer-deployment

kubectl scale --replicas=0 deployment/product-deployment
kubectl delete deployment/product-deployment
kubectl delete service product-deployment

kubectl scale --replicas=0 deployment/kafka-deployment
kubectl delete deployment/kafka-deployment
kubectl delete service kafka-deployment

if [ "$buildTool" == "maven" ]
then

  PROJECT_NAME=config-server
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=gateway-server
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=security-service
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=order-service
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=customer-service
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=product-service
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=kafka-service
  JAR_FILE=target/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  gradle clean
  mvn clean install
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

else

  PROJECT_NAME=config-server
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=gateway-server
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=security-service
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=order-service
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=customer-service
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=product-service
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

  PROJECT_NAME=kafka-service
  JAR_FILE=build/libs/e-commerce-${PROJECT_NAME}.jar
  cd e-commerce-${PROJECT_NAME}
  mvn clean
  gradle clean build
  echo "Printing $PROJECT_NAME $JAR_FILE"
  docker build -f ./docker/Dockerfile -t ${PROJECT_NAME}:latest . --build-arg JAR=$JAR_FILE
  kubectl apply -f ./kubernetes/deployment.yaml
  cd ..

fi