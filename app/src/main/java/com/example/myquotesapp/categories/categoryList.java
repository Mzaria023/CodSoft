package com.example.myquotesapp.categories;

public class categoryList {

   private String catName;

    public String getCatName() {
        return catName;
    }

    public int getCatImage() {
        return catImage;
    }

    private int catImage;

    public categoryList(String catName, int catImage) {
        this.catName = catName;
        this.catImage = catImage;
    }
}
