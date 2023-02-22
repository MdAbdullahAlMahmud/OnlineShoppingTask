package com.example.onlineshoppingbs23.model;

public class PaymentTransaction {

    private  String orderId;
    private  String uid;
    private  String paymentId;
    private Payment payment;


    public  PaymentTransaction(){

    }
    public PaymentTransaction( String orderId, String uid, String paymentId, Payment payment) {
        this.orderId = orderId;
        this.uid = uid;
        this.paymentId = paymentId;
        this.payment = payment;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
