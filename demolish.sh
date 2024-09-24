kubectl scale --replicas=0 deployment/config-deployment
kubectl delete deployment/config-deployment
kubectl delete service config-deployment

kubectl scale --replicas=0 deployment/gateway-deployment
kubectl delete deployment/gateway-deployment
kubectl delete service gateway-deployment

kubectl scale --replicas=0 deployment/security-deployment
kubectl delete deployment/security-deployment
kubectl delete service security-deployment

kubectl scale --replicas=0 deployment/order-deployment
kubectl delete deployment/order-deployment
kubectl delete service order-deployment

kubectl scale --replicas=0 deployment/customer-deployment
kubectl delete deployment/customer-deployment
kubectl delete service customer-deployment

kubectl scale --replicas=0 deployment/product-deployment
kubectl delete deployment/product-deployment
kubectl delete service product-deployment

kubectl scale --replicas=0 deployment/kafka-deployment
kubectl delete deployment/kafka-deployment
kubectl delete service kafka-deployment
