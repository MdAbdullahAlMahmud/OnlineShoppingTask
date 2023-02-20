package com.example.onlineshoppingbs23.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.ui.authentication.AuthenticationActivity;
import com.example.onlineshoppingbs23.ui.authentication.RegistrationActivity;
import com.mkrlabs.customstatusbar.CustomStatusBar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);

        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent= new Intent(SplashActivity.this, AuthenticationActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}