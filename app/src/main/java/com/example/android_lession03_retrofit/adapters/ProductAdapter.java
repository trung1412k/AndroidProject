package com.example.android_lession03_retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_lession03_retrofit.R;
import com.example.android_lession03_retrofit.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Context context;
    List<Product> items;
    PostItemListener postItemListener;

    public ProductAdapter(Context context, ArrayList<Product> items, PostItemListener postItemListener) {
        this.context = context;
        this.items = items;
        this.postItemListener = postItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_answer, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, postItemListener);
        return viewHolder;
    }

    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = items.get(position);
        holder.title.setText(product.name + "");
        holder.price.setText(product.price + " " + "VND");
        Glide.with(context)
                .load("http://10.0.2.2:8000" + product.featureImagePath)
                .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
                .into(holder.imgProduct);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView price;
        ImageView imgProduct;


        PostItemListener postItemListener;

        public ViewHolder(@NonNull View itemView, PostItemListener postItemListener) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            title = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_price);
            this.postItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            this.postItemListener.onPostClick(getItem(getAdapterPosition()).getAnswerId());
            notifyDataSetChanged();
        }
    }


    public void updateProducts(List<Product> items) {
        this.items = items;
        notifyDataSetChanged();
    }

//    private Item getItem(int adapterPosition) {
//        return items.get(adapterPosition);
//    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}
