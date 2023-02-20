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
import com.example.onlineshoppingbs23.data.local.entity.UserEntity;
import com.example.onlineshoppingbs23.enums.UserRole;
import com.example.onlineshoppingbs23.model.User;
import com.example.onlineshoppingbs23.utils.CommonFunction;

import es.dmoral.toasty.Toasty;


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

        authenticationPresenter = new AuthenticationPresenter(this,getContext());



        registrationSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((AuthenticationActivity)getActivity()).setUpFragment(new LoginFragment());

            }
        });



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                validateField();

            }
        });
    }
    private  void  validateField(){

        String name = nameEdt.getText().toString().trim();
        String phone = phoneEdt.getText().toString();
        String password = passwordEdt.getText().toString();
        String confirmPassword = confirmPasswordEdt.getText().toString();



        if (name.isEmpty()){
            nameEdt.setError("required");
            return;
        }

        if (phone.isEmpty()){
            phoneEdt.setError("required");
            return;
        }

        if (password.isEmpty()){
            passwordEdt.setError("required");
            return;
        }
        if (confirmPassword.isEmpty()){
            confirmPasswordEdt.setError("required");
            return;
        }
        if (!password.equals(confirmPassword)){
            Toasty.error(getContext(),"Password Mismatch").show();
            return;
        }
    // User(String name, String mobile, String password, String uid, String image, UserRole userRole) {
        User user = new User(name,phone,password,"","", UserRole.Customer);

        UserEntity userEntity = new UserEntity();
        userEntity.name = name;
        userEntity.phone = phone;
        userEntity.password = password;
        userEntity.role = UserRole.Customer.ordinal();
        authenticationPresenter.createAccountFromUI(userEntity);







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