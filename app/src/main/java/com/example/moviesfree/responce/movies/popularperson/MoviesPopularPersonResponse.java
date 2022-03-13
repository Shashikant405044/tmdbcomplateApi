package com.example.moviesfree.responce.movies.popularperson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesPopularPersonResponse {


    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<PopularPersonResultsPojo> results;

    //Getters

    public int getPage() {
        return page;
    }

    public List<PopularPersonResultsPojo> getResults() {
        return results;
    }
}
