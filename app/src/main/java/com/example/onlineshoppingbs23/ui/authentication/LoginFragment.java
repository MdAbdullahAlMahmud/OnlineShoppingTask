package com.example.onlineshoppingbs23.ui.authentication;

import android.content.Intent;
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
import com.example.onlineshoppingbs23.ui.HomeActivity;
import com.example.onlineshoppingbs23.ui.SplashActivity;
import com.example.onlineshoppingbs23.utils.CommonFunction;
import com.example.onlineshoppingbs23.utils.MyShreadPref;


public class LoginFragment extends Fragment implements  AuthenticationContract.LoginView{

    private TextView dontHaveAnAccount,loginForgotPassword;
    private AppCompatButton logInButton;
    private EditText loginNumberEdt,loginPasswordEdt;
    private ProgressBar loginProgressBar;
    MyShreadPref myShreadPref ;


    private  AuthenticationPresenter presenter;
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
        myShreadPref= new MyShreadPref(getContext());

        presenter = new AuthenticationPresenter(this,getContext());
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

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = loginNumberEdt.getText().toString();
                String password = loginPasswordEdt.getText().toString();



                if (phoneNumber.isEmpty()){
                    loginNumberEdt.setError("required");
                    return;
                }

                if (password.isEmpty()){
                    loginPasswordEdt.setError("required");
                    return;
                }
                presenter.getLoginStatusFromUI(phoneNumber,password);
            }
        });

    }

    @Override
    public void showLoading() {
        loginProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loginProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String mes) {
        CommonFunction.infoToast(getContext(),mes);

    }

    @Override
    public void response(boolean valid, String uid,String message) {

        if (valid){

            CommonFunction.successToast(getContext(),message);
            myShreadPref.setUID(uid);
            Intent intent= new Intent(getContext(), HomeActivity.class);
            startActivity(intent);
            getActivity().finish();

        }else {
            CommonFunction.errorToast(getContext(),message);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }
}