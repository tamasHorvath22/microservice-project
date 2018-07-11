package com.codecool.microservices.service;

import com.codecool.microservices.dao.UserDao;
import com.codecool.microservices.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao userDao;

    public User login(){
        return userDao.login("valami", "valami");
        //Todo call DAO
    }

    public User registration(String email, String password, String firstName, String lastName, String phoneNumber){
        return userDao.registration(email, password, firstName, lastName, phoneNumber);
    }
}
