package com.example.onlineshoppingbs23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.model.OrderItem;

import java.util.List;

public class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    List<OrderItem> orderItemList;
    Context context ;

    public  OnOrderItemClickListener onOrderItemClickListener;

    public OrderAdapter(List<OrderItem> orderItemList, Context context) {
        this.orderItemList = orderItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_item_design,parent,false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        OrderItem orderItem = orderItemList.get(position);




        holder.cartListProductName.setText(orderItem.getName());
        holder.cartListProductPrice.setText(String.valueOf(orderItem.getPrice() ));

        holder.cartListItemQtyTv.setText(String.valueOf(orderItem.getQty()));

        holder. cartListItemRateSummary.setText(orderItem.getPrice()+" * "+orderItem.getQty() + " = "+ (orderItem.getPrice() * orderItem.getQty()));


        holder.cartListItemPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOrderItemClickListener.OnPlusButtonClick(holder.cartListItemQtyTv, holder.cartListItemRateSummary,orderItem);
            }
        });


        holder.cartListItemMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOrderItemClickListener.OnMinusButtonClick(holder.cartListItemQtyTv, holder.cartListItemRateSummary,orderItem);
            }
        });

        holder.cartListItemRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOrderItemClickListener.OnDeleteButtonClick(position,orderItem);
            }
        });



    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }


    public  void  setOnOrderItemClickListener(OnOrderItemClickListener onOrderItemClickListener){
        this.onOrderItemClickListener = onOrderItemClickListener;
    }


    public  class  OrderViewHolder extends RecyclerView.ViewHolder {


        public TextView cartListProductName,cartListProductPrice,cartListItemQtyTv,cartListItemRateSummary;
        public ImageButton cartListItemRemoveButton;
        public Button cartListItemMinusButton ,cartListItemPlusButton;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            cartListProductName = itemView.findViewById(R.id.cartListProductName);
            cartListProductPrice = itemView.findViewById(R.id.cartListProductPrice);
            cartListItemQtyTv = itemView.findViewById(R.id.cartListItemQtyTv);
            cartListItemRateSummary = itemView.findViewById(R.id.cartListItemRateSummary);
            cartListItemRemoveButton = itemView.findViewById(R.id.cartListItemRemoveButton);
            cartListItemMinusButton = itemView.findViewById(R.id.cartListItemMinusButton);
            cartListItemPlusButton = itemView.findViewById(R.id.cartListItemPlusButton);

        }
    }

    public  interface  OnOrderItemClickListener{

        void OnPlusButtonClick(TextView displayTv, TextView rateSummaryTv,OrderItem orderItem);
        void OnMinusButtonClick(TextView displayTv,TextView rateSummaryTv,OrderItem orderItem);
        void OnDeleteButtonClick(int position , OrderItem orderItem);


    }
}
