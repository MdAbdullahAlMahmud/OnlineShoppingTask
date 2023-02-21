package com.example.onlineshoppingbs23.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.adapter.ProductAdapter;
import com.example.onlineshoppingbs23.model.OrderItem;
import com.example.onlineshoppingbs23.model.Product;
import com.example.onlineshoppingbs23.ui.cart_activity.CartActivity;
import com.example.onlineshoppingbs23.ui.order.OrderActivity;
import com.example.onlineshoppingbs23.utils.CommonFunction;
import com.example.onlineshoppingbs23.utils.Resources;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView homeRV;
    private ProductAdapter adapter ;
    private FloatingActionButton cartListButton;
    private ImageButton orderListButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        initRecycleView();

        List<Product> productList = new ArrayList<>();

        String image = "https://images.unsplash.com/photo-1533090481720-856c6e3c1fdc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80";

        productList.add(new Product(1,"Table",350,"desc",image));
        productList.add(new Product(2,"Chair",420,"desc",image));
        productList.add(new Product(3,"Fan",500,"desc",image));
        productList.add(new Product(4,"Charger",658,"desc",image));
        productList.add(new Product(5,"watch",150,"desc",image));
        adapter = new ProductAdapter(productList,this);
        homeRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        adapter.setOnAddToCartClickListener(new ProductAdapter.OnAddToCartClickListener() {
            @Override
            public void onCartItemClickListener(Product product) {

                OrderItem orderItem = new OrderItem(product.getpId(),product.getName(),product.getPrice(),1);
                Resources.addToCart(orderItem);
                CommonFunction.successToast(HomeActivity.this, "Successfully added to cart list " + product.getName());


            }
        });


        cartListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        orderListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( HomeActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

    }

    private  void  init(){
        cartListButton = findViewById(R.id.cartButton);
        orderListButton = findViewById(R.id.orderListButton);
    }
    private void initRecycleView() {
        homeRV = findViewById(R.id.homeRV);

        homeRV.setLayoutManager(new GridLayoutManager(this,2));
        homeRV.setHasFixedSize(true);

    }
}