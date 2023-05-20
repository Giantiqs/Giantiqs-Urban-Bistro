package com.example.test.ui.slideshow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.bistro_database.DBUrbanBistro;
import com.example.test.R;

public class LoginFragment extends Fragment {
    EditText username_login, password_login;
    Button button_login;
    DBUrbanBistro db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_login = inflater.inflate(R.layout.fragment_login, container, false);

        username_login = view_login.findViewById(R.id.username_login);
        password_login = view_login.findViewById(R.id.password_login);
        button_login = view_login.findViewById(R.id.button_login);

        TextView text_login = view_login.findViewById(R.id.clickable_text_login);
        String clickable = "Don't have an account? Sign up";
        SpannableString spannable_str = new SpannableString(clickable);

        ClickableSpan sign_up = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(getActivity(), "Underdevelopment", Toast.LENGTH_LONG).show();
            }
        };

        spannable_str.setSpan(sign_up, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text_login.setText(spannable_str);
        text_login.setMovementMethod(LinkMovementMethod.getInstance());

        button_login.setOnClickListener(view -> {
            String username = username_login.getText().toString(), password = password_login.getText().toString();

            if (username.isEmpty() || password.isEmpty())
                Toast.makeText(getActivity(), "Fields are empty", Toast.LENGTH_LONG).show();
            else{
                boolean check = db.check_user_password(username, password);
                if (check){
                    Toast.makeText(getActivity(), "Signed in successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "User not found", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view_login;
    }

}