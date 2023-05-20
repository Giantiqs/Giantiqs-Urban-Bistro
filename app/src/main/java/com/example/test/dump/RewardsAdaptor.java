package com.example.test.dump;

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
import com.example.test.bistro_activities.RewardsDetail;

import java.util.ArrayList;

public class RewardsAdaptor extends RecyclerView.Adapter<RewardsAdaptor.ViewHolder> {

    ArrayList<RewardsDomain> rewards_domain;

    public RewardsAdaptor(ArrayList<RewardsDomain> rewards_domain) {
        this.rewards_domain = rewards_domain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bistro_viewholder_rewards, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(rewards_domain.get(position).getTitle());
        holder.fee.setText(String.valueOf(rewards_domain.get(position).getFee()));


        @SuppressLint("DiscouragedApi") int drawable_resource = holder.itemView.getContext().getResources().getIdentifier(rewards_domain.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawable_resource).into(holder.pic);

        holder.add_btn.setOnClickListener(v -> {
            Intent i = new Intent(holder.itemView.getContext(), RewardsDetail.class);
            i.putExtra("objectTwo", rewards_domain.get(position));
            holder.itemView.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return rewards_domain.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, fee, add_btn;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_r);
            fee = itemView.findViewById(R.id.fee_r);
            pic = itemView.findViewById(R.id.pics_r);
            add_btn = itemView.findViewById(R.id.add_button_r);
        }
    }
}
