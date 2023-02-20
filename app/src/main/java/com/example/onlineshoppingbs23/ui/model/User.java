package com.example.onlineshoppingbs23.ui.model;

enum UserRole{User,Admin, Manager, Cashier}
public class  User {

    private  String name ;
    private  String mobile ;
    private  String password;
    private  String uid;
    private  String image;

    private UserRole userRole;

    public User() {
    }

    public User(String name, String mobile, String password, String uid, String image, UserRole userRole) {

        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.uid = uid;
        this.image = image;
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", uid='" + uid + '\'' +
                ", image='" + image + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
