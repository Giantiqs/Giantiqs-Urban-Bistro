package com.example.test.bistro_activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.test.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class QRScanner extends AppCompatActivity {

    Button scan_button, go_back_qr, myCode;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_scanner);

        scan_button = findViewById(R.id.button_qr);
        go_back_qr = findViewById(R.id.back_qr);
        myCode = findViewById(R.id.myQRCode);

        scan_button.setOnClickListener(view -> scanCode());
        myCode.setOnClickListener(view -> startActivity(new Intent(this, QRCodeActivity.class)));
        go_back_qr.setOnClickListener(view -> startActivity(new Intent(this, MainMenu.class)));
    }

    private void scanCode() {

        ScanOptions opt = new ScanOptions();
        opt.setPrompt("Volume up to flash on");
        opt.setBeepEnabled(true);
        opt.setOrientationLocked(true);
        opt.setCaptureActivity(CaptureAct.class);
        bar_launcher.launch(opt);
    }

    ActivityResultLauncher<ScanOptions> bar_launcher = registerForActivityResult(new ScanContract(), result -> {

        if (result.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("k", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
    });
}