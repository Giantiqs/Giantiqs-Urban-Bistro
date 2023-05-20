package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.bistro_classes.bistro_domains.ItemDomain;
import com.example.test.bistro_database.helper.ManagementCart;

public class ShowDetail extends AppCompatActivity {

    private TextView add_to_cart, title_txt, fee_text, desc_txt, order_qty;
    private ImageView plus, minus, food_pic;
    private ItemDomain object;
    int order_num = 1;
    private ManagementCart management_cart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_show_detail);

        add_to_cart = findViewById(R.id.add_to_cart_v2);
        title_txt = findViewById(R.id.title_txt);
        fee_text = findViewById(R.id.price_txt);
        desc_txt = findViewById(R.id.desc);
        order_qty = findViewById(R.id.order_qty);
        plus = findViewById(R.id.plus_button);
        minus = findViewById(R.id.minus_button);
        food_pic = findViewById(R.id.pic_show_details);
        TextView cancel_add = findViewById(R.id.cancel_adding);
        management_cart = new ManagementCart(this);

        get_bundle();

        cancel_add.setOnClickListener(v -> startActivity(new Intent(ShowDetail.this, MainMenu.class)));
    }

    @SuppressLint("SetTextI18n")
    private void get_bundle() {

        object = (ItemDomain) getIntent().getSerializableExtra("object");

        @SuppressLint("DiscouragedApi") int drawable_res = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this).load(drawable_res).into(food_pic);

        title_txt.setText(object.getTitle());
        fee_text.setText("P" + object.getFee());
        desc_txt.setText(object.getDescription());
        order_qty.setText(String.valueOf(order_num));

        plus.setOnClickListener(v -> {
            order_num++;
            order_qty.setText(String.valueOf(order_num));
        });

        minus.setOnClickListener(v -> {
            if (order_num > 1)
                order_num--;

            order_qty.setText(String.valueOf(order_num));
        });

        add_to_cart.setOnClickListener(v -> {
            object.setNum_in_cart(order_num);
            management_cart.insert_food(object);
        });

    }

}