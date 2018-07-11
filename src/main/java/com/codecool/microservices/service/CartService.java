package com.codecool.microservices.service;

import com.codecool.microservices.dao.CartDao;
import com.codecool.microservices.model.Cart;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private JsonUtil jsonUtil;
    @Autowired
    private UrlParser urlParser;
    @Autowired
    private CartDao cartDao;

    public void add(long userId, long presentId) {
        String urlParameters = "?userId=" + userId + "&presentId=" + presentId;
        jsonUtil.sendPostRequest(urlParser.getCartRoute(), urlParameters);
    }

    public void remove(long userId, long presentId) {
        String url = urlParser.getCartRoute() + "?userId=" + userId + "&presentId=" + presentId;
        jsonUtil.sendDeleteRequest(url);
    }

    public Cart getById(long userId) {
        return cartDao.getCart(userId);
    }

}
