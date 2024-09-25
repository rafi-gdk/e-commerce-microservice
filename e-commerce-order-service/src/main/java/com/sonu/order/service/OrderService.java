package com.sonu.order.service;

import com.sonu.order.beans.entity.Order;
import com.sonu.order.beans.request.OrderRequest;
import com.sonu.order.beans.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

    OrderResponse getOrder(String orderId);

    List<Order> getAllOrders();
}
