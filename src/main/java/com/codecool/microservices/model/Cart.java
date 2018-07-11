package com.codecool.microservices.model;

import java.util.Date;
import java.util.List;

public class Cart {

    private long userId;
    private List<Long> presents;
    private Date timeOfModification;

    public Cart(long userId, List<Long> presents, Date timeOfModification) {
        this.userId = userId;
        this.presents = presents;
        this.timeOfModification = timeOfModification;
    }

    public long getUserId() {
        return userId;
    }

    public List<Long> getPresents() {
        return presents;
    }

    public Date getTimeOfModification() {
        return timeOfModification;
    }

}
