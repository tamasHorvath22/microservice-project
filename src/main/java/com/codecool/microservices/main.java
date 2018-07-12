package com.codecool.microservices;

import com.codecool.microservices.dao.OrderDao;
import com.codecool.microservices.model.Cart;
import com.codecool.microservices.model.Order;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        OrderDao order = new OrderDao(new UrlParser(new JsonUtil()), new JsonUtil());

        System.out.println(order.getAllOrders(1l));
    }
}
