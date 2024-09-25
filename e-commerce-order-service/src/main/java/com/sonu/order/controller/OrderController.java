package com.sonu.order.controller;

import com.sonu.order.beans.entity.Order;
import com.sonu.order.beans.request.OrderRequest;
import com.sonu.order.beans.response.OrderResponse;
import com.sonu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/placeOrder")
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public OrderResponse getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping(value = "/getAllOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
