./gradlew clean build
docker build -f ./docker-images/Dockerfile -t kafka-consumer:latest .
kubectl apply -f ./kubernetes/deployment.yaml