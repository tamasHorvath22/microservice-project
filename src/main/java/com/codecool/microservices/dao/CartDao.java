package com.codecool.microservices.dao;

import com.codecool.microservices.model.Cart;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartDao {

    @Autowired
    private UrlParser urlParser;
    @Autowired
    private JsonUtil jsonUtil;
    private JSONObject cartJSON;

    private void getCartJson(String parameters) {
        try {
            cartJSON = jsonUtil.readJsonFromUrl(urlParser.getCartRoute() + parameters);
        } catch (IOException e) {
            System.out.println("No JSON found...");
        }
    }

    private Cart makeCartFromJson() {
        long id = cartJSON.getLong("userId");
        List<Long> presentIds = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) cartJSON.get("presentIds");
        if (jsonArray != null) {
            jsonArray.forEach(presentId -> presentIds.add((long) presentId));
        }
        return new Cart(id, presentIds);
    }

    public Cart getCart(long userId) {
        getCartJson("/" + userId);
        return makeCartFromJson();
    }

}
