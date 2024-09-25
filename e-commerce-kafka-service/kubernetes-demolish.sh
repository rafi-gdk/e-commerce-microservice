kubectl scale --replicas=0 deployment/kafka-deployment
kubectl delete deployment/kafka-deployment
kubectl delete service kafka-deployment