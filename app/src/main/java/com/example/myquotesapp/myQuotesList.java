package com.example.myquotesapp;

public class myQuotesList {

    private String quote;
    private String author;

    private boolean isFavorite;

    public myQuotesList(String quote, String author) {
        this.quote = quote;
        this.author = author;
        this.isFavorite = isFavorite;

    }
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

}
