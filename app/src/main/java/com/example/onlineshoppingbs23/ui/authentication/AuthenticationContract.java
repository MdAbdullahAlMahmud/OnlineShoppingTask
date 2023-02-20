package com.example.onlineshoppingbs23.ui.authentication;

import com.example.onlineshoppingbs23.ui.model.User;

public interface AuthenticationContract {

    interface  BaseView {
        void showLoading();
        void hideLoading();
    }
    interface  LoginView extends  BaseView{
        void showError(String error);
        void response(boolean valid, String uid, User user);
    }

    interface  RegistrationView extends  BaseView{
        void registrationResponse(boolean status ,String response);
        void showError();
    }


    interface  Model{
        interface ModelResponse{
            void  getLoginStatus(String phone, String password);
            void  createUserAccount(User user);

        }

        void  registrationResponseFromSource(boolean isCreated,String message);
        void loginResponse(String error,User user);
        void loginResponseStatus(boolean valid,String uid,User user);


    }
    interface Presenter{
        void getLoginStatusFromUI(String phone, String password);
        void createAccountFromUI(User user);
        void destroyView();
    }
}
