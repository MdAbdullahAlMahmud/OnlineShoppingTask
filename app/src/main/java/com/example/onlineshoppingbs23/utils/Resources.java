package com.example.onlineshoppingbs23.utils;

import com.example.onlineshoppingbs23.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Resources {


    private static   List<OrderItem> orderList = new ArrayList<>();

    public  static List<OrderItem> getAllCartListProducts(){
        return  orderList;
    }



    public  static  void addOrder(OrderItem OrderItem) {
        orderList.add(OrderItem);
    }


    public  static  void  removeOrder(OrderItem orderItem){
        orderList.remove(orderItem);
    }
}
