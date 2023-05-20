package com.example.test.bistro_fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.test.bistro_activities.MainMenu;
import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;
import com.example.test.bistro_database.DBUrbanBistro;
import com.example.test.bistro_classes.bistro_domains.UsersDomain;
import com.example.test.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ConstraintLayout shopNow, coffeeShop, register;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view_home = inflater.inflate(R.layout.bistro_home, container, false);

        shopNow = view_home.findViewById(R.id.rewardsShop);
        coffeeShop = view_home.findViewById(R.id.coffeeShop);
        register = view_home.findViewById(R.id.registerAcc);

        shopNow.setOnClickListener(v -> {
            Fragment frag = new RewardsFragment();
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frameLayout, frag);
            ft.addToBackStack(null);
            ft.commit();
        });

        coffeeShop.setOnClickListener(v -> {
            Fragment frag = new ShopFragmentV2();
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frameLayout, frag);
            ft.addToBackStack(null);
            ft.commit();
        });

        register.setOnClickListener(v -> {
            Fragment frag = new ProfileFragment();
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frameLayout, frag);
            ft.addToBackStack(null);
            ft.commit();
        });

        return view_home;
    }

}