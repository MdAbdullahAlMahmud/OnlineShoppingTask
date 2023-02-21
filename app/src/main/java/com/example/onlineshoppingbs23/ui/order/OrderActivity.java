package com.example.onlineshoppingbs23.ui.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.adapter.OrderAdapter;
import com.example.onlineshoppingbs23.enums.OrderStatus;
import com.example.onlineshoppingbs23.model.Order;
import com.example.onlineshoppingbs23.model.OrderItem;
import com.example.onlineshoppingbs23.utils.Resources;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderActivity extends AppCompatActivity {



    private RecyclerView orderRecycleView;

    private OrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        init();
        initRecycle();


        List<Order> orderList = Resources.getAllOrderList();


        adapter = new OrderAdapter(orderList,OrderActivity.this);

        orderRecycleView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        adapter.setOnOrderItemClickListener(new OrderAdapter.OnOrderItemClickListener() {
            @Override
            public void onClick(Order order) {
                showOrderDetailsBottomSheet();
            }
        });

    }


    public void showOrderDetailsBottomSheet(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(OrderActivity.this);

        LinearLayout linearLayout = new LinearLayout(OrderActivity.this);


        bottomSheetDialog.setContentView(linearLayout);

        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.show();


    }

    public  void  initRecycle(){

        orderRecycleView = findViewById(R.id.orderRecycleView);
        orderRecycleView.setLayoutManager(new LinearLayoutManager(this));
        orderRecycleView.setHasFixedSize(true);

    }

    public  void  init(){

    }
}
