package com.codecool.microservices.service;

import com.codecool.microservices.dao.CommunicationDao;
import com.codecool.microservices.model.Order;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationService {

    @Autowired
    CommunicationDao communicationDao;

    public void sendRegistrationEmail(User user) {
        communicationDao.sendRegistrationMail(user);
    }

    public void sendPurchaseEmail(User user, Order order) {
        communicationDao.sendPurchaseMail(user, order);
    }

    public void sendSoldEmail(User buyer, List<User> sellers, List<Present> presents) {
        communicationDao.sendSoldEmail(buyer, sellers, presents);
    }
}
