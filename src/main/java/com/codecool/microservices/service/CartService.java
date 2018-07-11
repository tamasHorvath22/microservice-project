package com.codecool.microservices.service;

import com.codecool.microservices.dao.CartDao;
import com.codecool.microservices.model.Cart;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        cart.getPresentIds().forEach(presentId -> presents.add(presentService.getPresent(presentId)));
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
