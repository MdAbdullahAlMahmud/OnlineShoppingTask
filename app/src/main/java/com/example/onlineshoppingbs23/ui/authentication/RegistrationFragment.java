package com.example.onlineshoppingbs23.ui.authentication;

import android.hardware.usb.UsbRequest;
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
import com.example.onlineshoppingbs23.ui.model.User;
import com.example.onlineshoppingbs23.utils.CommonFunction;


public class RegistrationFragment extends Fragment implements AuthenticationContract.RegistrationView {

    private TextView registrationSignIn;
    private AppCompatButton signUpButton;
    private EditText nameEdt,phoneEdt,passwordEdt,confirmPasswordEdt;

    private ProgressBar registrationProgressBar;

    private AuthenticationPresenter authenticationPresenter;

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

        authenticationPresenter = new AuthenticationPresenter(this);



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
                authenticationPresenter.createAccountFromUI(new User());

            }
        });
    }

    private void initView(View view) {

        registrationProgressBar =view.findViewById(R.id.registrationProgressBar);
        signUpButton =view.findViewById(R.id.signUpButton);
        registrationSignIn =view.findViewById(R.id.registrationSignIn);
        nameEdt =view.findViewById(R.id.registrationNameEdt);
        phoneEdt =view.findViewById(R.id.registrationMobileEdt);
        passwordEdt =view.findViewById(R.id.registrationPasswordEdt);
        confirmPasswordEdt =view.findViewById(R.id.registrationConfirmPasswordEdt);

    }

    @Override
    public void showLoading() {
        registrationProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        registrationProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void registrationResponse(boolean status, String response) {

        CommonFunction.successToast(getContext(), " Account Created");
    }

    @Override
    public void showError() {

    }
}