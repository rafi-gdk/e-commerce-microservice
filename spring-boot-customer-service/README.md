This application provides all Customer Information

Pre Requisites : Java 19 and Gradle 7.6 and Postgres

Install Postgres:
> docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123456789 -p 5432:5432 -d postgres

Used topics:

1.Http all Requests

2.Form Validations

3.PathVariable Validations

4.Postgres db by setting up all required info in application.yml variables

5.Used Global Exception handler

6.docker images

7.kubernetes deployments

------------------------------------------------------------------------------------------------------------------------------------------
Steps to Execute:
1. open powershell terminal and execute below commands

   > cd D:\MyWork\my-git-hub\spring-boot-docker

   > ./gradlew clean build

   > docker build -f ./docker-images/Dockerfile -t customer-service:latest .

2. deployment using Kubernetes

   > kubectl apply -f ./kubernetes/deployment.yaml

3. destroy using kubernetes

   > kubectl scale --replicas=0 deployment/customer-deployment

   > kubectl delete deployment/customer-deployment

   > kubectl delete service customer-deployment

------------------------------------------------------------------------------------------------------------------------------------------
some of docker commands:
> docker -–version

> docker images

> docker run [image id]

> docker ps

> docker stop [container id]

> docker kill [container id]

> docker rm [container id]

> docker login

> docker push

> docker build -f [folder path where we have docker file] -t [name for repository:tag]

------------------------------------------------------------------------------------------------------------------------------------------
some of kubernetes commands:
> kubectl cluster-info: it tells us all the cluster info

> kubectl get node: it give the info of Kubenetes

> kubectl create deployment spring-boot-cloud-gateway --image=gateway:latest --port=1000

> kubectl get deployment

> kubectl describe deployment spring-boot-cloud-gateway

> kubectl get pods

> kubectl logs spring-boot-eureka-discovery-6dbc566576-czfwd

> kubectl expose deployment spring-boot-eureka-discovery --type=NodePort

> kubectl get pods -o wide

> kubectl get deployment -o wide

> kubectl get service -o wide

> kubectl apply -f deployment.yaml

> kubectl scale --replicas=3 deployment/customer-deployment

> kubectl scale --replicas=0 deployment/customer-deployment

> kubectl delete deployment/customer-deployment

> kubectl delete service customer-deployment

> kubectl autoscale deployment customer-deployment --cpu-percent=50 --min=1 --max=4
------------------------------------------------------------------------------------------------------------------------------------------