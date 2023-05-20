package com.example.test.testers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.R;

public class mainact extends AppCompatActivity {

    private TextView not_matched;
    private TextView less_than_ten;
    private TextView has_number;
    private TextView has_white_space;
    private TextView empty_pass;
    private TextView empty_num;
    private TextView empty_name;
    private EditText first_name, middle_name, last_name, password, verify_password, email_address, phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_main);

        Button button = findViewById(R.id.input_button);
        not_matched = findViewById(R.id.passNotMatched);
        less_than_ten = findViewById(R.id.passLessThan);
        has_number = findViewById(R.id.containsNumber);
        has_white_space = findViewById(R.id.containsWhiteSpace);
        TextView has_special_character = findViewById(R.id.containsSPChar);
        empty_pass = findViewById(R.id.isEmpty);
        empty_num = findViewById(R.id.numIsEmpty);
        empty_name = findViewById(R.id.nameIsEmpty);
        first_name = findViewById(R.id.fName);
        middle_name = findViewById(R.id.mName);
        last_name = findViewById(R.id.lName);
        password = findViewById(R.id.register_pass);
        verify_password = findViewById(R.id.verify_register_pass);
        email_address = findViewById(R.id.emailAdr);
        phone_number = findViewById(R.id.phoneNum);

        button.setOnClickListener(view -> {

            String email_address_str = email_address.getText().toString(), phone_number_str = phone_number.getText().toString(),
                    first_name_str = first_name.getText().toString(), middle_name_str = middle_name.getText().toString(),
                    last_name_str = last_name.getText().toString();

            if (!(first_name_str.isEmpty() && middle_name_str.isEmpty() && last_name_str.isEmpty())){
                if (!(password.getText().toString().isEmpty())) {
                    if (password.getText().toString().equals(verify_password.getText().toString())) {
                        if (password.getText().toString().length() >= 10) {
                            if (check_num(password.getText().toString())) {
                                if (!(check_white_space(password.getText().toString()))){
                                    if (!(phone_number.getText().toString().isEmpty())){
                                        successful_registration(first_name_str, middle_name_str, last_name_str, email_address_str, phone_number_str);
                                    }
                                    else {
                                        empty_num.setText("Phone Number is required.");
                                    }
                                }
                                else {
                                    has_white_space.setText("Password must not contain white space");
                                }
                            }
                            else {
                                has_number.setText("Password must have at least 1 number");
                            }
                        }
                        else {
                            less_than_ten.setText("Password is less than 10");
                        }
                    }
                    else {
                        not_matched.setText("Password Not matched");
                    }
                }
                else {
                    empty_pass.setText("Password is empty");
                }
            }
            else {
                empty_name.setText("Please enter your name");
            }
        });
    }

    public boolean check_num(String str) {

        for (int x = 0; x < str.length(); x++){
            if (Character.isDigit(str.charAt(x))){
                return true;
            }
        }

        return false;
    }

    public boolean check_white_space(String str) {

        for (int x = 0; x < str.length(); x++) {
            if(str.charAt(x) == ' '){
                return true;
            }
        }

        return false;
    }

    public void successful_registration(String first_name, String middle_name, String last_name, String email_address, String phone_number) {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("key_first_name", first_name);
        i.putExtra("key_middle_name", middle_name);
        i.putExtra("key_last_name", last_name);
        i.putExtra("key_email_address", email_address);
        i.putExtra("key_phone_number", phone_number);
        startActivity(i);
    }

}