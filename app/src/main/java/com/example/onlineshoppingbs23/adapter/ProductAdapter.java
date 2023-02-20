package com.example.onlineshoppingbs23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.model.Product;

import java.util.List;

public class ProductAdapter  extends  RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> productsItemList;
    private Context context;

    public ProductAdapter(List<Product> productsItemList, Context context) {
        this.productsItemList = productsItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        return new ProductViewHolder( view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }

    public  class  ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImageRV;
        public TextView productItemName,productItemPrice;
        public ProgressBar productItemLoadingProgress;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageRV = itemView.findViewById(R.id.productItemImage);
            productItemName = itemView.findViewById(R.id.productItemName);
            productItemPrice = itemView.findViewById(R.id.productItemPrice);
            productItemLoadingProgress = itemView.findViewById(R.id.productItemLoadingProgress);
        }
    }
}
