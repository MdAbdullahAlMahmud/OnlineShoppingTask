package com.example.onlineshoppingbs23.ui.authentication;

import android.os.Handler;
import android.util.Log;

import com.example.onlineshoppingbs23.ui.model.User;

public class AuthenticationModel implements  AuthenticationContract.Model.ModelResponse{


    private  AuthenticationContract.Model model;

    public AuthenticationModel(AuthenticationContract.Model model) {
        this.model = model;
    }



    @Override
    public void getLoginStatus(String phone, String password) {

    }

    @Override
    public void createUserAccount(User user) {

        Log.v("Registration", user.toString());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                model.registrationResponseFromSource(true, "Account created successfully");
            }
        },3000);


    }
}
