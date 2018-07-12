package com.codecool.microservices.controller;

import com.codecool.microservices.model.User;
import com.codecool.microservices.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class CartControllerRest {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) {
        long userId = user.getId();
        //long userId = 1L;
        cartService.addToCart(userId, presentId);
        System.out.println("trying to add to cart");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
