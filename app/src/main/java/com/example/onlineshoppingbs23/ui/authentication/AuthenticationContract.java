package com.example.onlineshoppingbs23.ui.authentication;

import com.example.onlineshoppingbs23.data.local.entity.UserEntity;

public interface AuthenticationContract {

    interface  BaseView {
        void showLoading();
        void hideLoading();
    }
    interface  LoginView extends  BaseView{
        void showError(String error);
        void response(boolean valid, String uid,String message);
    }

    interface  RegistrationView extends  BaseView{
        void registrationResponse(boolean status ,String response);
        void showError();
    }


    interface  Model{
        interface ModelResponse{
            void  getLoginStatus(String phone, String password);
            void  createUserAccount(UserEntity user);

        }

        void  registrationResponseFromSource(boolean isCreated,String message);
        void loginResponseStatusFromSource(boolean valid, String uid, String message);


    }
    interface Presenter{
        void getLoginStatusFromUI(String phone, String password);
        void createAccountFromUI(UserEntity user);
        void destroyView();
    }
}
