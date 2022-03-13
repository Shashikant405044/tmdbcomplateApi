package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.moviesfree.adapter.MoviesNowPlayingAdapter;
import com.example.moviesfree.adapter.MoviesPopulaerpersonAdapter;
import com.example.moviesfree.adapter.MoviesPopularAdapter;
import com.example.moviesfree.adapter.MoviesUpcomingAdapter;
import com.example.moviesfree.databinding.ActivityMoviesUpComingBinding;
import com.example.moviesfree.intarface.ApiName;
import com.example.moviesfree.responce.movies.nowplaylish.NowPlayingMoviesResponse;
import com.example.moviesfree.responce.movies.nowplaylish.NowPlayingMoviesResultsPojo;
import com.example.moviesfree.responce.movies.popular.MoviesPopularResponse;
import com.example.moviesfree.responce.movies.popular.PopularMoviesResultPojo;
import com.example.moviesfree.responce.movies.popularperson.MoviesPopularPersonResponse;
import com.example.moviesfree.responce.movies.popularperson.PopularPersonResultsPojo;
import com.example.moviesfree.responce.movies.upcoming.MoviesResultUpcomingPojo;
import com.example.moviesfree.responce.movies.upcoming.MoviesUpComingResponse;
import com.example.moviesfree.responce.people.PopulaerPersonResponse;
import com.example.moviesfree.utilitty.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesUpComingActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    ApiName  apiName = RetrofitApi.getInstance(ApiName.class);
    ActivityMoviesUpComingBinding binding;
    List<MoviesResultUpcomingPojo> moviesResultUpcomingPojos = new ArrayList<>();
    List<PopularMoviesResultPojo> popularMoviesResultPojos = new ArrayList<>();
    List<NowPlayingMoviesResultsPojo> nowPlayingMoviesResultsPojos = new ArrayList<>();
    List<PopularPersonResultsPojo> popularPersonResultsPojos = new ArrayList<>();
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoviesUpComingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        getUpcomingMovies();
        getPopularMovies();
        getMoviesNowPlayinglist();
        getpopulaerPerson();
        MoviesUpComingActivity.this.setTitle("Upcoming Movies");

        staggeredGridLayoutManager = new StaggeredGridLayoutManager( 1,StaggeredGridLayoutManager.HORIZONTAL);
        binding.mUpcomingRecyclarView.setLayoutManager(staggeredGridLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.mPopularRecyclarView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.nowPlayingRecyclarView.setLayoutManager(linearLayoutManager3);

        LinearLayoutManager person_popular = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.movPopularPRecyclarView.setLayoutManager(person_popular);


    }


    private void getUpcomingMovies() {
         Call<MoviesUpComingResponse> call = apiName.moviesUpComingResponseData(Utility.KEY);
         call.enqueue(new Callback<MoviesUpComingResponse>() {
             @Override
             public void onResponse(Call<MoviesUpComingResponse> call, Response<MoviesUpComingResponse> response) {
                progressDialog.dismiss();
                 moviesResultUpcomingPojos = response.body().getMoviesUpComingResponseList();
                 MoviesUpcomingAdapter moviesUpcomingAdapter = new MoviesUpcomingAdapter(MoviesUpComingActivity.this,moviesResultUpcomingPojos);
                 moviesUpcomingAdapter.notifyDataSetChanged();
                  binding.mUpcomingRecyclarView.setAdapter(moviesUpcomingAdapter);
             }
             @Override
             public void onFailure(Call<MoviesUpComingResponse> call, Throwable t) {
                 progressDialog.dismiss();
                 Log.d("Error",t.getMessage());

             }
         });
    }

    private void getPopularMovies() {
          Call<MoviesPopularResponse> call = apiName.moviesPopularResponseData(Utility.KEY);
          call.enqueue(new Callback<MoviesPopularResponse>() {
              @Override
              public void onResponse(Call<MoviesPopularResponse> call, Response<MoviesPopularResponse> response) {

                  popularMoviesResultPojos = response.body().getPopularMoviesResult();
                  MoviesPopularAdapter moviesPopularAdapter = new MoviesPopularAdapter(MoviesUpComingActivity.this,popularMoviesResultPojos);
                  moviesPopularAdapter.notifyDataSetChanged();
                  binding.mPopularRecyclarView.setAdapter(moviesPopularAdapter);
              }

              @Override
              public void onFailure(Call<MoviesPopularResponse> call, Throwable t) {

              }
          });
    }


    private void getMoviesNowPlayinglist() {

        Call<NowPlayingMoviesResponse> call = apiName.getNowPlayingMovies(Utility.KEY);

        call.enqueue(new Callback<NowPlayingMoviesResponse>() {
            @Override
            public void onResponse(Call<NowPlayingMoviesResponse> call, Response<NowPlayingMoviesResponse> response) {

                nowPlayingMoviesResultsPojos = response.body().getPopularMoviesResult();
                MoviesNowPlayingAdapter nowPlayingAdapter = new MoviesNowPlayingAdapter(MoviesUpComingActivity.this,nowPlayingMoviesResultsPojos);
                nowPlayingAdapter.notifyDataSetChanged();
                binding.nowPlayingRecyclarView.setAdapter(nowPlayingAdapter);
            }

            @Override
            public void onFailure(Call<NowPlayingMoviesResponse> call, Throwable t) {

            }
        });

    }

    private void getpopulaerPerson() {

      Call<MoviesPopularPersonResponse> call = apiName.moviesPopularPersonResponse(Utility.KEY);
      call.enqueue(new Callback<MoviesPopularPersonResponse>() {
          @Override
          public void onResponse(Call<MoviesPopularPersonResponse> call, Response<MoviesPopularPersonResponse> response) {
              popularPersonResultsPojos = response.body().getResults();

              MoviesPopulaerpersonAdapter moviesPopulaerpersonAdapter =new MoviesPopulaerpersonAdapter(MoviesUpComingActivity.this,popularPersonResultsPojos);
              moviesPopulaerpersonAdapter.notifyDataSetChanged();
              binding.movPopularPRecyclarView.setAdapter(moviesPopulaerpersonAdapter);


          }

          @Override
          public void onFailure(Call<MoviesPopularPersonResponse> call, Throwable t) {

          }
      });



    }

}