package com.codecool.microservices.service;

import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.dao.WishlistDao;
import com.codecool.microservices.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WishlistService {

    private WishlistDao wishlistDao;

    private PresentService presentService;

    public WishlistService(WishlistDao wishlistDao, PresentService presentService) {
        this.wishlistDao = wishlistDao;
        this.presentService = presentService;
    }

    public List<Present> getPresentsByUserId(long userId) {
        List<Long> presentIds = wishlistDao.getWishlist(userId);
        List<Present> presents = new ArrayList<>();
        for (long presentId: presentIds) {
            try {
                presents.add(presentService.getPresent(presentId));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return presents;
    }

    public void removePresent(long userId, long presentId) {
        wishlistDao.removePresent(userId, presentId);
    }

    public void addPresent(long userId, long presentId) {
        wishlistDao.addPresent(userId, presentId);
    }
}
