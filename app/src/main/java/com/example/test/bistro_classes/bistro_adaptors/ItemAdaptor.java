package com.example.test.bistro_classes.bistro_adaptors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.bistro_activities.ShowDetail;
import com.example.test.bistro_classes.bistro_domains.ItemDomain;

import java.util.ArrayList;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.ViewHolder> {

    ArrayList<ItemDomain> itemDomains;

    public ItemAdaptor(ArrayList<ItemDomain> itemDomains) {
        this.itemDomains = itemDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bistro_viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(itemDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(itemDomains.get(position).getFee()));

        @SuppressLint("DiscouragedApi") int drawable_resource = holder.itemView.getContext().getResources().getIdentifier(itemDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawable_resource).into(holder.pics);

        holder.add_button.setOnClickListener(v -> {
            Intent i = new Intent(holder.itemView.getContext(), ShowDetail.class);
            i.putExtra("object", itemDomains.get(position));
            holder.itemView.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return itemDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, add_button, fee;
        ImageView pics;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_p);
            fee = itemView.findViewById(R.id.fee);
            pics = itemView.findViewById(R.id.pics);
            add_button = itemView.findViewById(R.id.add_button);
        }

    }

}
