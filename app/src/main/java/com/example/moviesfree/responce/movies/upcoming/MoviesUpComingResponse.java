package com.example.moviesfree.responce.movies.upcoming;

import com.example.moviesfree.responce.tvshowresponse.BackDropPojo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesUpComingResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<MoviesResultUpcomingPojo> moviesUpComingResponseList;

    public int getPage() {
        return page;
    }

    public List<MoviesResultUpcomingPojo> getMoviesUpComingResponseList() {
        return moviesUpComingResponseList;
    }
}

