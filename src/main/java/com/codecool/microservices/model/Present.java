package com.codecool.microservices.model;

import java.util.Date;

public class Present {

    private int id;
    private String name;
    private double price;

    private String category;
    private boolean available;
    private int ownerId;
    private Date timestamp;

    public Present(int id, String name, double price, String category, boolean available, int ownerId, Date timestamp) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
        this.ownerId = ownerId;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "Present{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", available=" + available +
                ", ownerId=" + ownerId +
                ", timestamp=" + timestamp +
                '}';
    }
}
