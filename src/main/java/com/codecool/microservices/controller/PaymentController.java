package com.codecool.microservices.controller;

import com.codecool.microservices.dao.CommunicationDao;
import com.codecool.microservices.model.Order;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    CommunicationDao communicationDao;

    @GetMapping(value = "/test")
    public String cucc() {
        Date date = new Date();
        Order order = new Order(1, 1, date);
        Present present1 = new Present(1L, "name1", "desc", 1.1, "str", true, 2, "im", date);
        Present present2 = new Present(2L, "name2", "desc", 1.1, "str", true, 3, "im", date);

        List<Present> presentList = new ArrayList<>();
        presentList.add(present1);
        presentList.add(present2);
        order.setOrder(presentList);
        User buyer = new User(1L, "Buyer", "München", "horvathtamas22@gmail.com", "ff", "Rr");
        User seller1 = new User(2L, "First", "Second", "kondacspeter@gmail.com", "ff", "Rr");
        User seller2 = new User(3L, "First", "Second", "horvathtamas22@gmail.com", "ff", "Rr");

        List<User> sellerList = new ArrayList<>();
        sellerList.add(seller1);
        sellerList.add(seller2);


//        CommunicationDao communicationDao = new CommunicationDao();
//        communicationDao.sendPurchaseMail(user, order);
        communicationDao.sendSoldEmail(buyer, sellerList, presentList);
        return "about";
    }
}
