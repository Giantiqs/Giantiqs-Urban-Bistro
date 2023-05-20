package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.dump.RewardsDomain;
import com.example.test.dump.ManagementCartTwo;

public class RewardsDetail extends AppCompatActivity {

    private TextView addToCartBtn, titelTxt, feeTxt, descriptionTxt, numberOrderTxt, cancelBtn;
    private ImageView plusBtn, minusBtn, picFood;
    private RewardsDomain objectTwo;
    int numberOrder = 1;
    private ManagementCartTwo managementCartTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards_detail);

        managementCartTwo = new ManagementCartTwo(this);
        init_view();
        get_bundle();

        cancelBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MainMenu.class));
        });
    }

    private void init_view(){

        addToCartBtn = findViewById(R.id.add_to_cart_re);
        titelTxt = findViewById(R.id.title_re);
        plusBtn = findViewById(R.id.plus_button_re);
        minusBtn = findViewById(R.id.minus_button_re);
        descriptionTxt = findViewById(R.id.desc_re);
        numberOrderTxt = findViewById(R.id.item_qty);
        picFood = findViewById(R.id.pic_re);
        feeTxt = findViewById(R.id.points_re);
        cancelBtn = findViewById(R.id.cancel_adding_rewards_re);
    }

    private void get_bundle(){

        objectTwo = (RewardsDomain) getIntent().getSerializableExtra("objectTwo");

        int drawableResourceId = this.getResources().getIdentifier(objectTwo.getPic(), "drawable", this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picFood);

        titelTxt.setText(objectTwo.getTitle());
        feeTxt.setText(objectTwo.getFee() + " points");
        descriptionTxt.setText(objectTwo.getDesc());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(v -> {
            numberOrder++;
            numberOrderTxt.setText(String.valueOf(numberOrder));
        });

        minusBtn.setOnClickListener(v -> {
            if (numberOrder > 1)
                numberOrder--;

            numberOrderTxt.setText(String.valueOf(numberOrder));
        });

        addToCartBtn.setOnClickListener(v -> {
            objectTwo.setNumberInCart(numberOrder);
            managementCartTwo.insert_item(objectTwo);
        });
    }
}