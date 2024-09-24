kubectl scale --replicas=0 deployment/config-deployment
kubectl delete deployment/config-deployment
kubectl delete service config-deployment