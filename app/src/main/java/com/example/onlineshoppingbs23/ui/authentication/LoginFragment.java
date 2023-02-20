package com.example.onlineshoppingbs23.ui.authentication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.onlineshoppingbs23.R;


public class LoginFragment extends Fragment {

    private TextView dontHaveAnAccount,loginForgotPassword;
    private AppCompatButton logInButton;
    private EditText loginNumberEdt,loginPasswordEdt;
    private ProgressBar loginProgressBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        initView(view);
        return  view;
    }
    private void initView(View view) {


        loginNumberEdt= view.findViewById(R.id.loginMobileNumber);
        loginPasswordEdt= view.findViewById(R.id.loginPassword);
        dontHaveAnAccount = view.findViewById(R.id.dontHaveAnAccount);
        logInButton = view.findViewById(R.id.logInButton);
        loginProgressBar = view.findViewById(R.id.loginProgressBar);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AuthenticationActivity)getActivity()).setUpFragment(new RegistrationFragment());
            }
        });

    }
}