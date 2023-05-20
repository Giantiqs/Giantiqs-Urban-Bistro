package com.example.test.dump;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagementCartTwo {

    private Context context;
    private TinyDBTwo tinyDBTwo;

    public ManagementCartTwo(Context context) {
        this.context = context;
        this.tinyDBTwo = new TinyDBTwo(context);
    }

    public void insert_item(RewardsDomain item) {
        ArrayList<RewardsDomain> listItems = getListCart();
        boolean existAlready = false;

        int n = 0;

        for (int i = 0; i < listItems.size(); i++){
            if (listItems.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready)
            listItems.get(n).setNumberInCart(item.getNumberInCart());
        else
            listItems.add(item);

        tinyDBTwo.putListObject("CartList", listItems);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<RewardsDomain> getListCart() {
        return tinyDBTwo.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<RewardsDomain> listRewards, int position, ChangeNumberItemListenerTwo changeNumberItemListenerTwo) {

        listRewards.get(position).setNumberInCart(listRewards.get(position).getNumberInCart() + 1);
        tinyDBTwo.putListObject("CartList", listRewards);
    }

    public void minusNumberFood(ArrayList<RewardsDomain> listRewards, int position, ChangeNumberItemListenerTwo changeNumberItemListenerTwo) {

        if (listRewards.get(position).getNumberInCart() == 1)
            listRewards.remove(position);
        else
            listRewards.get(position).setNumberInCart(listRewards.get(position).getNumberInCart() - 1);

        tinyDBTwo.putListObject("CartList", listRewards);
        changeNumberItemListenerTwo.changedTwo();
    }

    public Double getTotalFee() {
        ArrayList<RewardsDomain> listrewards = getListCart();
        double fee = 0;

        for (int i = 0; i < listrewards.size(); i++){
            fee = fee + (listrewards.get(i).getFee() * listrewards.get(i).getNumberInCart());
        }

        return fee;
    }
}
