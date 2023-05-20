package com.example.test.testers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.R;

//change default screen back to loading screen in manifest

public class test_signup extends AppCompatActivity {

    EditText username_signup, password_signup, verify_password_signup;
    Button button_signup, signin_signup;
    DBBistro db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_test_signup);

        username_signup = findViewById(R.id.username_signup);
        password_signup = findViewById(R.id.password_signup);
        verify_password_signup = findViewById(R.id.verify_pass_signup);
        button_signup = findViewById(R.id.button_signup);
        signin_signup = findViewById(R.id.button_signin_signup);
        db = new DBBistro(this);

        button_signup.setOnClickListener(view -> {

            String username = username_signup.getText().toString(), password = password_signup.getText().toString(),
                              verify_pass_signup = verify_password_signup.getText().toString();

            if (username.isEmpty() || password.isEmpty() || verify_pass_signup.isEmpty())
                Toast.makeText(test_signup.this, "meow", Toast.LENGTH_LONG).show();
            else{
                if(password.equals(verify_pass_signup)){
                    boolean checkuser = db.check_username(username);
                    if(!checkuser){
                        boolean insert = db.insert(username, password);
                        if(insert){
                            Toast.makeText(test_signup.this, "registered", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), test_signin.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(test_signup.this, "registration failed", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(test_signup.this, "user already exist.", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(test_signup.this, "password did not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        signin_signup.setOnClickListener(view -> {

            Intent i = new Intent(getApplicationContext(), test_signin.class);
            startActivity(i);
        });

    }
}