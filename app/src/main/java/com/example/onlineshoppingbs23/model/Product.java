package com.example.onlineshoppingbs23.model;

public class Product {

    private String name;
    private double  price;
    private String description;
    private String image;
    private int pId;


    public Product(int pId , String name, double  price, String description, String image) {
        this.pId = pId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
