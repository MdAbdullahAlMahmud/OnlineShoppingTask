package com.example.onlineshoppingbs23.ui.cart_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.adapter.CartAdapter;
import com.example.onlineshoppingbs23.enums.OrderStatus;
import com.example.onlineshoppingbs23.enums.PaymentType;
import com.example.onlineshoppingbs23.model.CODPayment;
import com.example.onlineshoppingbs23.model.CardPayment;
import com.example.onlineshoppingbs23.model.Order;
import com.example.onlineshoppingbs23.model.OrderItem;
import com.example.onlineshoppingbs23.model.PaymentTransaction;
import com.example.onlineshoppingbs23.ui.HomeActivity;
import com.example.onlineshoppingbs23.utils.BSShopLoadingDialog;
import com.example.onlineshoppingbs23.utils.CommonFunction;
import com.example.onlineshoppingbs23.utils.KeyName;
import com.example.onlineshoppingbs23.utils.MyShreadPref;
import com.example.onlineshoppingbs23.utils.Resources;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartActivity extends AppCompatActivity {

    private MaterialButton orderPlaceButton;
    private RecyclerView cartRecycleView;
    private CartAdapter cartAdapter;

    private TextView cartListTotalAmountTv;

    private  double totalAmount = 0;
    private MyShreadPref myShreadPref;

    private FirebaseFirestore firebaseFirestore;

    private BSShopLoadingDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        myShreadPref = new MyShreadPref(this);
        firebaseFirestore = FirebaseFirestore.getInstance();

        loadingDialog = new BSShopLoadingDialog(this);
        init();
        initRecycleView();





        orderPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BSShopLoadingDialog bsShopLoadingDialog = new BSShopLoadingDialog(CartActivity.this);
                AlertDialog builder = new AlertDialog.Builder(CartActivity.this)
                        .setTitle("Do you want to place this order ? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                bsShopLoadingDialog.showDialog();

                                Random rand = new Random();
                                int generatedOrderID = rand.nextInt(1000) + 1000000;

                                int totalPrice = 0 ;
                                for ( int index = 0 ; index < Resources.getAllCartListProducts().size();index++){

                                    OrderItem orderItem = Resources.getAllCartListProducts().get(index);
                                    double amount = orderItem.getQty() * orderItem.getPrice();
                                     totalPrice +=amount;
                                }




                                String orderId = firebaseFirestore.collection(KeyName.ORDERS_NODE).document().getId();
                                Order order = new  Order(generatedOrderID,totalPrice,Integer.parseInt(myShreadPref.getUID()),new Date(), OrderStatus.Pending,Resources.getAllCartListProducts(),orderId);

                                //public CardPayment(String paymentName, String accountNumber, double amount, PaymentType paymentType ,String cvc,String cardHolderName,String expireDate) {

                                CardPayment cardPayment = new CardPayment("Master Card", "4444-4444-4444-1111" , totalPrice, PaymentType.CARD,"434","Abdullah","12/25");

                                //PaymentTransaction(String transactionId, String orderId, String uid, String paymentId, Payment payment) {


                                String paymentId = firebaseFirestore.collection(KeyName.PAYMENT_Transaction_NODE).document().getId();

                                PaymentTransaction paymentTransaction = new PaymentTransaction();
                                paymentTransaction.setOrderId(orderId);
                                paymentTransaction.setPayment(cardPayment);
                                paymentTransaction.setPaymentId(paymentId);
                                paymentTransaction.setUid(myShreadPref.getUID());



                                firebaseFirestore.collection(KeyName.PAYMENT_Transaction_NODE).document(paymentId).set(paymentTransaction).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            CommonFunction.successToast(CartActivity.this,"Payment  completed successfully");
                                        }else {
                                            CommonFunction.successToast(CartActivity.this,"Something went wrong");
                                        }
                                    }
                                });



                                bsShopLoadingDialog.cancelDialog();

                                firebaseFirestore.collection(KeyName.ORDERS_NODE).document(orderId).set(order).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){

                                            CommonFunction.successToast(CartActivity.this,"Order placed successfully");

                                            Intent intent = new Intent(CartActivity.this, HomeActivity.class);

                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        }
                                    }
                                });






                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create();

                builder.show();



            }
        });


        buildOrderList();

        showTotalPrice();
        cartAdapter.setOnOrderItemClickListener(new CartAdapter.OnOrderItemClickListener() {
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

                Resources.removeFromCart(orderItem);
                cartAdapter.notifyDataSetChanged();


            }
        });




    }
    public  void  buildOrderList(){
        List<OrderItem> orderItemList = Resources.getAllCartListProducts();
        cartAdapter = new CartAdapter(orderItemList,this);

        cartRecycleView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
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