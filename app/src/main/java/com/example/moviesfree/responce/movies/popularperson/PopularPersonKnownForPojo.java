package com.example.moviesfree.responce.movies.popularperson;

import com.google.gson.annotations.SerializedName;

public class PopularPersonKnownForPojo {


    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("overview")
    private String overView;

    @SerializedName("poster_path")
    private String PosterPath;

    @SerializedName("release_date")
    private String ReleaseDate;

    @SerializedName("media_type")
    private String MediaType;

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOverView() {
        return overView;
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public String getMediaType() {
        return MediaType;
    }
}
