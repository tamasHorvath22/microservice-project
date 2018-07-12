package com.codecool.microservices.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wishlist {
    private long userId;
    private Date timestamp;

    private List<Long> wishList = new ArrayList<>();

    public long getUserId() {
        return userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<Long> getWishList() {
        return wishList;
    }

    public Wishlist(long userId, Date timestamp) {

        this.userId = userId;
        this.timestamp = timestamp;
    }

    public void addToWishList(Long presentId){
        wishList.add(presentId);
    }
}
