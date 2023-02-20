package com.example.onlineshoppingbs23.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.adapter.ProductAdapter;
import com.example.onlineshoppingbs23.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView homeRV;
    private ProductAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initRecycleView();

        List<Product> productList = new ArrayList<>();

        String image = "https://images.unsplash.com/photo-1533090481720-856c6e3c1fdc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80";

        productList.add(new Product("a",125,"desc",image));
        productList.add(new Product("b",125,"desc",image));
        productList.add(new Product("c",125,"desc",image));
        productList.add(new Product("d",125,"desc",image));
        productList.add(new Product("e",125,"desc",image));
        adapter = new ProductAdapter(productList,this);
        homeRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initRecycleView() {
        homeRV = findViewById(R.id.homeRV);

        homeRV.setLayoutManager(new GridLayoutManager(this,2));
        homeRV.setHasFixedSize(true);

    }
}