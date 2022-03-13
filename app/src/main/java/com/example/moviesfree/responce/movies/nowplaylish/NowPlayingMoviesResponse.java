package com.example.moviesfree.responce.movies.nowplaylish;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowPlayingMoviesResponse {



    @SerializedName("page")
    private int PopularMoviesPage;

    @SerializedName("results")
    private List<NowPlayingMoviesResultsPojo> PopularMoviesResult;

    @SerializedName("total_pages")
    private int PopularMoviesTotalPages;

    @SerializedName("total_results")
    private int PopularMoviesTotalResults;


    public int getPopularMoviesPage() {
        return PopularMoviesPage;
    }

    public List<NowPlayingMoviesResultsPojo> getPopularMoviesResult() {
        return PopularMoviesResult;
    }

    public int getPopularMoviesTotalPages() {
        return PopularMoviesTotalPages;
    }

    public int getPopularMoviesTotalResults() {
        return PopularMoviesTotalResults;
    }
}
