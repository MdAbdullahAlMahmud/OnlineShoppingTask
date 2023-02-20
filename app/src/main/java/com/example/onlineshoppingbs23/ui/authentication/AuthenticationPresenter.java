package com.example.onlineshoppingbs23.ui.authentication;

import android.content.Context;

import com.example.onlineshoppingbs23.data.local.entity.UserEntity;

public class AuthenticationPresenter implements  AuthenticationContract.Presenter ,AuthenticationContract.Model{


    AuthenticationContract.LoginView loginView;
    AuthenticationContract.RegistrationView registrationView;


    AuthenticationModel model;


    public AuthenticationPresenter(AuthenticationContract.BaseView baseView ,Context context) {
        this.registrationView = (AuthenticationContract.RegistrationView) baseView;
        this.model = new AuthenticationModel(this, context);
    }


    public  AuthenticationPresenter(AuthenticationContract.LoginView loginView, Context context){
        this.loginView = loginView;
        this.model = new AuthenticationModel(this, context);
    }

    @Override
    public void getLoginStatusFromUI(String phone, String password) {
        if (loginView!=null){
            loginView.showLoading();
            model.getLoginStatus(phone,password);
        }

    }

    @Override
    public void createAccountFromUI(UserEntity user) {
        if (registrationView!=null){
            registrationView.showLoading();
            model.createUserAccount(user);


        }
    }





    @Override
    public void destroyView() {
        if (registrationView !=null || loginView!=null ){
            registrationView = null;
            loginView = null;
        }

    }

    @Override
    public void registrationResponseFromSource(boolean isCreated, String message) {

        if (registrationView!=null){
            registrationView.registrationResponse(isCreated,message);
            registrationView.hideLoading();
        }

    }



    @Override
    public void loginResponseStatusFromSource(boolean valid, String uid, String message) {

        if (loginView!=null){
            loginView.response(valid,uid,message);
            loginView.hideLoading();
        }
    }
}
