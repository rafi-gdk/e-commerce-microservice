./gradlew clean build
docker build -f ./docker-images/Dockerfile -t order-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml