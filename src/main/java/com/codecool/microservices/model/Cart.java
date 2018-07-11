package com.codecool.microservices.model;

import java.util.List;

public class Cart {

    private long userId;
    private List<Long> presentIds;

    public Cart(long userId, List<Long> presentIds) {
        this.userId = userId;
        this.presentIds = presentIds;
    }

    public long getUserId() {
        return userId;
    }

    public List<Long> getPresentIds() {
        return presentIds;
    }

}
