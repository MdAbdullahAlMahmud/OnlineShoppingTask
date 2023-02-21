package com.example.onlineshoppingbs23.model;

public class OrderItem {
    private  int pId;
    private  String name;
    private  double  price;
    private  int  qty;


    public OrderItem(int pId, String name, double price, int qty) {
        this.pId = pId;
        this.name = name;
        this.price = price;
        this.qty = qty;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
