package com.codecool.microservices.model;

import java.util.Date;

public class Present {

    private long id;
    private String name;
    private String description;
    private double price;

    private String category;
    private boolean available;
    private int ownerId;
    private String imageUrl;
    private Date timestamp;

    public Present(long id, String name, String description, double price, String category, boolean available, int ownerId, String imageUrl,Date timestamp) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.available = available;
        this.ownerId = ownerId;
        this.imageUrl = imageUrl;
        this.timestamp = timestamp;
    }

    public Present(String name, String description, double price, String category, boolean available, int ownerId, String imageUrl, Date timestamp) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
        this.ownerId = ownerId;
        this.imageUrl = imageUrl;
        this.timestamp = timestamp;
    }

    public long getId() {
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

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Present{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", available=" + available +
                ", ownerId=" + ownerId +
                ", imageUrl='" + imageUrl + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
