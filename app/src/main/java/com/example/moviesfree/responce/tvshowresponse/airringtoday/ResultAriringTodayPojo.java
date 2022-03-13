package com.example.moviesfree.responce.tvshowresponse.airringtoday;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultAriringTodayPojo {

    @SerializedName("backdrop_path")
    String backdrop_path;

    @SerializedName("first_air_date")
    String first_air_date;

    @SerializedName("genre_ids")
    List<Integer> genre_ids;

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("origin_country")
    List<String> origin_country;

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
    int vote_count;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getOrigin_country() {
        return origin_country;
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

    public int getVote_count() {
        return vote_count;
    }
}
