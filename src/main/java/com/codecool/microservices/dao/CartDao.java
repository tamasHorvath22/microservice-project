package com.codecool.microservices.dao;

import com.codecool.microservices.model.Cart;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        List<Long> presents = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) cartJSON.get("presentIds");
        if (jsonArray != null) {
            jsonArray.forEach(presentId -> presents.add((long) presentId));
        }
        String dateString = cartJSON.getString("timestamp");
        DateFormat df = new SimpleDateFormat("YYYY-mm-dd");
        Date timestamp = null;
        try {
            timestamp = df.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Wrong timestamp format...");
        }
        return new Cart(id, presents, timestamp);
    }

    public Cart getCart(String parameters) {
        getCartJson(parameters);
        return makeCartFromJson();
    }
}
