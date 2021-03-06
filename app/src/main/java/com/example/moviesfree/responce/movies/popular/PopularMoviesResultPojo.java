package com.example.moviesfree.responce.movies.popular;

import com.google.gson.annotations.SerializedName;

public class PopularMoviesResultPojo {

    @SerializedName("backdrop_path")
    private String BackDropPath;  //BackgroundPoster

    @SerializedName("original_language")
    private String OriginalLanguage;

    @SerializedName("original_title")
    private String OriginalTitle;

    @SerializedName("overview")
    private String OverView;

    @SerializedName("popularity")
    private double Popularity;

    @SerializedName("poster_path")
    private String PosterPath;         //PosterImage

    @SerializedName("release_date")
    private String ReleaseDate;

    @SerializedName("vote_average")
    private double VoteAverage;   //Rating

    @SerializedName("vote_count")
    private int VoteCount;

    public String getBackDropPath() {
        return BackDropPath;
    }

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
}
