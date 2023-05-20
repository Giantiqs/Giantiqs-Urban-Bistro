package com.example.test.dump;

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

import java.util.ArrayList;

public class RewardsCartAdapter extends RecyclerView.Adapter<RewardsCartAdapter.ViewHolder> {

    private final ArrayList<RewardsDomain> rewardsDomains;
    private final ManagementCartTwo managementCartTwo;
    private final ChangeNumberItemListenerTwo changeNumberItemListenerTwo;

    public RewardsCartAdapter(ArrayList<RewardsDomain> rewardsDomains, Context context, ChangeNumberItemListenerTwo changeNumberItemListenerTwo) {
        this.rewardsDomains = rewardsDomains;
        this.managementCartTwo = new ManagementCartTwo(context);
        this.changeNumberItemListenerTwo = changeNumberItemListenerTwo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bistro_viewholder_rewardscart, parent, false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(rewardsDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(rewardsDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((rewardsDomains.get(position).getNumberInCart() * rewardsDomains.get(position).getFee()) * 100) / 100));
        holder.num.setText(String.valueOf(rewardsDomains.get(position).getNumberInCart()));

        @SuppressLint("DiscouragedApi") int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(rewardsDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managementCartTwo.plusNumberFood(rewardsDomains, position, () -> {
            notifyDataSetChanged();
            changeNumberItemListenerTwo.changedTwo();
        }));

        holder.minusItem.setOnClickListener(v -> managementCartTwo.minusNumberFood(rewardsDomains, position, () -> {
            notifyDataSetChanged();
            changeNumberItemListenerTwo.changedTwo();
        }));
    }

    @Override
    public int getItemCount() {
        return rewardsDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, feeEachItem, totalEachItem, num;
        ImageView pic, plusItem, minusItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleRewards);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.picRewards);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plusRewards);
            minusItem = itemView.findViewById(R.id.minusRewards);
        }
    }
}
