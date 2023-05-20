package com.example.test.testers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.test.bistro_activities.MainMenu;
import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    List<Model> model_list;
    RecyclerView recycler_view;
    OrderAdapter order_adapter;
    Button cancel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_order);

        cancel = findViewById(R.id.cancel_order);
        model_list = new ArrayList<>();
        recycler_view = findViewById(R.id.recyclerView);

        model_list.add(new Model("Green Tea", getString(R.string.greentea), R.drawable.greentea));
        model_list.add(new Model("Latte", getString(R.string.latte), R.drawable.latte));
        model_list.add(new Model("Orange Smoothie", getString(R.string.orangesmoothie), R.drawable.orange));
        model_list.add(new Model("Orange Vanilla", getString(R.string.orangevanilla), R.drawable.orangevanilla));
        model_list.add(new Model("Cappucino", getString(R.string.cappcuno), R.drawable.cappuccino));
        model_list.add(new Model("Thai Tea", getString(R.string.thaitea), R.drawable.thaitea));
        model_list.add(new Model("Tea", getString(R.string.tea), R.drawable.tea));
        model_list.add(new Model("Milk Tea", getString(R.string.bubbletea), R.drawable.milk));
        model_list.add(new Model("Matcha", getString(R.string.matcha), R.drawable.match));
        recycler_view.setLayoutManager(new LinearLayoutManager(null));
        order_adapter = new OrderAdapter(this, model_list);
        recycler_view.setAdapter(order_adapter);
        cancel.setOnClickListener(view -> startActivity(new Intent(this, MainMenu.class)));
    }
}