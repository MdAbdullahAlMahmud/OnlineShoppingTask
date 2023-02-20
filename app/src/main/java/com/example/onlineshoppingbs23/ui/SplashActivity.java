package com.example.onlineshoppingbs23.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.ui.authentication.AuthenticationActivity;
import com.example.onlineshoppingbs23.utils.CommonFunction;
import com.example.onlineshoppingbs23.utils.MyShreadPref;
import com.mkrlabs.customstatusbar.CustomStatusBar;

public class SplashActivity extends AppCompatActivity {

    private MyShreadPref shreadPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);

        setContentView(R.layout.activity_splash);
        shreadPref = new MyShreadPref(this);


        CommonFunction.infoToast(this ,"UID - > "+ shreadPref.getUID());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!shreadPref.getUID().isEmpty()){
                    Intent intent= new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent= new Intent(SplashActivity.this, AuthenticationActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },3000);
    }
}