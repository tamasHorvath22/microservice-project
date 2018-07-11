package com.codecool.microservices.service;

import com.codecool.microservices.dao.UserDao;
import com.codecool.microservices.model.User;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;

@Service
public class UserService {

    UserDao userDao;

    public User login(String email, String password){
        return userDao.login(email, password);
    }

    public User registration(String email, String password, String firstName, String lastName, String address, String phoneNumber){
        return userDao.registration(email, password, firstName, lastName, address, phoneNumber);
    }

    public User getUserById(long id){
        return userDao.getUserById(id);
    }
}
