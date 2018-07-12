package com.codecool.microservices.service;

import com.codecool.microservices.dao.CartDao;
import com.codecool.microservices.model.Cart;
import com.codecool.microservices.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private PresentService presentService;

    public List<Present> getPresentsInCart(Cart cart) {
        List<Present> presents = new ArrayList<>();
        cart.getPresentIds().forEach(presentId -> {
            try {
                presents.add(presentService.getPresent(presentId));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return presents;
    }

    public void addToCart(long userId, long presentId) {
        cartDao.addToCart(userId, presentId);
    }

    public void removeFromCart(long userId, long presentId) {
        cartDao.removeFromCart(userId, presentId);
    }

    public Cart getCart(long userId) {
        return cartDao.getCart(userId);
    }
}
