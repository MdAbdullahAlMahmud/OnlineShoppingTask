package com.example.onlineshoppingbs23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.enums.OrderStatus;
import com.example.onlineshoppingbs23.model.Order;
import com.example.onlineshoppingbs23.model.OrderItem;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{


    private List<Order> orderList ;
    private Context context;


    public  OnOrderItemClickListener onOrderItemClickListener;
    public OrderAdapter(List<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_item,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        Order order = orderList.get(position);


        holder.orderItemOrderId.setText("Order Id #"+order.getId());

        SimpleDateFormat s = new SimpleDateFormat("hh:mm a dd/MM/yyyy");

        holder.orderItemTime.setText(s.format(order.getTimestamp()));

        if (order.getOrderStatus().equals(OrderStatus.Delivered)){
            holder.orderStatusIcon.setImageDrawable(context.getDrawable(R.drawable.baseline_check_circle_outline_24));
            holder.orderItemOrderStatus.setTextColor(context.getResources().getColor(R.color.successColor));

        }
        holder.orderItemOrderStatus.setText(order.getOrderStatus().name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOrderItemClickListener.onClick(order);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public  void setOnOrderItemClickListener(OnOrderItemClickListener onOrderItemClickListener){
        this.onOrderItemClickListener = onOrderItemClickListener;
    }
    public  class  OrderViewHolder extends RecyclerView.ViewHolder {

        public TextView orderItemOrderId,orderItemTime,orderItemOrderStatus;
        public ImageButton orderStatusIcon;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            orderItemOrderId = itemView.findViewById(R.id.orderItemOrderId);
            orderItemTime = itemView.findViewById(R.id.orderItemTime);
            orderItemOrderStatus = itemView.findViewById(R.id.orderItemOrderStatus);
            orderStatusIcon = itemView.findViewById(R.id.orderStatusIcon);
        }
    }

    public interface  OnOrderItemClickListener{
        void  onClick(Order order);
    }
}
