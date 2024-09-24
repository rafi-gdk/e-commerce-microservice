cd spring-boot-config-server
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t config-server:latest .
kubectl apply -f ./kubernetes/deployment.yaml
cd ..

cd spring-boot-gateway-server
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t gateway-server:latest .
kubectl apply -f ./kubernetes/deployment.yaml
cd ..

cd spring-boot-security-jwt
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t security-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml
cd ..

cd spring-boot-order-service
cd kafka-install
docker-compose -f docker-compose.yml up -d
cd ..
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t order-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml
cd ..

cd spring-boot-customer-service
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t customer-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml
cd ..

cd spring-boot-product-service
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t product-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml
cd ..

cd spring-boot-kafka-consumer
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t kafka-consumer:latest .
kubectl apply -f ./kubernetes/deployment.yaml