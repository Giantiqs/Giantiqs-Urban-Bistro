package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.CartListAdaptor;
import com.example.test.bistro_classes.bistro_domains.OrderDomain;
import com.example.test.bistro_database.DBUrbanBistro;
import com.example.test.bistro_database.helper.ManagementCart;

import java.util.ArrayList;

public class CartList extends AppCompatActivity {

    private RecyclerView recycler_view_list;
    private ManagementCart management_cart;
    TextView total_fee_text, total_text, empty_text, go_back, confirmOrder;
    private ScrollView scroll;
    DBUrbanBistro db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_cart_list);

        management_cart = new ManagementCart(this);
        recycler_view_list = findViewById(R.id.cart_recycler);
        total_fee_text = findViewById(R.id.total_items);
        total_text = findViewById(R.id.total_fee);
        //empty_text = findViewById(R.id.empty_text);
        scroll = findViewById(R.id.cart_scroll);
        recycler_view_list = findViewById(R.id.cart_recycler);
        go_back = findViewById(R.id.back_cart);
        confirmOrder = findViewById(R.id.confirm_order);
        db = new DBUrbanBistro(this);

        go_back.setOnClickListener(v -> startActivity(new Intent(CartList.this, MainMenu.class)));

        init_list();
        calc_cart();

        if (management_cart.get_list_cart().isEmpty()) {
            confirmOrder.setOnClickListener(v -> Toast.makeText(this, "Your cart is empty.", Toast.LENGTH_SHORT).show());
        } else {
            confirmOrder.setOnClickListener(v -> {

                ArrayList<OrderDomain> orderDomains = new ArrayList<>();
                Intent intent = new Intent(this, WaitingOrder.class);
                Bundle bundle = new Bundle();

                for (int i = 0; i < management_cart.get_list_cart().size(); i++) {
                    String productName = management_cart.get_list_cart().get(i).getTitle();
                    int quantity = management_cart.get_list_cart().get(i).getNum_in_cart();
                    Double fee = management_cart.get_list_cart().get(i).getFee() * management_cart.get_list_cart().get(i).getNum_in_cart();

                    OrderDomain orderDomain = new OrderDomain(productName, quantity, fee);
                    orderDomains.add(orderDomain);
                }

                bundle.putSerializable("orders", orderDomains);
                intent.putExtras(bundle);
                startActivity(intent);

            });
        }

    }

    private void init_list() {

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_view_list.setLayoutManager(llm);
        RecyclerView.Adapter<CartListAdaptor.ViewHolder> adapter = new CartListAdaptor(management_cart.get_list_cart(), this, this::calc_cart);

        recycler_view_list.setAdapter(adapter);
    }

    @SuppressLint("SetTextI18n")
    private void calc_cart() {

        double total = Math.round((management_cart.get_total_fee()) * 100) / 100,
                item_total = Math.round((management_cart.get_total_fee() * 100) / 100);

        total_fee_text.setText("P " + item_total);
        total_text.setText("P" + total);
    }

}