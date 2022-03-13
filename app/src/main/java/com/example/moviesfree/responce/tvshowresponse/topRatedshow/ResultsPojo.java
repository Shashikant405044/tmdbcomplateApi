package com.example.moviesfree.responce.tvshowresponse.topRatedshow;

import com.google.gson.annotations.SerializedName;

public class ResultsPojo {

    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("release_date")
    String release_date;

    @SerializedName("title")
    String title;

    @SerializedName("vote_average")
    String vote_average;


    @SerializedName("overview")
    String overview;

    @SerializedName("poster_path")
    String poster_path;

    @SerializedName("vote_count")
    String vote_count;

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getVote_count() {
        return vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
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
}
