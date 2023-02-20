package com.example.onlineshoppingbs23.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.onlineshoppingbs23.R;
import com.example.onlineshoppingbs23.model.Product;
import com.example.onlineshoppingbs23.utils.KeyName;

import java.util.List;
import java.util.Random;

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
        Product foodItem = productsItemList.get(position);

        Glide.with(holder.itemView)

                .load(foodItem.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.productItemLoadingProgress.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.productItemLoadingProgress.setVisibility(View.GONE);

                        return false;
                    }
                })
                .into(holder.productImageRV);

        holder.productItemName.setText(foodItem.getName());

        Random r = new Random();
        int low = 100;
        int high = 900;
        int result = r.nextInt(high-low) + low;

        holder.productItemPrice.setText(KeyName.PRODUCT_CURRENCY+" "+result);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Log.v("Res","Deails -> "+foodItem.toString());
                Intent intent = new Intent(context, FoodDetailsActivity.class);
                intent.putExtra(KeyName.FOOD_DETAILS,foodItem);
                context.startActivity(intent);*/
            }
        });
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
