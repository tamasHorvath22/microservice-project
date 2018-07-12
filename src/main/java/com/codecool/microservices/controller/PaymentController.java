package com.codecool.microservices.controller;

import com.codecool.microservices.dao.CommunicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codecool.microservices.dao.CommunicationDao;
import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.CartService;
import com.codecool.microservices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    CommunicationDao communicationDao;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    PresentDao presentDao;

    @GetMapping(value = "/payment")
    public String displayCart(@SessionAttribute User user, Model model) {
        if(user.getId() != 0L) {

            List<Present> presentList = new ArrayList<>();
            for (Long presentId : cartService.getCart(user.getId()).getPresentIds()) {
                presentList.add(presentDao.getPresentById(presentId));
            }

            Double sumPrice = 0.0;
            for (Present present : presentList) {
                sumPrice += present.getPrice();
            }
            model.addAttribute("presentList", presentList);
            model.addAttribute("sumPrice", sumPrice);
            return "payment";
        } else {
            return "redirect:/login";
        }
    }
}
