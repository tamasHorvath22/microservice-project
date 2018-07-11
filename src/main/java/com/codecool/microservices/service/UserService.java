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
}
