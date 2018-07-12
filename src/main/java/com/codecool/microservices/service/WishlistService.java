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
        presents.add(new Present(1, "vmi", 15D, "https://lifeasahuman.com/files/2015/06/Jan-crab.jpg", "ebfvesrdvaesd"));
        presents.add(new Present(2, "vmi2", 15D, "https://lifeasahuman.com/files/2015/06/Jan-crab.jpg", "ebfvesrdvaesd"));
        presents.add(new Present(4, "vmi3", 15D, "https://lifeasahuman.com/files/2015/06/Jan-crab.jpg", "ebfvesrdvaesd"));
        presents.add(new Present(3, "vmi4", 15D, "https://lifeasahuman.com/files/2015/06/Jan-crab.jpg", "ebfvesrdvaesd"));
        return presents;
    }

    public void removePresent(long userId, long presentId) {
        wishlistDao.removePresent(userId, presentId);
    }

    public void addPresent(long userId, long presentId) {
        wishlistDao.addPresent(userId, presentId);
    }
}
