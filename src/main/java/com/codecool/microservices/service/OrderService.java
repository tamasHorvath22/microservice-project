package com.codecool.microservices.service;

import com.codecool.microservices.dao.OrderDao;
import com.codecool.microservices.model.Cart;
import com.codecool.microservices.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getAllOrders(Long userId){
        return orderDao.getAllOrders(userId);
    }

    public void addOrder(Cart cart){
        orderDao.addOrder(cart);
    }

}
