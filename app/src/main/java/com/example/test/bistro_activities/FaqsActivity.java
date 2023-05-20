package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.test.R;
import com.example.test.bistro_activities.MainMenu;

public class FaqsActivity extends AppCompatActivity {

    Button back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        back = findViewById(R.id.goBackHome);

        back.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));
    }
}