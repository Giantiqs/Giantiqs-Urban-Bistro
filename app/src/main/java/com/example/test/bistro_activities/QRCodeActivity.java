package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.test.R;
import com.example.test.bistro_activities.MainMenu;

public class QRCodeActivity extends AppCompatActivity {

    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_activity_qrcode);

        goBack = findViewById(R.id.backQRCode);

        goBack.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));
    }
}