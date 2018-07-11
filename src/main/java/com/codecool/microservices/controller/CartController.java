package com.codecool.microservices.controller;

import com.codecool.microservices.model.User;
import com.codecool.microservices.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    private final static String MAIN_PAGE = "index";
    private final static String CART_PAGE = "cart";

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String showCart(@SessionAttribute("user") User user, Model model) {
        long userId = user.getId();
        model.addAttribute("presents", cartService.getPresentsInCart(cartService.getCart(userId)));
        return CART_PAGE;
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) {
        long userId = user.getId();
        cartService.addToCart(userId, presentId);
        return MAIN_PAGE;
    }

    @DeleteMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) {
        long userId = user.getId();
        cartService.removeFromCart(userId, presentId);
        return CART_PAGE;
    }

}
