package com.codecool.microservices.controller;

import com.codecool.microservices.model.User;
import com.codecool.microservices.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {

    private final static String MAIN_PAGE = "index";

    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) {
        long userId = user.getId();
        cartService.add(userId, presentId);
        return MAIN_PAGE;
    }
}
