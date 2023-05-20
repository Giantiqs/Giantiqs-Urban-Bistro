package com.example.test.bistro_activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;
import com.example.test.bistro_database.DBUrbanBistro;

public class LoginActivity extends AppCompatActivity {

    EditText username_login, password_login;
    Button login_button, go_back_button;
    DBUrbanBistro db;
    public static String preference_name = "this_file";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_login);

        username_login = findViewById(R.id.username_logina);
        password_login = findViewById(R.id.password_logina);
        login_button = findViewById(R.id.button_logina);
        go_back_button = findViewById(R.id.go_back);
        TextView clickable_txt_view = findViewById(R.id.text_logina);
        String clickable = "Don't have an account? Sign up";
        SpannableString spannable_str = new SpannableString(clickable);
        db = new DBUrbanBistro(LoginActivity.this);

        ClickableSpan sign_up = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                Intent i = new Intent(LoginActivity.this, MainMenu.class);
                startActivity(i);
            }
        };

        spannable_str.setSpan(sign_up, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        clickable_txt_view.setText(spannable_str);
        clickable_txt_view.setMovementMethod(LinkMovementMethod.getInstance());

        login_button.setOnClickListener(view -> {

            String username = username_login.getText().toString(), password = password_login.getText().toString();

            if (username.isEmpty() || password.isEmpty())
                Toast.makeText(LoginActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
            else{
                boolean check_user_password = db.check_user_password(username, password);
                if (check_user_password){
                    SharedPreferences sp = getSharedPreferences(LoginActivity.preference_name, 0);
                    SharedPreferences.Editor editor = sp.edit();
                    Intent i = new Intent(LoginActivity.this, MainMenu.class);

                    editor.putBoolean("logged_in", true);
                    editor.apply();

                    UserAdapter.userNow = username;

                    i.putExtra("username", username);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Sign in failed", Toast.LENGTH_LONG).show();
                }
            }

        });

        go_back_button.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, MainMenu.class)));
    }

}