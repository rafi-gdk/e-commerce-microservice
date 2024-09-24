kubectl scale --replicas=0 deployment/order-deployment
kubectl delete deployment/order-deployment
kubectl delete service order-deployment