package com.codecool.microservices.dao;

import com.codecool.microservices.model.Order;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDao {


    private static RestTemplate restTemplate = new RestTemplate();

    public List<Order> getAllOrders() {
        final String uri = "http://localhost:8080/present";
        List<Order> orders = new ArrayList<>();
        try {
            orders = Arrays.asList(restTemplate.getForObject(uri, Order[].class));
        } catch (ResourceAccessException e) {
            System.out.println("Order microservice unavailable");
        }
        System.out.println(orders.toString());
        return orders;
    }

}
