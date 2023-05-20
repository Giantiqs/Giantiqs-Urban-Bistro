package com.example.test.testers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.CategoryAdaptor;
import com.example.test.bistro_classes.bistro_domains.CategoryDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_main_test);

        recycler_view_category();
    }
//can be removed and transferred to oncreate
    private void recycler_view_category() {
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recycler_view_categories_list = findViewById(R.id.recycler_view_1st);
        recycler_view_categories_list.setLayoutManager(llm);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Coffee", "cat_1"));
        category.add(new CategoryDomain("Coffee", "cat_1"));
        category.add(new CategoryDomain("Coffee", "cat_1"));
        category.add(new CategoryDomain("Coffee", "cat_1"));
        category.add(new CategoryDomain("Coffee", "cat_1"));

        RecyclerView.Adapter<CategoryAdaptor.ViewHolder> adapter = new CategoryAdaptor(category);
        recycler_view_categories_list.setAdapter(adapter);
    }

}