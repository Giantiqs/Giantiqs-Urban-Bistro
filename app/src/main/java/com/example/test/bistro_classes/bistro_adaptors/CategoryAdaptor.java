package com.example.test.bistro_classes.bistro_adaptors;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.bistro_classes.bistro_domains.CategoryDomain;

import java.util.ArrayList;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    ArrayList<CategoryDomain> category_domains;

    public CategoryAdaptor(ArrayList<CategoryDomain> category_domains) {
        this.category_domains = category_domains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bistro_viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.category_name.setText(category_domains.get(position).getTitle());
        String pic_url = "";

        switch (position){
            case 0:{
                pic_url = "cappuccino";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_viewholderv3));
                holder.main_layout.setOnClickListener(v -> {
                    Toast.makeText(holder.itemView.getContext(), "Frappe", Toast.LENGTH_SHORT).show();
                });
                break;
            }
            case 1:{
                pic_url = "tea";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_viewholderv3));
                holder.main_layout.setOnClickListener(v -> {
                    Toast.makeText(holder.itemView.getContext(), "Coffee", Toast.LENGTH_SHORT).show();
                });
                break;
            }
            case 2:{
                pic_url = "pizza";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_viewholderv3));
                holder.main_layout.setOnClickListener(v -> {
                    Toast.makeText(holder.itemView.getContext(), "Pizza", Toast.LENGTH_SHORT).show();
                });
                break;
            }

            case 3:{
                pic_url = "cat_5";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_viewholderv3));
                holder.main_layout.setOnClickListener(v -> {
                    Toast.makeText(holder.itemView.getContext(), "Pastry", Toast.LENGTH_SHORT).show();
                });
                break;
            }
        }

        @SuppressLint("DiscouragedApi") int drawable_resource = holder.itemView.getContext().getResources().getIdentifier(pic_url, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawable_resource).into(holder.category_pic);
    }

    @Override
    public int getItemCount() {
        return category_domains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView category_name;
        ImageView category_pic;
        ConstraintLayout main_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);
            category_pic = itemView.findViewById(R.id.category_pic);
            main_layout = itemView.findViewById(R.id.main_layout);
        }
    }
}
