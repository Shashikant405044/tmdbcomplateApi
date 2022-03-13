package com.example.moviesfree.responce.movies.upcoming;

import com.google.gson.annotations.SerializedName;

public class MoviesResultUpcomingPojo {

    @SerializedName("adult")
    boolean adult;

    @SerializedName("backdrop_path")
    String backdrop_path;

    @SerializedName("id")
    int id;

    @SerializedName("original_language")
    String original_language;

    @SerializedName("original_title")
    String original_title;

    @SerializedName("overview")
    String overview;

    @SerializedName("popularity")
    String popularity;

    @SerializedName("poster_path")
    String poster_path;

    @SerializedName("release_date")
    String release_date;

    @SerializedName("title")
    String title;


    @SerializedName("vote_average")
    String vote_average;

    @SerializedName("vote_count")
    int vote_count;

    public boolean isAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }



    public int getId() {
        return id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }


    public String getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }
}
