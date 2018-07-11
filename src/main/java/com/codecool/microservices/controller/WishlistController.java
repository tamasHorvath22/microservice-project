package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @PostMapping("/whishlist")
    public ResponseEntity<Present> getUserWishlist() {
        return null;
    }






}
