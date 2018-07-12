package com.codecool.microservices.service;

import com.codecool.microservices.dao.OrderDao;
import com.codecool.microservices.model.Cart;
import com.codecool.microservices.model.Order;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class OrderService {

    private OrderDao orderDao;
    private PresentService presentService;

    public OrderService(OrderDao orderDao, PresentService presentService) {
        this.orderDao = orderDao;
        this.presentService = presentService;
    }

    public List<Order> getAllOrders(Long userId){
        List<Order> orders = orderDao.getAllOrders(userId);
        for (Order order : orders) {
            for (long presentId: order.getPresentIds()) {
                try {
                    order.addToOrder(presentService.getPresent(presentId));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return orders;
    }

    public void addOrder(Cart cart){
        orderDao.addOrder(cart);
    }

}

