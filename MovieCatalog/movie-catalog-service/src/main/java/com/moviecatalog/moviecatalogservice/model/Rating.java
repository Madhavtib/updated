package com.moviecatalog.moviecatalogservice.model;

public class Rating {

    private long ratingId;
    private String movieId;
    private String userId;
    private String rating;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Rating() {
    }

    public Rating(String movieId, String userId, String rating) {
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    
    
}