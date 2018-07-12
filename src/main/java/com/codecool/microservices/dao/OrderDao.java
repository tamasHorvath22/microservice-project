package com.codecool.microservices.dao;

import com.codecool.microservices.model.Order;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
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
    private Order order;

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

    public List<Order> getAllOrders(Long userId) {
        JSONObject jsonObject;
        try {
            jsonObject = jsonUtil.readJsonFromUrl(urlParser.getOrderRoute() + "/" + "user/" + Long.toString(userId));
        }catch (IOException e){
            e.printStackTrace();
        }
        List<Order> orders = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();

        return orders;
    }


    public List<Long> getWishlist(long userId){         JSONObject jsonObject = null;         try {             jsonObject = jsonUtil.readJsonFromUrl(urlParser.getWishlistRoute() + "/" + Long.toString(userId));         } catch (IOException e) {             e.printStackTrace();         }         List<Long> list = new ArrayList<>();         JSONArray jsonArray = (JSONArray)jsonObject.get("presentIds");         if (jsonArray != null) {             int len = jsonArray.length();             for (int i=0;i<len;i++){                 list.add(Long.valueOf((Integer)jsonArray.get(i)));             }         }         return list;     }

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
