package com.example.test.dump;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.bistro_activities.MainMenu;

public class RewardsCart extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCartTwo managementCartTwo;
    TextView totalFeeTxt, emptyTxt, goBack;
    private ScrollView scrollView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards_cart);

        managementCartTwo = new ManagementCartTwo(this);
        recyclerViewList = findViewById(R.id.rewards_recycler);
        totalFeeTxt = findViewById(R.id.totalFeeTxtR);
        emptyTxt = findViewById(R.id.emptyText);
        scrollView = findViewById(R.id.rewards_scroll);
        goBack = findViewById(R.id.back_cart_re);

        initList();
        calculateCart();

        goBack.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));
    }

    private void initList() {
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(llm);
        adapter = new RewardsCartAdapter(managementCartTwo.getListCart(), this, new ChangeNumberItemListenerTwo() {
            @Override
            public void changedTwo() {
                calculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);

        if (managementCartTwo.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCart() {

        double itemTotal = Math.round(managementCartTwo.getTotalFee() * 100)/100;

        totalFeeTxt.setText(itemTotal + "points");
    }

}