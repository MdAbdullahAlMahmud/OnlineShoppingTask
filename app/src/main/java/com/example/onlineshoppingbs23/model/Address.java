package com.example.onlineshoppingbs23.model;

public class Address {

    private  String roadNo;
    private  String houseNo;
    private  String areaName;
    private  String postalCode;


    public Address(String roadNo, String houseNo, String areaName, String postalCode) {
        this.roadNo = roadNo;
        this.houseNo = houseNo;
        this.areaName = areaName;
        this.postalCode = postalCode;
    }

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
