package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistControllerRest {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/wishlist")
    public ResponseEntity<List<Present>> getUserWishlist(@SessionAttribute("user") User user) {
        List<Present> presents = wishlistService.getPresentsByUserId(user.getId());
        System.out.println(user.getId());
        return new ResponseEntity<>(presents, HttpStatus.OK);
    }

    @PostMapping("/wishlist/remove")
    public ResponseEntity getUserWishlist(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) {
        wishlistService.removePresent(user.getId(), presentId);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/wishlist/add")
    public ResponseEntity addPresentToWishlist(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) {

        wishlistService.addPresent(user.getId(), presentId);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}