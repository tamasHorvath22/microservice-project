package com.codecool.microservices.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private int userId;
    private Date timestamp;

    private List<Present> order = new ArrayList<>();

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<Present> getOrder() {
        return order;
    }

    public Order(int id, int userId, Date timestamp) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public void setOrder(List<Present> order) {
        this.order = order;
    }

    public void addToOrder(Present present){
        order.add(present);
    }
}
