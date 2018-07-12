package com.codecool.microservices.controller;

import com.codecool.microservices.model.Order;
import com.codecool.microservices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/order")
    public List<Order> getAllOrder() {
        long userId = 1L;
        List<Order> allOrders = orderService.getAllOrders(userId);
        return allOrders;
    }
}
