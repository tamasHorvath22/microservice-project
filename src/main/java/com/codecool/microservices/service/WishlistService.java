package com.codecool.microservices.service;

import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.dao.WishlistDao;
import com.codecool.microservices.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistDao wishlistDao;

    @Autowired
    PresentDao presentDao;

    public List<Present> getPresentsByUserId(long userId) {
        //List<Long> presentIds = wishlistDao.getWishlist(userId);
        List<Present> presents = new ArrayList<>();
        presents.add(new Present(1, "valami", 25D, "https://lifeasahuman.com/files/2015/06/Jan-crab.jpg"));
        return presents;
    }

    public void removePresent(long userId, long presentId) {
        wishlistDao.removePresent(userId, presentId);
    }

    public void addPresent(long userId, long presentId) {
        wishlistDao.addPresent(userId, presentId);
    }
}
