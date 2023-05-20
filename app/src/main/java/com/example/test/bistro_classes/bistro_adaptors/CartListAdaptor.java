package com.example.test.bistro_classes.bistro_adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.bistro_classes.bistro_domains.ItemDomain;
import com.example.test.bistro_database.helper.ManagementCart;
import com.example.test.bistro_interfaces.ChangeNumberItemListener;

import java.util.ArrayList;

public class CartListAdaptor extends RecyclerView.Adapter<CartListAdaptor.ViewHolder> {

    private final ArrayList<ItemDomain> foods_domains;
    private final ManagementCart management_cart;
    private final ChangeNumberItemListener change_num_item_listen;

    public CartListAdaptor(ArrayList<ItemDomain> foods_domains, Context context, ChangeNumberItemListener change_num_item_listen) {
        this.foods_domains = foods_domains;
        this.management_cart = new ManagementCart(context);
        this.change_num_item_listen = change_num_item_listen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bistro_viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(foods_domains.get(position).getTitle());
        holder.fee_each_item.setText(String.valueOf(foods_domains.get(position).getFee()));
        holder.total_each_item.setText(String.valueOf(Math.round((foods_domains.get(position).getNum_in_cart() * foods_domains.get(position).getFee()) * 100) / 100));
        holder.num.setText(String.valueOf(foods_domains.get(position).getNum_in_cart()));

        @SuppressLint("DiscouragedApi") int drawable_resource_id = holder.itemView.getContext().getResources().getIdentifier(foods_domains.get(position).getPic(),"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawable_resource_id).into(holder.pic);

        holder.plus_item.setOnClickListener(v -> management_cart.plus_num_food(foods_domains, position, () -> {
            notifyDataSetChanged();
            change_num_item_listen.changed();
        }));

        holder.minus_item.setOnClickListener(v -> management_cart.minus_num_food(foods_domains, position, () -> {
            notifyDataSetChanged();
            change_num_item_listen.changed();
        }));

    }

    @Override
    public int getItemCount() {
        return foods_domains.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{

        TextView title, fee_each_item, total_each_item, num;
        ImageView pic, plus_item, minus_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_cart);
            fee_each_item = itemView.findViewById(R.id.fee_each_item);
            pic = itemView.findViewById(R.id.pic_cart);
            total_each_item = itemView.findViewById(R.id.total_each_item);
            num = itemView.findViewById(R.id.number_item);
            plus_item = itemView.findViewById(R.id.plus_cart);
            minus_item = itemView.findViewById(R.id.minus_cart);
        }
    }

}
