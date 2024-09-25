./gradlew clean build
docker build -f ./docker-images/Dockerfile -t config-server:latest .
kubectl apply -f ./kubernetes/deployment.yaml