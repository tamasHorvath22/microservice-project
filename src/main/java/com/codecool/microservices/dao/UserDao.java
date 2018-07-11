package com.codecool.microservices.dao;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private UrlParser urlParser;
    private JsonUtil jsonUtil;

    public UserDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

    public User login(String email, String password){
        try {
            String urlParameters =
                    "email=" + URLEncoder.encode(email, "UTF-8") +
                            "&password=" + URLEncoder.encode(password, "UTF-8");
            JSONObject response = new JSONObject(jsonUtil.sendPostRequest(urlParser.getUserRoute() + "/login", urlParameters));
            long id = response.getLong("id");
            String firstName = response.getString("firstName");
            String lastName = response.getString("lastName");
            String emailAddress = response.getString("email");
            String address = response.getString("address");
            String phoneNumber = response.getString("phoneNumber");
            return new User(id, firstName, lastName, emailAddress, address, phoneNumber);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public User registration(String email, String password, String firstName, String lastName, String address, String phoneNumber){
        try {
            String urlParameters =
                    "email=" + URLEncoder.encode(email, "UTF-8") +
                    "&password=" + URLEncoder.encode(password, "UTF-8") +
                    "&firstName=" + URLEncoder.encode(firstName, "UTF-8") +
                    "&lastName=" + URLEncoder.encode(lastName, "UTF-8") +
                    "&address=" + URLEncoder.encode(address, "UTF-8") +
                    "&phoneNumber=" + URLEncoder.encode(phoneNumber, "UTF-8");
            JSONObject response = new JSONObject(jsonUtil.sendPostRequest(urlParser.getWishlistRoute() + "/registration",urlParameters));
            long id = response.getLong("id");
            firstName = response.getString("firstName");
            lastName = response.getString("lastName");
            email = response.getString("email");
            address = response.getString("address");
            phoneNumber = response.getString("phoneNumber");
            return new User(id, firstName, lastName, email, address, phoneNumber);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public User getUserById(long id) {
        try {
            JSONObject response = jsonUtil.readJsonFromUrl(urlParser.getUserRoute() + "/" + id);
            id = response.getInt("id");
            String firstName = response.getString("firstName");
            String lastName = response.getString("lastName");
            String email = response.getString("email");
            String address = response.getString("address");
            String phoneNumber = response.getString("phoneNumber");
            return new User(id, firstName, lastName, email, address, phoneNumber);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
//    @Autowired
//    private UrlParser urlParser;
//
//    @Autowired
//    private JsonUtil jsonUtil;
//
//    private JSONObject userJSON;
//
//    private void getJson(String route) {
//        try {
//            userJSON = jsonUtil.readJsonFromUrl(urlParser.getUserRoute() + route);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private User createUserObject() {
//        Integer id = Integer.valueOf(userJSON.get("id").toString());
//        String firstName = userJSON.get("firstName").toString();
//        String lastName = userJSON.get("lastName").toString();
//        String email = userJSON.get("email").toString();
//        String address = userJSON.get("address").toString();
//        String phoneNumber = userJSON.get("phoneNumber").toString();
//        return new User(id, firstName, lastName, email, address, phoneNumber);
//    }
//
//    public User getUser (String route) throws ParseException {
//        getJson(route);
//        return createUserObject();
//    }
//
//    public User login(String username, String password){
//        return new User(1, "A", "B", "C", "D", "E");
////        RestTemplate restTemplate = new RestTemplate();
////        String comicsJson = restTemplate.getForObject(/*TODO*/"URL", String.class);
//////        JSONObject json = new JSONObject(comicsJson);
//    }
//
//    public User registration(String email, String password, String firstName, String lastName, String phoneNumber){
//        return new User(1, "A", "B", "C", "D", "E");
//    }
}
