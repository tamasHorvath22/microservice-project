package com.codecool.microservices.dao;

import com.codecool.microservices.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

    public User login(String username, String password){
        return new User(1l, "A", "B", "C", "D", "E");
//        RestTemplate restTemplate = new RestTemplate();
//        String comicsJson = restTemplate.getForObject(/*TODO*/"URL", String.class);
////        JSONObject json = new JSONObject(comicsJson);
    }
}
