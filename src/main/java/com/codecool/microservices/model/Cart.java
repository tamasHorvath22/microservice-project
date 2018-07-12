package com.codecool.microservices.model;

import java.sql.Timestamp;
import java.util.List;

public class Cart {

    private long userId;
    private List<Long> presentIds;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Cart(long userId, List<Long> presentIds) {
        this.userId = userId;
        this.presentIds = presentIds;
        this.timestamp = new Timestamp(System.currentTimeMillis());

    }

    public long getUserId() {
        return userId;
    }

    public List<Long> getPresentIds() {
        return presentIds;
    }

}
