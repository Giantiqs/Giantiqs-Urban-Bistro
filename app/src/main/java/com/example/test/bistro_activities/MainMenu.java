package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.test.bistro_classes.MovableFloatingActionButton;
import com.example.test.R;

import com.example.test.bistro_fragments.ShopFragmentV2;
import com.example.test.bistro_fragments.HomeFragment;
import com.example.test.bistro_fragments.HelpFragment;
import com.example.test.bistro_fragments.LoggedInFragment;
import com.example.test.bistro_fragments.ProfileFragment;
import com.example.test.bistro_fragments.RewardsFragment;
import com.example.test.databinding.BistroMainMenuBinding;

public class MainMenu extends AppCompatActivity {

    BistroMainMenuBinding binding;
    MovableFloatingActionButton movable;

    @SuppressLint({"NonConstantResourceId", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_main_menu);

        binding = BistroMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        swap_frags(new HomeFragment());
        String username = getIntent().getStringExtra("username");

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.homeBotNav:
                    swap_frags(new HomeFragment());
                    break;
                case R.id.storeBotNav:
                    swap_frags(new ShopFragmentV2());
                    break;
                case R.id.rewardsBotNav:
                    swap_frags(new RewardsFragment());
                    break;
                case R.id.helpBotNav:
                    swap_frags(new HelpFragment());
                    break;
                case R.id.accountBotNav:
                    is_logged_in(username);
                    break;
            }

            return true;
        });

        movable = findViewById(R.id.moveable);
        movable.bringToFront();
        movable.setOnClickListener(v -> startActivity(new Intent(this, CartList.class)));

    }

    public void swap_frags(Fragment frag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, frag);
        ft.commit();
    }

    public void is_logged_in(String username){

        SharedPreferences sp = getSharedPreferences(LoginActivity.preference_name, 0);
        boolean logged_in = sp.getBoolean("logged_in", false);

        if (logged_in){
            Bundle data = new Bundle();
            data.putString("username", username);

            Fragment frag = new LoggedInFragment();
            frag.setArguments(data);

            swap_frags(frag);
        } else
            swap_frags(new ProfileFragment());

    }

}