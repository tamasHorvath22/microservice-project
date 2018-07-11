package com.codecool.microservices.service;

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

    public void add(long userId, long presentId) {
        String urlParameters = "?userId=" + userId + "&presentId=" + presentId;
        jsonUtil.sendPostRequest(urlParser.getCartRoute(), urlParameters);
    }
}
