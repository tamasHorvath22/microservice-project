package com.codecool.microservices.controller;

import com.codecool.microservices.model.User;
import com.codecool.microservices.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProfileController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/profile")
    public String profileView(@SessionAttribute User user) {
        if(walletService.getWallet(user.getId()) == null) {
            walletService.createWallet(user.getId());
        }
        return "profile";
    }

    @PostMapping(value = "/profile")
    public String deposit(@SessionAttribute User user, @RequestParam int amount) {
        walletService.deposit(user.getId(), amount);
        return "profile";
    }


}
