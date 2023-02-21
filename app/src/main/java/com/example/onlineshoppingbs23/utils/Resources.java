package com.example.onlineshoppingbs23.utils;

import com.example.onlineshoppingbs23.model.Order;
import com.example.onlineshoppingbs23.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Resources {


    private static   List<OrderItem> cartList = new ArrayList<>();
    private static   List<Order> orderList = new ArrayList<>();

    public  static List<OrderItem> getAllCartListProducts(){
        return cartList;
    }

    public  static List<Order> getAllOrderList(){
            return orderList;
        }



    public  static  void addToCart(OrderItem OrderItem) {
        cartList.add(OrderItem);
    }


    public  static  void removeFromCart(OrderItem orderItem){
        cartList.remove(orderItem);
    }

    public  static  void  addToOrderList(Order order){
        orderList.add(order);
    }






}
