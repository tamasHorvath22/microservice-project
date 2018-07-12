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

    @Autowired
    WishlistDao wishlistDao;

    @Autowired
    PresentService presentService;

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
/*        List<Present> presents = new ArrayList<>();
        presents.add(new Present(1, "termék", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presents.add(new Present(2, "termék", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presents.add(new Present(3, "termék", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presents.add(new Present(4, "termék", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));*/
        return presents;
    }

    public void removePresent(long userId, long presentId) {
        wishlistDao.removePresent(userId, presentId);
    }

    public void addPresent(long userId, long presentId) {
        wishlistDao.addPresent(userId, presentId);
    }
}
