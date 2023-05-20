package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.HistoryAdapter;
import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;
import com.example.test.bistro_classes.bistro_domains.HistoryDomain;
import com.example.test.bistro_database.DBUrbanBistro;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView listView;
    DBUrbanBistro db;
    ArrayList<HistoryDomain> arrayList;
    HistoryAdapter adapter;
    TextView totalSpent;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_activity_history);

        int sum;
        db = new DBUrbanBistro(this);
        listView = findViewById(R.id.historyList);
        totalSpent = findViewById(R.id.totalSpent);
        goBack = findViewById(R.id.goBack);

        goBack.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));

        showHistory();

        sum = getSpent();

        totalSpent.setText(String.valueOf(sum));
    }

    public void showHistory() {
        arrayList = db.getHistory(UserAdapter.userNow);
        adapter = new HistoryAdapter(this, arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private int getSpent() {

        int sum = 0;

        for (HistoryDomain add : arrayList) {
            sum+=add.getFee();
        }

        return sum;
    }

}