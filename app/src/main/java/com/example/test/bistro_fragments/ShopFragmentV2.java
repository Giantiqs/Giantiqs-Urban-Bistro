package com.example.test.bistro_fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.bistro_activities.CartList;
import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.CategoryAdaptor;
import com.example.test.bistro_classes.bistro_adaptors.ItemAdaptor;
import com.example.test.bistro_classes.bistro_domains.CategoryDomain;
import com.example.test.bistro_classes.bistro_domains.ItemDomain;

import java.util.ArrayList;

public class ShopFragmentV2 extends Fragment {

    RecyclerView recycler_view_categories_list, recycler_view_popular_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bistro_shop_v2, container, false);

        recycler_view_category(view);
        recycler_view_popular(view);
        recycler_view_coffee(view);
        recycler_view_frappe(view);
        recycler_view_pizza(view);
        recycler_view_pastries(view);

        return view;
    }

    private void recycler_view_category(View view) {

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view_categories_list = view.findViewById(R.id.recycler_view_1st);
        recycler_view_categories_list.setLayoutManager(llm);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Frappe", "cappuccino"));
        category.add(new CategoryDomain("Coffee", "tea"));
        category.add(new CategoryDomain("Pizza", "pizza"));
        category.add(new CategoryDomain("Pastries", "cat_5"));

        RecyclerView.Adapter<CategoryAdaptor.ViewHolder> adapter = new CategoryAdaptor(category);
        recycler_view_categories_list.setAdapter(adapter);
    }

    private void recycler_view_popular(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view_popular_list = view.findViewById(R.id.recycler_view_2nd);
        recycler_view_popular_list.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Coffee", "kopi", "meow", 90.00));
        foods.add(new ItemDomain("Donutnut", "donutnut", "meow", 30.00));
        foods.add(new ItemDomain("Pepperoni", "one_pizza", "meow", 150.00));
        foods.add(new ItemDomain("Frappe", "cappuccino", "meow", 120.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_popular_list.setAdapter(adapter);
    }

    private void recycler_view_coffee(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view_popular_list = view.findViewById(R.id.recycler_view_3rd);
        recycler_view_popular_list.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Coffee 1", "kopi", "meow", 90.00));
        foods.add(new ItemDomain("Coffee 2", "kopi", "meow", 90.00));
        foods.add(new ItemDomain("Coffee 3", "kopi", "meow", 95.00));
        foods.add(new ItemDomain("Coffee 4", "kopi", "meow", 80.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_popular_list.setAdapter(adapter);
    }

    private void recycler_view_frappe(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view_popular_list = view.findViewById(R.id.recycler_view_4th);
        recycler_view_popular_list.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Frappe 1", "cappuccino", "meow", 120.00));
        foods.add(new ItemDomain("Frappe 2", "cappuccino", "meow", 135.00));
        foods.add(new ItemDomain("Frappe 3", "cappuccino", "meow", 195.00));
        foods.add(new ItemDomain("Frappe 4", "cappuccino", "meow", 150.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_popular_list.setAdapter(adapter);
    }

    private void recycler_view_pizza(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view_popular_list = view.findViewById(R.id.recycler_view_6th);
        recycler_view_popular_list.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Pepperoni", "one_pizza", "meow", 150.00));
        foods.add(new ItemDomain("Salami", "salami_pizza", "meow", 170.00));
        foods.add(new ItemDomain("Whole Pepperoni", "whole_pizza", "meow", 630.00));
        foods.add(new ItemDomain("Whole Salami", "whole_pizza", "meow", 670.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_popular_list.setAdapter(adapter);
    }

    private void recycler_view_pastries(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view_popular_list = view.findViewById(R.id.recycler_view_7th);
        recycler_view_popular_list.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Hanukkah Donut", "hdonut", "meow", 30.00));
        foods.add(new ItemDomain("Croissant", "croissant", "meow", 30.00));
        foods.add(new ItemDomain("Donutnut", "donutnut", "meow", 15.00));
        foods.add(new ItemDomain("Baguette", "baguette", "meow", 20.00));
        foods.add(new ItemDomain("Brezel", "brezel", "meow", 15.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_popular_list.setAdapter(adapter);
    }

}