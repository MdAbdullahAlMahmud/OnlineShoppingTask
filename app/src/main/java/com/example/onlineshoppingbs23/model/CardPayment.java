package com.example.onlineshoppingbs23.model;

import com.example.onlineshoppingbs23.enums.PaymentType;

public class CardPayment extends Payment{

    private  String cvc;
    private  String cardHolderName;
    private  String expireDate;


    public CardPayment(String paymentName, String accountNumber, double amount, PaymentType paymentType ,String cvc,String cardHolderName,String expireDate) {
        super(paymentName, accountNumber, amount, paymentType);
        this.cardHolderName=cardHolderName;
        this.cvc=cvc;
        this.expireDate=expireDate;
    }


    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean handlePaymentProcess() {
        return false;
    }
}
