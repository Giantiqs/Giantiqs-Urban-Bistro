package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.example.test.R;
import com.example.test.bistro_activities.MainMenu;
import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;
import com.example.test.bistro_classes.bistro_domains.OrderDomain;
import com.example.test.bistro_database.DBUrbanBistro;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class WaitingOrder extends AppCompatActivity {

    Button cancelOrder, orderReceived;
    ArrayList<OrderDomain> orderDomains;
    DBUrbanBistro db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_activity_waiting_order);

        db = new DBUrbanBistro(this);
        cancelOrder = findViewById(R.id.cancelOrder);
        orderReceived = findViewById(R.id.orderReceived);

        orderReceived.setOnClickListener(v -> {
            Bundle bundle = getIntent().getExtras();
            orderDomains = (ArrayList<OrderDomain>) bundle.getSerializable("orders");

            for (int i = 0; i < orderDomains.size(); i++) {
                String productName = orderDomains.get(i).getProductName();
                int quantity = orderDomains.get(i).getQuantity();
                Double fee = orderDomains.get(i).getFee();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    String username = UserAdapter.userNow;

                    if (Objects.equals(username, "")){
                        username = "Guest";
                    }

                    db.insertOrders(username, productName, quantity, String.valueOf(LocalDate.now()), String.valueOf(LocalTime.now()), fee);
                }
            }

            startActivity(new Intent(this, MainMenu.class));
        });

        cancelOrder.setOnClickListener(v -> {
            orderDomains = null;
            startActivity(new Intent(this, MainMenu.class));
        });
    }
}