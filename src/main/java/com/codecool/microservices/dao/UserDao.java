package com.codecool.microservices.dao;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;

@Component
public class UserDao {

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

    private JSONObject userJSON;

    private void getJson(String route) {
        try {
            userJSON = jsonUtil.readJsonFromUrl(urlParser.getUserRoute() + route);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User createUserObject() {
        Integer id = Integer.valueOf(userJSON.get("id").toString());
        String firstName = userJSON.get("firstName").toString();
        String lastName = userJSON.get("lastName").toString();
        String email = userJSON.get("email").toString();
        String address = userJSON.get("address").toString();
        String phoneNumber = userJSON.get("phoneNumber").toString();
        return new User(id, firstName, lastName, email, address, phoneNumber);
    }

    public User getUser (String route) throws ParseException {
        getJson(route);
        return createUserObject();
    }

    public User login(String username, String password){
        return new User(1, "A", "B", "C", "D", "E");
//        RestTemplate restTemplate = new RestTemplate();
//        String comicsJson = restTemplate.getForObject(/*TODO*/"URL", String.class);
////        JSONObject json = new JSONObject(comicsJson);
    }

    public User registration(String email, String password, String firstName, String lastName, String phoneNumber){
        return new User(1, "A", "B", "C", "D", "E");
    }
}
