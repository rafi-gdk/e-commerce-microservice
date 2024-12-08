#./gradlew clean build
mvn clean install
docker build -f ./docker-images/Dockerfile -t product-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml
kubectl apply -f ./kubernetes/service.yaml