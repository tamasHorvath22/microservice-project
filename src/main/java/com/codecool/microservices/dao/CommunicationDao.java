package com.codecool.microservices.dao;

import com.codecool.microservices.model.Order;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommunicationDao {

    @Autowired
    private UrlParser urlParser;

    public void sendRegistrationMail(User user) {
        try{
            String apiRoute = "registration";
            JSONObject userJson = createUserJsonObject(user);

            urlParser.getJsonUtil().sendPostRequestForPresents(urlParser.getCommunicationRoute() + apiRoute, userJson.toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void sendPurchaseMail(User user, Order order) {
        try{
            String apiRoute = "purchase";
            JSONObject userJson = createUserJsonObject(user);
            JSONObject orderJson = createOrderObject(order);
            JSONObject parametersObject = new JSONObject();

            parametersObject.put("user", userJson);
            parametersObject.put("order", orderJson);

            urlParser.getJsonUtil().sendPostRequestForPresents(urlParser.getCommunicationRoute() + apiRoute, parametersObject.toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void sendSoldEmail(User buyer, List<User> sellers, List<Present> presents) {
        try {
            String apiRoute = "sold";
            JSONObject buyerJsonObject = createUserJsonObject(buyer);
            List<JSONObject> sellersList = new ArrayList<>();
            for (User seller : sellers) {
                sellersList.add(createUserJsonObject(seller));
            }
            List<JSONObject> presentJsonList = new ArrayList<>();
            for (Present present : presents) {
                presentJsonList.add(createPresentObject(present));
            }

            JSONObject parametersObject = new JSONObject();
            parametersObject.put("buyer", buyerJsonObject);
            parametersObject.put("sellers", sellersList);
            parametersObject.put("presents", presentJsonList);

            urlParser.getJsonUtil().sendPostRequestForPresents(urlParser.getCommunicationRoute() + apiRoute, parametersObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private JSONObject createOrderObject(Order order) {
        JSONObject orderJson = new JSONObject();
        orderJson.put("id", order.getId());
        orderJson.put("userId", order.getUserId());
        orderJson.put("presentList", order.getOrder());
        return orderJson;
    }

    private JSONObject createUserJsonObject(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put("id", user.getId());
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("email", user.getEmail());
        userJson.put("address", user.getAddress());
        userJson.put("phoneNum", user.getPhoneNumber());
        return userJson;
    }

    private JSONObject createPresentObject(Present present) {
        JSONObject presentJson = new JSONObject();
        presentJson.put("id", present.getId());
        presentJson.put("name", present.getName());
        presentJson.put("description", present.getDescription());
        presentJson.put("price", present.getPrice());
        presentJson.put("ownerId", present.getOwnerId());
        return presentJson;
    }

}
