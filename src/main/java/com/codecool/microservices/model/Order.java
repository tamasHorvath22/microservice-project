package com.codecool.microservices.model;

import java.util.*;

public class Order {

    private Long id;
    private Long userId;
    private Date timestamp;

    private List<Present> order = new ArrayList<>();
    private List<Integer> presentIds = new ArrayList<>();


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

    public Order(){}

    public Order(List presentIds, Long id, Long userId, Date timestamp) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.presentIds = presentIds;
    }

    public void setOrder(List<Present> order) {
        this.order = order;
    }

    public void addToOrder(Present present){
        order.add(present);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Integer> getPresentIds() {
        return presentIds;
    }

    public void setPresentIds(List<Integer> presentIds) {
        this.presentIds = presentIds;
    }
}
