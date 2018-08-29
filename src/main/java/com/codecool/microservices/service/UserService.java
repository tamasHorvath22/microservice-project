package com.codecool.microservices.service;

import com.codecool.microservices.dao.UserDao;
import com.codecool.microservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User login(String email){
        return userDao.login(email);
    }

    public void registration(String email, String password, String firstName, String lastName, String address, String phoneNumber) throws UnsupportedEncodingException{
        userDao.registration(email, password, firstName, lastName, address, phoneNumber);
    }

    public User getUserById(long id){
        return userDao.getUserById(id);
    }

    public User getAnonymUser(){
        return new User (0L, null, null, null, null, null);
    }

    public User createUser(String firstName, String lastName, String email, String address, String phoneNumber) {
        return new User(firstName, lastName, email, address, phoneNumber);
    }
}
