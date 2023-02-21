package com.example.onlineshoppingbs23.model;

import com.example.onlineshoppingbs23.enums.OrderStatus;

import java.sql.Timestamp;
import java.util.List;

public class Order {

    private  int id;
    private  double total_price;
    private  int uid;
    private Timestamp  timestamp;

    private OrderStatus orderStatus;


    private List<OrderItem> orderDetails;

    public Order(int id, double total_price, int uid, Timestamp timestamp, OrderStatus orderStatus , List<OrderItem> orderDetails) {
        this.id = id;
        this.total_price = total_price;
        this.uid = uid;
        this.timestamp = timestamp;
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


    public List<OrderItem> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderItem> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
