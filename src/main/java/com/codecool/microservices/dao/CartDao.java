package com.codecool.microservices.dao;

import com.codecool.microservices.model.Cart;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartDao {

    private UrlParser urlParser;
    private JsonUtil jsonUtil;
    private JSONObject cartJSON;

    public CartDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

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
            jsonArray.forEach(presentId -> presentIds.add(Long.parseLong(String.valueOf(presentId))));
        }
        return new Cart(id, presentIds);
    }

    public Cart getCart(long userId) {
        getCartJson("/user/" + userId);
        return makeCartFromJson();
    }

    public void addToCart(long userId, long presentId) {
        String urlParameters = "userId=" + userId + "&presentId=" + presentId;
        jsonUtil.sendPostRequest(urlParser.getCartRoute(), urlParameters);
    }

    public void removeFromCart(long userId, long presentId) {
        String url = urlParser.getCartRoute() + "?userId=" + userId + "&presentId=" + presentId;
        jsonUtil.sendDeleteRequest(url);
    }



}
