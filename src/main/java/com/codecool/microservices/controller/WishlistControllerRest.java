package com.codecool.microservices.controller;

import com.codecool.microservices.dao.WishlistDao;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@SessionAttributes({"user"})
public class WishlistControllerRest {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/wishlist")
    public ResponseEntity<List<Present>> getUserWishlist(@ModelAttribute("user") User user) {
        //List<Present> presents = wishlistService.getPresentsByUserId(user.getId());
        List<Present> presents = wishlistService.getPresentsByUserId(5L);
        return new ResponseEntity<>(presents, HttpStatus.OK);
    }

    @PostMapping("/wishlist/remove")
    public ResponseEntity getUserWishlist(@RequestParam("presentId") long presentId) {
        wishlistService.removePresent(5L, presentId);
        System.out.println("trying to remove present: " + presentId);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}