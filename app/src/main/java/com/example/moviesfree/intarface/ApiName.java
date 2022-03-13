package com.example.moviesfree.intarface;

import com.example.moviesfree.responce.movies.nowplaylish.NowPlayingMoviesResponse;
import com.example.moviesfree.responce.movies.popular.MoviesPopularResponse;
import com.example.moviesfree.responce.movies.popularperson.MoviesPopularPersonResponse;
import com.example.moviesfree.responce.movies.upcoming.MoviesUpComingResponse;
import com.example.moviesfree.responce.people.PopulaerPersonResponse;
import com.example.moviesfree.responce.tvshowresponse.TvShowPopularResponse;
import com.example.moviesfree.responce.tvshowresponse.airringtoday.AiringToadyResponse;
import com.example.moviesfree.responce.tvshowresponse.topRatedshow.TopRatedShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiName {

    @GET("/3/person/popular")
    Call<PopulaerPersonResponse> popularPersonResponseGetData(@Query("api_key") String apikey);

    @GET("/3/tv/popular")
    Call<TvShowPopularResponse> tvShowPopularResponseData(@Query("api_key") String apikey);

    @GET("/3/movie/top_rated")
    Call<TopRatedShowResponse> toRatedResponseData(@Query("api_key")String apikey);

    @GET("/3/tv/airing_today")
    Call<AiringToadyResponse> tvShowAiringTodayData(@Query("api_key") String apikey);

     @GET("/3/movie/upcoming")
     Call<MoviesUpComingResponse> moviesUpComingResponseData(@Query("api_key")String apikey);

    @GET("/3/movie/popular")
    Call<MoviesPopularResponse>  moviesPopularResponseData(@Query("api_key")String apikey);

    @GET("/3/movie/now_playing")
    Call<NowPlayingMoviesResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("/3/person/popular")
    Call<MoviesPopularPersonResponse> moviesPopularPersonResponse(@Query("api_key") String apiKey);




}
