package com.example.test.testers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.R;

public class test_signin extends AppCompatActivity {

    EditText username_signin, password_signin;
    Button button_signin, delete;
    DBBistro db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_test_signin);

        username_signin = findViewById(R.id.username_signin);
        password_signin = findViewById(R.id.password_signin);
        button_signin = findViewById(R.id.button_signin);
        delete = findViewById(R.id.delete_signin);
        db = new DBBistro(this);

        button_signin.setOnClickListener(view -> {

            String username = username_signin.getText().toString(), password = password_signin.getText().toString();

            if (username.isEmpty() || password.isEmpty())
                Toast.makeText(test_signin.this, "enter smth", Toast.LENGTH_LONG).show();
            else{
                boolean checkuserpass = db.check_user_password(username, password);
                if (checkuserpass){
                    Toast.makeText(test_signin.this, "signed in", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(test_signin.this, "sign in failed", Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(view -> db.delete_all());
    }
}