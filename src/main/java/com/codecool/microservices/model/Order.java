package com.codecool.microservices.model;


import java.util.*;

public class Order {

    private Long id;
    private Long userId;
    private Date timestamp;

    private List<Present> order = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<Present> getOrder() {
        return order;
    }

    public Order(Long id, Long userId, Date timestamp) {
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
