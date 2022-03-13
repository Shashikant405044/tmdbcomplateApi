package com.example.moviesfree.responce.movies.nowplaylish;

import com.google.gson.annotations.SerializedName;

public class NowPlayingMoviesResultsPojo {


    @SerializedName("original_language")
    private String OriginalLanguage;

    @SerializedName("original_title")
    private String OriginalTitle;

    @SerializedName("overview")
    private String OverView;

    @SerializedName("popularity")
    private double Popularity;

    @SerializedName("poster_path")
    private String PosterPath;

    @SerializedName("release_date")
    private String ReleaseDate;

    @SerializedName("vote_average")
    private double VoteAverage;

    @SerializedName("vote_count")
    private int VoteCount;

    @SerializedName("backdrop_path")
    private String BackdropPath;

    public String getOriginalLanguage() {
        return OriginalLanguage;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public String getOverView() {
        return OverView;
    }

    public double getPopularity() {
        return Popularity;
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public double getVoteAverage() {
        return VoteAverage;
    }

    public int getVoteCount() {
        return VoteCount;
    }

    public String getBackdropPath() {
        return BackdropPath;
    }
}
