package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.moviesfree.adapter.PopularPersonAdapter;
import com.example.moviesfree.adapter.TopRatedTvShowAdapter;
import com.example.moviesfree.databinding.ActivityTopRatedTvShowBinding;
import com.example.moviesfree.intarface.ApiName;
import com.example.moviesfree.responce.tvshowresponse.BackDropPojo;
import com.example.moviesfree.responce.tvshowresponse.topRatedshow.ResultsPojo;
import com.example.moviesfree.responce.tvshowresponse.topRatedshow.TopRatedShowResponse;
import com.example.moviesfree.utilitty.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedTvShowActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    ActivityTopRatedTvShowBinding binding;
    List<ResultsPojo> resultsPojoArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTopRatedTvShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TopRatedTvShowActivity.this.setTitle("TopRated Tv Show");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

     getTopRatedDataTvShows();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager( 1,StaggeredGridLayoutManager.VERTICAL);
        binding.topratedRecycleView.setLayoutManager(staggeredGridLayoutManager);

    }

    private void getTopRatedDataTvShows() {

        ApiName apiName =   RetrofitApi.getInstance(ApiName.class);

        Call<TopRatedShowResponse> call = apiName.toRatedResponseData(Utility.KEY);

        call.enqueue(new Callback<TopRatedShowResponse>() {
            @Override
            public void onResponse(Call<TopRatedShowResponse> call, Response<TopRatedShowResponse> response) {
               progressDialog.dismiss();

                 resultsPojoArrayList = response.body().getResultData();

                TopRatedTvShowAdapter topRatedTvShowAdapter = new TopRatedTvShowAdapter(TopRatedTvShowActivity.this,resultsPojoArrayList);
                topRatedTvShowAdapter.notifyDataSetChanged();
                binding.topratedRecycleView.setAdapter(topRatedTvShowAdapter);


            }

            @Override
            public void onFailure(Call<TopRatedShowResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TopRatedTvShowActivity.this, "fdgdfgdfgd", Toast.LENGTH_SHORT).show();

            }
        });

    }
}