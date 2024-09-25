./gradlew clean build
docker build -f ./docker-images/Dockerfile -t kafka-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml