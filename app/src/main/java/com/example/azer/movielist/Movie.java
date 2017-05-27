package com.example.azer.movielist;

/**
 * Created by azeR on 5/22/2017.
 */

public class Movie {
    private String title, thumbonailurl;
    private int year;
    private double rating;

    public Movie() {
    }

    public Movie(String title, String thumbonailurl, int year, double rating) {
        this.title = title;
        this.thumbonailurl = thumbonailurl;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbonailurl() {
        return thumbonailurl;
    }

    public void setThumbonailurl(String thumbonailurl) {
        this.thumbonailurl = thumbonailurl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
