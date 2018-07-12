package com.codecool.microservices.dao;

import com.codecool.microservices.model.User;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class UserDao {

    private UrlParser urlParser;
    private JsonUtil jsonUtil;

    public UserDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

    public User login(String email){
        try {
            JSONObject emailJson = new JSONObject();
            emailJson.put("email", email);
            String urlParameters = emailJson.toString();
            String route = urlParser.getUserRoute() + "login";
            String string = jsonUtil.sendPostRequest(route, urlParameters);
            JSONObject response = new JSONObject(string);
            long id = response.getLong("id");
            String firstName = response.getString("first_name");
            String lastName = response.getString("last_name");
            String emailAddress = response.getString("email");
            String password = response.getString("password");
            String address = response.getString("address");
            String phoneNumber = response.getString("phone_number");
            User user = new User(id, firstName, lastName, emailAddress, address, phoneNumber);
            user.setPassword(password);
            return user;
        }
        catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void registration(String email, String password, String firstName, String lastName, String address, String phoneNumber) throws UnsupportedEncodingException{
        JSONObject registrationJSON = new JSONObject();
        registrationJSON.put("email", email);
        registrationJSON.put("password", password);
        registrationJSON.put("firstName", firstName);
        registrationJSON.put("lastName", lastName);
        registrationJSON.put("address", address);
        registrationJSON.put("phoneNum", phoneNumber);
        String route = urlParser.getUserRoute() + "registration";
        jsonUtil.sendPostRequest(route, registrationJSON.toString());
    }

    public User getUserById(long id) {
        try {
            JSONObject response = jsonUtil.readJsonFromUrl(urlParser.getUserRoute() + "user/" + id);
            id = response.getInt("id");
            String firstName = response.getString("first_name");
            String lastName = response.getString("last_name");
            String email = response.getString("email");
            String address = response.getString("address");
            String phoneNumber = response.getString("phone_number");
            return new User(id, firstName, lastName, email, address, phoneNumber);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
