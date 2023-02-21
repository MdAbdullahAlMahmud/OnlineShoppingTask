package com.example.onlineshoppingbs23.ui.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onlineshoppingbs23.MainActivity;
import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.adapter.OrderAdapter;
import com.example.onlineshoppingbs23.enums.OrderStatus;
import com.example.onlineshoppingbs23.model.Order;
import com.example.onlineshoppingbs23.model.OrderItem;
import com.example.onlineshoppingbs23.ui.cart_activity.CartActivity;
import com.example.onlineshoppingbs23.utils.CommonFunction;
import com.example.onlineshoppingbs23.utils.KeyName;
import com.example.onlineshoppingbs23.utils.Resources;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderActivity extends AppCompatActivity {



    private RecyclerView orderRecycleView;

    private OrderAdapter adapter;

    private FirebaseFirestore firebaseFirestore ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        firebaseFirestore = FirebaseFirestore.getInstance();
        init();
        initRecycle();



        List<Order> orderList = new ArrayList<>();


        getAllOrderListFromDB();
        adapter = new OrderAdapter(orderList,OrderActivity.this);





    }

    private void getAllOrderListFromDB() {

        firebaseFirestore .collection(KeyName.ORDERS_NODE).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    List<Order> orderList = new ArrayList<>();
                    for (DocumentSnapshot documentSnapshot :task.getResult().getDocuments()){
                        Order order = documentSnapshot.toObject(Order.class);

                        orderList.add(order);
                    }

                    adapter = new OrderAdapter(orderList, OrderActivity.this);
                    orderRecycleView.setAdapter(adapter);
                    adapter.setOnOrderItemClickListener(new OrderAdapter.OnOrderItemClickListener() {
                        @Override
                        public void onClick(Order order) {
                            showOrderDetailsBottomSheet(order);
                          //  CommonFunction.infoToast(OrderActivity.this, "Clicked");
                        }
                    });
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }


    public void showOrderDetailsBottomSheet(Order order){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(OrderActivity.this);



        LinearLayout linearLayout = new LinearLayout(OrderActivity.this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for (OrderItem orderItem : order.getOrderDetails()) {


            TextView textView = new TextView(OrderActivity.this);

            textView.setText(""+ orderItem.getName() );

            linearLayout.addView(textView);

        }


        for (int i = 0; i < order.getOrderDetails().size(); i++) {
            TextView textView = new TextView(OrderActivity.this);

            textView.setText("name "+ i );

            linearLayout.addView(textView);
        }

        Button button = new Button(OrderActivity.this);
        button.setText("Cancel");
        linearLayout.addView(button);


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
