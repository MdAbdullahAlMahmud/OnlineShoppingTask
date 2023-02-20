package com.example.onlineshoppingbs23.ui.authentication;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.onlineshoppingbs23.data.local.AppDatabase;
import com.example.onlineshoppingbs23.data.local.entity.UserEntity;
import com.example.onlineshoppingbs23.utils.CommonFunction;

public class AuthenticationModel implements  AuthenticationContract.Model.ModelResponse{


    private  AuthenticationContract.Model model;
    private AppDatabase appDatabase;
    private  Context context ;

    public AuthenticationModel(AuthenticationContract.Model model,Context context) {
        this.model = model;
        appDatabase = AppDatabase.getInstance(context);
        this.context = context;
    }



    @Override
    public void getLoginStatus(String phone, String password) {



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                int userId = appDatabase.userDao().login(phone,password);

                String message = userId>=0?"Logged in success" : "Bad credential";
                model.loginResponseStatusFromSource(userId>0?true:false, String.valueOf(userId),message);


            }
        },2000);

    }

    @Override
    public void createUserAccount(UserEntity user ) {



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                appDatabase.userDao().insertUser(user);
                model.registrationResponseFromSource(true, "Account created successfully");


            }
        },3000);


    }
}
