kubectl scale --replicas=0 deployment/security-deployment
kubectl delete deployment/security-deployment
kubectl delete service security-deployment