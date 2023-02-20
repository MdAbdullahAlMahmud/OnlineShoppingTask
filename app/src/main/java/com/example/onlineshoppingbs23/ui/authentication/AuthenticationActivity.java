package com.example.onlineshoppingbs23.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.onlineshoppingbs23.R;
import com.mkrlabs.customstatusbar.CustomStatusBar;

public class AuthenticationActivity extends AppCompatActivity {
    private FrameLayout registrationFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);

        setContentView(R.layout.activity_authentication);

        init();
        setUpFragment(new RegistrationFragment());

    }
    private void init(){

        registrationFrameLayout = findViewById(R.id.registrationFrameLayout);

    }

    public  void setUpFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();

        if (fragment != null) {
            fragmentTransaction.replace(R.id.registrationFrameLayout, fragment).commit();

        }

    }
}