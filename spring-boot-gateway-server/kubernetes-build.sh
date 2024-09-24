./gradlew clean build
docker build -f ./docker-images/Dockerfile -t gateway-server:latest .
kubectl apply -f ./kubernetes/deployment.yaml