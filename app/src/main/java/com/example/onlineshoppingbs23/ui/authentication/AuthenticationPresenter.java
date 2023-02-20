package com.example.onlineshoppingbs23.ui.authentication;

import com.example.onlineshoppingbs23.ui.model.User;

public class AuthenticationPresenter implements  AuthenticationContract.Presenter ,AuthenticationContract.Model{


    AuthenticationContract.LoginView loginView;
    AuthenticationContract.RegistrationView registrationView;


    AuthenticationModel model;


    public AuthenticationPresenter(AuthenticationContract.BaseView baseView) {
        this.registrationView = (AuthenticationContract.RegistrationView) baseView;
        this.model = new AuthenticationModel(this);
    }

    @Override
    public void getLoginStatusFromUI(String phone, String password) {

    }

    @Override
    public void createAccountFromUI(User user) {
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
    public void loginResponse(String error, User user) {

    }

    @Override
    public void loginResponseStatus(boolean valid, String uid, User user) {

    }
}
