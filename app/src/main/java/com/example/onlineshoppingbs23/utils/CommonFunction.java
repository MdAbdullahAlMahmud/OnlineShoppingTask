package com.example.onlineshoppingbs23.utils;

import android.content.Context;

import es.dmoral.toasty.Toasty;

public class CommonFunction {


    public static void infoToast(Context context, String msg){
        Toasty.info(context,msg).show();
    }

    public static void errorToast(Context context,String msg){
        Toasty.error(context,msg).show();
    }

    public static void successToast(Context context,String msg){
        Toasty.success(context,msg).show();
    }
}
