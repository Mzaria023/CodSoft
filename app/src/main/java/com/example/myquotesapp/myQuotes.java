package com.example.myquotesapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class myQuotes extends AppCompatActivity {
    private final List<myQuotesList> lists = new ArrayList<>();
    private ImageView favorite;
    private int currentQuoteIndex = 0;
    private TextView quotes_Tv,author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_quotes);

        final AppCompatButton backBtn = findViewById(R.id.backBtn);
        final AppCompatButton nextBtn = findViewById(R.id.nextBtn);
        quotes_Tv = findViewById(R.id.quotes);
        favorite = findViewById(R.id.favImg);
        final ImageView share= findViewById(R.id.shareImg);
        author = findViewById(R.id.autName);
        final TextView cat_Name = findViewById(R.id.catName);

        final String getCatName = getIntent().getStringExtra("Category Name");
        cat_Name.setText(getCatName);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuoteIndex > 0) {
                    currentQuoteIndex--;
                    displayQuote(currentQuoteIndex);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (currentQuoteIndex < lists.size() - 1) {
                        currentQuoteIndex++;
                        displayQuote(currentQuoteIndex);
                    }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuoteIndex >= 0 && currentQuoteIndex < lists.size()) {
                    String quoteText = lists.get(currentQuoteIndex).getQuote();
                    String shareText = "Check out this inspiring quote: " + quoteText;

                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    shareIntent.setType("text/plain");
                    startActivity(Intent.createChooser(shareIntent, "Share via"));
                }

            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuoteIndex >= 0 && currentQuoteIndex < lists.size()) {
                    myQuotesList quote = lists.get(currentQuoteIndex);
                    quote.setFavorite(!quote.isFavorite());
                    updateFavoriteIcon(quote.isFavorite());
                }
            }
        });
//switch statement to get the category
        switch (getCatName) {
            case "Love":
                lists.addAll(quotesList.Love());
                break;
            case "Success":
                lists.addAll(quotesList.Success());
                break;
            case "Inspiration":
                lists.addAll(quotesList.Inspiration());
                break;
            case "Motivation":
                lists.addAll(quotesList.Motivation());
                break;
            default:
                // Handle the case when the category is not recognized
                break;
        }

    }
    private void displayQuote(int index) {
        if (index >= 0 && index < lists.size()) {
            myQuotesList quote = lists.get(index);
            quotes_Tv.setText(quote.getQuote());
            author.setText(quote.getAuthor());
        } else {
            // Handle the case when the index is out of bounds
            quotes_Tv.setText("No quotes available");
            author.setText("");
        }
    }
    private void updateFavoriteIcon(boolean isFavorite) {
        if (isFavorite) {
            // Set favorite icon to filled state
            favorite.setImageResource(R.drawable.favorite);
        } else {
            // Set favorite icon to outline state
            favorite.setImageResource(R.drawable.baseline_favorite_border_24);
        }
    }
}