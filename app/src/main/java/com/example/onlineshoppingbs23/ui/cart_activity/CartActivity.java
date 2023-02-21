package com.example.onlineshoppingbs23.ui.cart_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.adapter.OrderAdapter;
import com.example.onlineshoppingbs23.model.Order;
import com.example.onlineshoppingbs23.model.OrderItem;
import com.example.onlineshoppingbs23.utils.CommonFunction;
import com.example.onlineshoppingbs23.utils.KeyName;
import com.example.onlineshoppingbs23.utils.Resources;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private MaterialButton orderPlaceButton;
    private RecyclerView cartRecycleView;
    private OrderAdapter orderAdapter;

    private TextView cartListTotalAmountTv;

    private  double totalAmount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        init();
        initRecycleView();




        CommonFunction.infoToast(CartActivity.this, ""+Resources.getAllCartListProducts().size());

        orderPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonFunction.infoToast(CartActivity.this, "Order Placed");
            }
        });


        List<OrderItem> orderItemList = Resources.getAllCartListProducts();
        orderAdapter = new OrderAdapter(orderItemList,this);

        cartRecycleView.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();

        showTotalPrice();
        orderAdapter.setOnOrderItemClickListener(new OrderAdapter.OnOrderItemClickListener() {
            @Override
            public void OnPlusButtonClick(TextView displayTv, TextView rateSummaryTv,OrderItem orderItem) {

                orderItem.setQty(orderItem.getQty() + 1 );

                displayTv.setText(orderItem.getQty() + "");

                double total = orderItem.getQty()*orderItem.getPrice();
                rateSummaryTv.setText(orderItem.getPrice()+" * "+orderItem.getQty() + " = "+ total);

                showTotalPrice();

            }

            @Override
            public void OnMinusButtonClick(TextView displayTv, TextView rateSummaryTv, OrderItem orderItem) {

                if (orderItem.getQty() > 0 ){
                    orderItem.setQty(orderItem.getQty() - 1 );
                    displayTv.setText(orderItem.getQty() + "");

                    double total = orderItem.getQty()*orderItem.getPrice();
                    rateSummaryTv.setText(orderItem.getPrice()+" * "+orderItem.getQty() + " = "+ total);
                    showTotalPrice();

                }

            }

            @Override
            public void OnDeleteButtonClick(int position, OrderItem orderItem) {

            }
        });




    }

    private  void  showTotalPrice(){

        double total  = 0 ;
        for (int i = 0; i <Resources.getAllCartListProducts().size();i++){
            OrderItem orderItem = Resources.getAllCartListProducts().get(i);
            double price = orderItem.getQty() * orderItem.getPrice();
            total +=price;
        }
        cartListTotalAmountTv.setText(KeyName.PRODUCT_CURRENCY+" " +String.valueOf(total));


    }
    private void initRecycleView() {
        cartRecycleView = findViewById(R.id.cartRV);
        cartRecycleView.setHasFixedSize(true);
        cartRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }


    private  void  init(){
        orderPlaceButton = findViewById(R.id.orderPlaceButton);
        cartListTotalAmountTv = findViewById(R.id.cartListTotalAmountTv);
    }
}