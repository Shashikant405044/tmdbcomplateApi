package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.moviesfree.adapter.TvAirToadayAdapter;
import com.example.moviesfree.databinding.ActivityTvShowAiringTodayBinding;
import com.example.moviesfree.intarface.ApiName;
import com.example.moviesfree.responce.tvshowresponse.airringtoday.AiringToadyResponse;
import com.example.moviesfree.responce.tvshowresponse.airringtoday.ResultAriringTodayPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowAiringTodayActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    List<ResultAriringTodayPojo> resultAriringTodayPojos = new ArrayList<>();
    ActivityTvShowAiringTodayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTvShowAiringTodayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait..");
        progressDialog.show();
        TvShowAiringTodayActivity.this.setTitle("Airing Today");
        GetDataAiringToday();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.tvairIngRecycler.setLayoutManager(linearLayoutManager);
    }


    private void GetDataAiringToday() {

         ApiName apiName =  RetrofitApi.getInstance(ApiName.class);

        Call<AiringToadyResponse>  call =  apiName.tvShowAiringTodayData(Utility.KEY);

        call.enqueue(new Callback<AiringToadyResponse>() {
            @Override
            public void onResponse(Call<AiringToadyResponse> call, Response<AiringToadyResponse> response) {
                progressDialog.dismiss();
                resultAriringTodayPojos = response.body().getGetResultAiringData();
                Log.d("mydata",response.body().getTotal_results());

                TvAirToadayAdapter tvAirToadayAdapter = new TvAirToadayAdapter(TvShowAiringTodayActivity.this,resultAriringTodayPojos);
                tvAirToadayAdapter.notifyDataSetChanged();
                binding.tvairIngRecycler.setAdapter(tvAirToadayAdapter);

            }

            @Override
            public void onFailure(Call<AiringToadyResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("mydata",t.getMessage());
            }
        });
    }
}