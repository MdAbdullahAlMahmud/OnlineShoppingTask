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
import android.widget.TextView;

import com.example.onlineshoppingbs23.R;


public class RegistrationFragment extends Fragment {

    private TextView registrationSignIn;
    private AppCompatButton signUpButton;
    private EditText nameEdt,phoneEdt,passwordEdt,confirmPasswordEdt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_registration, container, false);
        initView(view);
        return  view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        registrationSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((AuthenticationActivity)getActivity()).setUpFragment(new LoginFragment());

            }
        });



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //validateField();

            }
        });
    }

    private void initView(View view) {
        signUpButton =view.findViewById(R.id.signUpButton);
        registrationSignIn =view.findViewById(R.id.registrationSignIn);
        nameEdt =view.findViewById(R.id.registrationNameEdt);
        phoneEdt =view.findViewById(R.id.registrationMobileEdt);
        passwordEdt =view.findViewById(R.id.registrationPasswordEdt);
        confirmPasswordEdt =view.findViewById(R.id.registrationConfirmPasswordEdt);

    }
}