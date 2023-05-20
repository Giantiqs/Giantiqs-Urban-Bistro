package com.example.test.bistro_fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.ItemAdaptor;
import com.example.test.bistro_classes.bistro_domains.ItemDomain;

import java.util.ArrayList;

public class RewardsFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bistro_rewards, container, false);

        recycler_view_hoodie(view);
        recycler_view_shirt(view);
        recycler_view_mugs(view);

        return view;
    }

    private void recycler_view_hoodie(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recycler_view_hoodie = view.findViewById(R.id.recycler_view_one);
        recycler_view_hoodie.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Hoodie 1", "hoodeh", "meow", 350.00));
        foods.add(new ItemDomain("Hoodie 2", "hoodeh", "meow", 500.00));
        foods.add(new ItemDomain("Hoodie 3", "hoodeh", "meow", 100000.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_hoodie.setAdapter(adapter);
    }

    private void recycler_view_shirt(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recycler_view_shirt = view.findViewById(R.id.recycler_view_two);
        recycler_view_shirt.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Shirt 1", "shirt", "meow", 350.00));
        foods.add(new ItemDomain("Shirt 2", "shirt", "meow", 500.00));
        foods.add(new ItemDomain("Shirt 3", "shirt", "meow", 400.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_shirt.setAdapter(adapter);
    }

    private void recycler_view_mugs(View view){

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recycler_view_mugs = view.findViewById(R.id.recycler_view_three);
        recycler_view_mugs.setLayoutManager(llm);

        ArrayList<ItemDomain> foods = new ArrayList<>();
        foods.add(new ItemDomain("Mug 1", "mugmug", "meow", 50.00));
        foods.add(new ItemDomain("Mug 2", "mugmug", "meow", 45.00));
        foods.add(new ItemDomain("Mug 3", "mugmug", "meow", 45.00));

        RecyclerView.Adapter<ItemAdaptor.ViewHolder> adapter = new ItemAdaptor(foods);
        recycler_view_mugs.setAdapter(adapter);
    }

}