package com.codecool.microservices.service;

import com.codecool.microservices.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    @Autowired
    WishlistDao wishlistDao;

    public void getPresentsByUserId(long id) {

    }
}
