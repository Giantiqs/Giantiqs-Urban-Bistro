package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;
import com.example.test.bistro_classes.bistro_domains.UsersDomain;
import com.example.test.bistro_database.DBUrbanBistro;
import com.example.test.bistro_fragments.ProfileFragment;

import java.util.ArrayList;

public class EditProfile extends AppCompatActivity {

    TextView username_edit, first_name_edit, middle_name_edit, last_name_edit,
            password_edit, email_address_edit, phone_number_edit;
    Button save_edit, cancel_edit;
    DBUrbanBistro db;
    ArrayList<UsersDomain> usersDomains;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_edit_profile);

        username_edit = findViewById(R.id.username_edit);
        first_name_edit = findViewById(R.id.first_name_edit);
        middle_name_edit = findViewById(R.id.middle_name_edit);
        last_name_edit = findViewById(R.id.last_name_edit);
        password_edit = findViewById(R.id.password_edit);
        email_address_edit = findViewById(R.id.email_address_edit);
        phone_number_edit = findViewById(R.id.phone_number_edit);
        save_edit = findViewById(R.id.save_edit);
        cancel_edit = findViewById(R.id.cancel_edit);
        db = new DBUrbanBistro(this);
        usersDomains = db.get_users();

        UsersDomain user = getUser(UserAdapter.userNow, usersDomains);

        username_edit.setText(user.getUsername());
        first_name_edit.setText(user.getFirstname());
        middle_name_edit.setText(user.getMiddle_name());
        last_name_edit.setText(user.getLastname());
        password_edit.setText(user.getPassword());
        email_address_edit.setText(user.getEmail());
        phone_number_edit.setText(user.getPhone_number());

        save_edit.setOnClickListener(view -> {

            String username = username_edit.getText().toString(),
                    firstname = first_name_edit.getText().toString(),
                    middlename = middle_name_edit.getText().toString(),
                    lastname = last_name_edit.getText().toString(),
                    password = password_edit.getText().toString(),
                    email = email_address_edit.getText().toString(),
                    phonenumber = phone_number_edit.getText().toString();

            if (username.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || password.isEmpty()|| phonenumber.isEmpty()){
                Toast.makeText(this, "Please enter your updates", Toast.LENGTH_LONG).show();
            }else{
                if (ProfileFragment.has_white_space(password)){
                    if (ProfileFragment.has_capital_letter(password)){
                        if (ProfileFragment.has_num(password)){

                            if (db.update(username, firstname, middlename, lastname, password, email, phonenumber)){
                                Toast.makeText(this, "Data updated", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(this, MainMenu.class));
                            }
                            else
                                Toast.makeText(this, "Data cannot be updated please recheck your details", Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(this, "Password should contain at least one number", Toast.LENGTH_LONG).show();
                    }else
                        Toast.makeText(this, "Password should contain at least one capital letter", Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(this, "Password should not contain spaces", Toast.LENGTH_LONG).show();
            }


        });
        cancel_edit.setOnClickListener(view -> startActivity(new Intent(this, MainMenu.class)));
    }

    public UsersDomain getUser(String username, ArrayList<UsersDomain> users) {

        int index = 0;

        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())){
                index = i;
                break;
            }
        }

        return users.get(index);
    }

}