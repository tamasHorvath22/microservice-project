package com.codecool.microservices.dao;

import com.codecool.microservices.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

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
