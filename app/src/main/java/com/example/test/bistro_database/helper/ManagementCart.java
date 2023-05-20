package com.example.test.bistro_database.helper;

import android.content.Context;
import android.widget.Toast;

import com.example.test.bistro_classes.bistro_domains.ItemDomain;
import com.example.test.bistro_interfaces.ChangeNumberItemListener;

import java.util.ArrayList;

public class ManagementCart {

    private final Context context;
    private final TinyDB db;

    public ManagementCart(Context context) {
        this.context = context;
        this.db = new TinyDB(context);
    }

    public void insert_food(ItemDomain item) {

        ArrayList<ItemDomain> foods = get_list_cart();
        boolean exists_already = false;

        int n = 0;

        for (int i = 0; i < foods.size(); i++){
            if (foods.get(i).getTitle().equals(item.getTitle())){
                exists_already = true;
                n = 1;
                break;
            }

        }

        if (exists_already)
            foods.get(n).setNum_in_cart(item.getNum_in_cart());
        else
            foods.add(item);

        db.putListObject("CartList", foods);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ItemDomain> get_list_cart(){
        return db.getListObject("CartList");
    }

    public void plus_num_food(ArrayList<ItemDomain> list_food, int position, ChangeNumberItemListener changed_number_item_listener){

        list_food.get(position).setNum_in_cart(list_food.get(position).getNum_in_cart() + 1);
        db.putListObject("CartList", list_food);
        changed_number_item_listener.changed();
    }

    public void minus_num_food(ArrayList<ItemDomain> list_food, int position, ChangeNumberItemListener changed_number_item_listener){

        if (list_food.get(position).getNum_in_cart() == 1)
            list_food.remove(position);
        else
            list_food.get(position).setNum_in_cart(list_food.get(position).getNum_in_cart() - 1);

        db.putListObject("CartList", list_food);
        changed_number_item_listener.changed();
    }

    public Double get_total_fee(){

        ArrayList<ItemDomain> list_food = get_list_cart();
        double fee = 0;

        for (int i = 0; i < list_food.size(); i++){
            fee = fee + (list_food.get(i).getFee() * list_food.get(i).getNum_in_cart());
        }

        return fee;
    }
}
