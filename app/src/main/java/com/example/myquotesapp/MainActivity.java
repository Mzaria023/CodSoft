package com.example.myquotesapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquotesapp.categories.catAdapter;
import com.example.myquotesapp.categories.categoryList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<categoryList> categoryLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView categories = findViewById(R.id.categoryView);

        categories.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        categories.setHasFixedSize(true);

        //add categories to list
        categoryList love = new categoryList("Love",R.drawable.love);
        categoryLists.add(love);

        categoryList success = new categoryList("Success",R.drawable.success);
        categoryLists.add(success);

        categoryList inspiration = new categoryList("Inspiration",R.drawable.inspire);
        categoryLists.add(inspiration);

        categoryList motivational = new categoryList("Motivation",R.drawable.motivation);
        categoryLists.add(motivational);

        //set adapter to view
        categories.setAdapter(new catAdapter(categoryLists,MainActivity.this));

    }
}