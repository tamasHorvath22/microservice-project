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
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @Autowired
    WishlistDao wishlistDao;

    @GetMapping("/wishlist")
    public ResponseEntity<List<Present>> getUserWishlist(@ModelAttribute("user") User user) {
        //List<Present> presents = wishlistService.getPresentsByUserId(user.getId());
        List<Present> presents = wishlistService.getPresentsByUserId(1L);
        System.out.println(wishlistDao.getWishlist(5));
        return new ResponseEntity<>(presents, HttpStatus.OK);
    }



}
