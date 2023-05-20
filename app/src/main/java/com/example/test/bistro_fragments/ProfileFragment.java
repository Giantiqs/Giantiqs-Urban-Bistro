package com.example.test.bistro_fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.bistro_database.DBUrbanBistro;
import com.example.test.bistro_activities.LoginActivity;
import com.example.test.R;

public class ProfileFragment extends Fragment {

    TextView username_profile, first_name_profile, middle_name_profile, last_name_profile,
             password_profile, verify_password_profile, email_address_profile,
             phone_number_profile;
    Button register_profile;
    DBUrbanBistro db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view_profile = inflater.inflate(R.layout.bistro_profile, container, false);

        username_profile = view_profile.findViewById(R.id.username_profile);
        first_name_profile = view_profile.findViewById(R.id.first_name_profile);
        middle_name_profile = view_profile.findViewById(R.id.middle_name_profile);
        last_name_profile = view_profile.findViewById(R.id.last_name_profile);
        password_profile = view_profile.findViewById(R.id.password_profile);
        verify_password_profile = view_profile.findViewById(R.id.verify_password_profile);
        email_address_profile = view_profile.findViewById(R.id.email_address_profile);
        phone_number_profile = view_profile.findViewById(R.id.phone_number_profile);
        register_profile = view_profile.findViewById(R.id.register_profile);
        db = new DBUrbanBistro(getActivity());

        TextView clickable_txt_view = view_profile.findViewById(R.id.clickable_text_profile);
        String clickable = "Have an account? Login";
        SpannableString spannable_str = new SpannableString(clickable);

        ClickableSpan login = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        };

        spannable_str.setSpan(login, 17, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        clickable_txt_view.setText(spannable_str);
        clickable_txt_view.setMovementMethod(LinkMovementMethod.getInstance());

        register_profile.setOnClickListener(view -> {

            String username = username_profile.getText().toString(),
                    firstname = first_name_profile.getText().toString(),
                    middle_name = middle_name_profile.getText().toString(),
                    lastname = last_name_profile.getText().toString(),
                    password = password_profile.getText().toString(),
                    verify_password = verify_password_profile.getText().toString(),
                    email = email_address_profile.getText().toString(),
                    phone_number = phone_number_profile.getText().toString();

            if (username.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || (password.isEmpty() && verify_password.isEmpty()) || phone_number.isEmpty()){
                Toast.makeText(getActivity(), "Please enter your details", Toast.LENGTH_LONG).show();
            }else{
                if (has_capital_letter(password)){
                    if (has_num(password)){
                        if (has_white_space(password)){
                            if (password.equals(verify_password)){
                                if (!db.check_username(username)){
                                    if (db.register(username, firstname, middle_name, lastname, password, email, phone_number)){
                                        Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(getActivity(), LoginActivity.class));
                                    }
                                }else{
                                    Toast.makeText(getActivity(), "The username is already taken", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(getActivity(), "Password did not match", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getActivity(), "Password must not contain a space", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getActivity(), "The username must contain at least one number", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Password must contain at least one capital letter", Toast.LENGTH_LONG).show();
                }

            }

            });

        return view_profile;
    }

    static public boolean has_capital_letter(String password) {

        for (int x = 0; x < password.length(); x++){
            if (Character.isUpperCase(password.charAt(x))){
                return true;
            }
        }
        return false;
    }

    static public boolean has_num(String password) {

        for (int x = 0; x < password.length(); x++){
            if (Character.isDigit(password.charAt(x))){
                return true;
            }
        }
        return false;
    }

    static public boolean has_white_space(String password) {

        for (int x = 0; x < password.length(); x++) {
            if(password.charAt(x) == ' '){
                return false;
            }
        }
        return true;
    }

}