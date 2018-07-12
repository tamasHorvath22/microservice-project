package com.codecool.microservices.dao;

import com.codecool.microservices.model.Cart;
import com.codecool.microservices.model.Order;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderDao {


    private JSONObject orderJson;
    private List<Order> orders;

    private UrlParser urlParser;
    private JsonUtil jsonUtil;


    public OrderDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

    public List<Order> getAllOrders(Long userId) {
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonUtil.readJsonFromUrl(urlParser.getOrderRoute() + "/" + "user/" + Long.toString(userId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Order> orders = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("orders");
        ObjectMapper mapper = new ObjectMapper();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        mapper.setDateFormat(df);
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    Order order = mapper.readValue(jsonArray.get(i).toString(), Order.class);
                    orders.add(order);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return orders;
    }

    public void addOrder(Cart cart){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(cart);
            jsonUtil.sendPostRequest(urlParser.getOrderRoute(), json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}