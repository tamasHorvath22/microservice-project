package com.codecool.microservices.dao;

import com.codecool.microservices.model.Order;
import com.codecool.microservices.model.User;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CommunicationDao {

    private JsonUtil jsonUtil = new JsonUtil();
    //    @Autowired
    private UrlParser urlParser = new UrlParser(jsonUtil);

//    @Autowired

    public void sendRegistrationMail(User user, String urlParameter) {
        try{
            JSONObject userJson = new JSONObject();
            userJson.put("firstName", user.getFirstName());
            userJson.put("lastName", user.getLastName());
            userJson.put("email", user.getEmail());
            userJson.put("address", user.getAddress());
            userJson.put("phoneNum", user.getPhoneNumber());

            String parameters = userJson.toString();

            jsonUtil.sendPostRequestForPresents(urlParser.getCommunicationRoute() + urlParameter, parameters);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void sendPurchaseMail(User user, Order order) {
        try{
//            Map<String, Object> objectMap= new LinkedHashMap<>();

            JSONObject userJson = new JSONObject();
            userJson.put("firstName", user.getFirstName());
            userJson.put("lastName", user.getLastName());
            userJson.put("email", user.getEmail());
            userJson.put("address", user.getAddress());
            userJson.put("phoneNum", user.getPhoneNumber());

            JSONObject orderJson = new JSONObject();
            orderJson.put("id", order.getId());
            orderJson.put("userId", order.getUserId());
            orderJson.put("presentList", order.getOrder());

            JSONObject parametersObject = new JSONObject();

            parametersObject.put("user", userJson);
            parametersObject.put("order", orderJson);

//            JSONObject object = new JSONObject();
//            object.put()

//            String parameters = userJson.toString();

            jsonUtil.sendPostRequestForPresents(urlParser.getCommunicationRoute() + "purchase", parametersObject.toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
