package com.codecool.microservices.dao;

import com.codecool.microservices.model.Order;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {


    private JSONObject orderJson;
    private List<Order> orders;

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

    public List<Order> getAllOrders(Long userId) {
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonUtil.readJsonFromUrl(urlParser.getOrderRoute() + "/" + "user/" + Long.toString(userId));
        }catch (IOException e){
            e.printStackTrace();
        }
        List<Order> orders = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("orders");
        ObjectMapper mapper = new ObjectMapper();
        if (jsonArray != null){
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

//
//    private void getJson() {
//        try {
//            orderJson = jsonUtil.readJsonFromUrl(urlParser.getOrderRoute());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void createOrderObject() {
//        order = new Order(Long.valueOf("id"), Long.valueOf(orderJson.get("userId").toString()), new Date(Long.valueOf(orderJson.get("timestamp").toString())));
}
//
//}
