package com.example.test.testers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class InfoActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    ImageView img;
    ImageButton plus, minus;
    TextView quantity, drink_name, price;
    Button add_to_cart, go_back_info;
    int quantity_i;
    public Uri curr_cart_uri;
    boolean has_all_req_vals = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_info);

        img = findViewById(R.id.image_view_info);
        plus = findViewById(R.id.add_quantity);
        minus = findViewById(R.id.sub_quantity);
        quantity = findViewById(R.id.quantity);
        drink_name = findViewById(R.id.drink_name_info);
        price = findViewById(R.id.coffee_price);
        add_to_cart = findViewById(R.id.add_to_cart);
        go_back_info = findViewById(R.id.back_info);

        drink_name.setText("Green Tea");

        plus.setOnClickListener(view -> {
            int base_price = 90, coffee_price;
            quantity_i++;
            displayQuantity();
            coffee_price = base_price * quantity_i;
            String set_new_price = String.valueOf(coffee_price);
            price.setText(set_new_price);
        });

        minus.setOnClickListener(view -> {
            if (quantity_i == 0)
                Toast.makeText(InfoActivity.this, "Please no", Toast.LENGTH_SHORT).show();
            else {
                int base_price = 90, coffee_price;
                quantity_i--;
                displayQuantity();
                coffee_price = base_price * quantity_i;
                String set_new_price = String.valueOf(coffee_price);
                price.setText(set_new_price);
            }
        });

        add_to_cart.setOnClickListener(view -> {
            Toast.makeText(this, "Underdevelopment", Toast.LENGTH_SHORT).show();
        });

        go_back_info.setOnClickListener(view -> startActivity(new Intent(InfoActivity.this, OrderActivity.class)));
    }

    private void displayQuantity() {
        quantity.setText(String.valueOf(quantity_i));
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        drink_name.setText("");
        price.setText("");
        quantity.setText("");
    }
}