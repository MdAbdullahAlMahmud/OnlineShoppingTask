package com.example.onlineshoppingbs23.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MyShreadPref {


        private Context context;

        private final String UID = "UID";
        private final String LOGGED_USER_NAME = "LOGGED_USER_NAME";

        private SharedPreferences sharedPreferences;

    public  MyShreadPref(Context context){
            this.context = context;
            sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }


        public  void  setUID(String uid){
            sharedPreferences.edit().putString(UID,uid).apply();
        }

        public String getUID(){
            return  sharedPreferences.getString(UID,"");
        }





}
