package com.example.onlineshoppingbs23.model;

import com.example.onlineshoppingbs23.enums.PaymentType;

public class CODPayment extends  Payment{




    private Address address;

    public CODPayment(String paymentName, String accountNumber, double amount, PaymentType paymentType ,Address address) {
        super(paymentName, accountNumber, amount, paymentType);
        this.address = address;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean handlePaymentProcess() {
        return false;
    }
}
