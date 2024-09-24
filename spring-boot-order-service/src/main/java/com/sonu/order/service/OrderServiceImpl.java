package com.sonu.order.service;

import com.sonu.order.beans.entity.Order;
import com.sonu.order.beans.request.OrderRequest;
import com.sonu.order.beans.response.Customer;
import com.sonu.order.beans.response.OrderResponse;
import com.sonu.order.beans.response.Product;
import com.sonu.order.feign.CustomerService;
import com.sonu.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CustomerService customerService;

    @Value("${order.customer.url}")
    private String CUSTOMER_SERVICE_URL;

    @Value("${order.product.url}")
    private String PRODUCT_SERVICE_URL;

    @Autowired
    KafkaTemplate<String, String> template;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        System.out.println("OrderServiceImpl.placeOrder --> " + CUSTOMER_SERVICE_URL + " " + PRODUCT_SERVICE_URL);
        Customer customer = restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/customer-service/customer/getCustomer/" + orderRequest.getCustomerID(), Customer.class);

        List<Product> products = new ArrayList<>();
        for (Integer productId : orderRequest.getProductId()) {
            products.add(restTemplate.getForObject(PRODUCT_SERVICE_URL + "/product-service/product/getProduct/" + productId, Product.class));
        }
        System.out.println("OrderServiceImpl.placeOrder--> " + customer);
        Order order = new Order();
        order.setCustomerID(orderRequest.getCustomerID());
        order.setProductId(orderRequest.getProductId());
        order.setOrderTime(LocalDateTime.now());
        Order orderRes = orderRepository.save(order);
        template.send("my-topic", orderRes.toString());
        return new OrderResponse(orderRes.getOrderId(), orderRes.getOrderTime(), customer, products);
    }

    @Override
    public OrderResponse getOrder(String orderId) {

        List<Product> products = new ArrayList<>();
        Customer customer = null;
        Order orderRes = null;
        try {
            orderRes = orderRepository.getReferenceById(orderId);
            ResponseEntity<Customer> cust = customerService.getCustomer(orderRes.getCustomerID());
            customer = cust.getBody();
            for (Integer productId : orderRes.getProductId()) {
                products.add(restTemplate.getForObject(PRODUCT_SERVICE_URL + "/product-service/product/getProduct/" + productId, Product.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new OrderResponse(orderRes.getOrderId(), orderRes.getOrderTime(), customer, products);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
