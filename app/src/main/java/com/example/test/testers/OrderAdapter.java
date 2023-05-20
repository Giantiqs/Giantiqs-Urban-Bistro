package com.example.test.testers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Model> model_list;
    Context context;

    public OrderAdapter(Context context, List<Model> model_list) {
        this.context = context;
        this.model_list = model_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int view_type) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name_of_drink = model_list.get(position).get_drink_name(),
                desc_of_drink = model_list.get(position).get_drink_detail();
        int img = model_list.get(position).get_drink_photo();

        holder.drink_name.setText(name_of_drink);
        holder.drink_description.setText(desc_of_drink);
        holder.img_view.setImageResource(img);
    }

    @Override
    public int getItemCount() {
        return model_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView drink_name, drink_description;
        ImageView img_view;

        public ViewHolder(View itemView) {
            super(itemView);
            drink_name = itemView.findViewById(R.id.coffeeName);
            drink_description = itemView.findViewById(R.id.description);
            img_view = itemView.findViewById(R.id.coffeeImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            if (position == 0){
                Intent i = new Intent(context, InfoActivity.class);
                context.startActivity(i);
            }

            if (position == 1){
                Intent i = new Intent(context, Latte.class);
                context.startActivity(i);
            }
        }
    }
}
