package com.codecool.microservices.controller;

import com.codecool.microservices.dao.CommunicationDao;
import com.codecool.microservices.service.WalletService;
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
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    WalletService walletService;

    @GetMapping(value = "/payment")
    public String displayCart(@SessionAttribute User user, Model model) {
        List<Present> presentList = getPresentList(user);
        if(presentList.size() == 0) {
            return "index";
        }
        Double sumPrice = 0.0;
        for (Present present : presentList) {
            sumPrice += present.getPrice();
        }
        model.addAttribute("presentList", presentList);
        model.addAttribute("sumPrice", sumPrice);
        return "payment";
    }

    @PostMapping(value = "/payment")
    public String makePayment(@SessionAttribute User user) {
        int sumPrice = countSumPrice(getPresentList(user));
        walletService.withdraw(user.getId(), sumPrice);
        return "index";
    }

    private List<Present> getPresentList(User user) {
        List<Present> presentList = new ArrayList<>();
        for (Long presentId : cartService.getCart(user.getId()).getPresentIds()) {
            presentList.add(presentDao.getPresentById(presentId));
        }
        return presentList;
    }

    private int countSumPrice(List<Present> presentList) {
        int sumPrice = 0;
        for (Present present : presentList) {
            sumPrice += present.getPrice();
        }
        return sumPrice;
    }
}
