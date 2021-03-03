package org.techtown.myapplication;

public class Review {
    String review;
    float rating;
    String date;

    public Review(String review, float rating, String date) {
        this.review = review;
        this.rating = rating;
        this.date = date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
