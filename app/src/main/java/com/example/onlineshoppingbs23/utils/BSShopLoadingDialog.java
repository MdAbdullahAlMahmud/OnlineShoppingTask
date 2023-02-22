package com.example.onlineshoppingbs23.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.onlineshoppingbs23.R;

public class BSShopLoadingDialog {

    private Dialog dialog;
    private Context context;

    public BSShopLoadingDialog(Context context){
        this.context =context;
        dialog = new Dialog(context);

    }
    public  void  showDialog(){

        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        View view = LayoutInflater.from(context).inflate(R.layout.bs_loading,null);
        dialog.setContentView(view);
        dialog.show();

    }


    public  void  cancelDialog(){
        dialog.dismiss();
    }
}
