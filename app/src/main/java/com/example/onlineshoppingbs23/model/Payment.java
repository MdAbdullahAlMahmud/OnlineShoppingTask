package com.example.onlineshoppingbs23.model;

import com.example.onlineshoppingbs23.enums.PaymentType;

public  abstract  class Payment {

    private String paymentName;
    private String accountNumber;
    private  double amount;

    private PaymentType paymentType;

    private String paymentId;


    public  abstract boolean handlePaymentProcess();


    public Payment(String paymentId , String paymentName, String accountNumber, double amount, PaymentType paymentType) {
        this(paymentName,accountNumber,amount,paymentType);
        this.paymentId = paymentId;
    }

    public Payment(String paymentName, String accountNumber, double amount, PaymentType paymentType) {
        this.paymentName = paymentName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.paymentType = paymentType;
    }








    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
