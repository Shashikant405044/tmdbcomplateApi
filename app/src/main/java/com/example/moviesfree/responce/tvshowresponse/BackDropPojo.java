package com.example.moviesfree.responce.tvshowresponse;

import com.google.gson.annotations.SerializedName;

public class BackDropPojo {

    @SerializedName("backdrop_path")
    String backdrop_path;

    @SerializedName("first_air_date")
    String first_air_date;


    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("original_language")
    String original_language;


    @SerializedName("original_name")
    String original_name;

    @SerializedName("overview")
    String overview;

    @SerializedName("popularity")
    String popularity;

    @SerializedName("poster_path")
    String poster_path;

    @SerializedName("vote_average")
    String vote_average;

    @SerializedName("vote_count")
    String vote_count;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_name() {
        return original_name;
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

    public String getVote_average() {
        return vote_average;
    }

    public String getVote_count() {
        return vote_count;
    }
}
