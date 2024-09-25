kubectl scale --replicas=0 deployment/product-deployment
kubectl delete deployment/product-deployment
kubectl delete service product-deployment