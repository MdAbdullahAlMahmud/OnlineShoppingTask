package com.example.onlineshoppingbs23.ui.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.onlineshoppingbs23.R;

public class OrderActivity extends AppCompatActivity {



    private RecyclerView orderRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        init();
        initRecycle();
    }


    public  void  initRecycle(){

        orderRecycleView = findViewById(R.id.orderRecycleView);
        orderRecycleView.setLayoutManager(new LinearLayoutManager(this));
        orderRecycleView.setHasFixedSize(true);

    }

    public  void  init(){

    }
}
