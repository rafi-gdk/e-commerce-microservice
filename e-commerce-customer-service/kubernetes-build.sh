./gradlew clean build
docker build -f ./docker-images/Dockerfile -t customer-service:latest .
kubectl apply -f ./kubernetes/deployment.yaml