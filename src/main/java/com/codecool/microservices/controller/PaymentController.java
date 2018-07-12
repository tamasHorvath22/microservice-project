package com.codecool.microservices.controller;

import com.codecool.microservices.dao.CommunicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    @Autowired
    CommunicationDao communicationDao;

}
