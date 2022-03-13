package com.example.moviesfree;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.moviesfree.adapter.PopularPersonAdapter;
import com.example.moviesfree.intarface.ApiName;
import com.example.moviesfree.responce.people.PopulaerPersonResponse;
import com.example.moviesfree.subresponse.PopulaerPersonPojo;
import com.example.moviesfree.utilitty.Utility;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.moviesfree.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainActivity.this.setTitle("Popular Person");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        getPopularPersonResponce();

       StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL);
       binding.popularRecyclerview.setLayoutManager(staggeredGridLayoutManager);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        binding.popularRecyclerview.setLayoutManager(linearLayoutManager);

        binding.popularRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int currentVisibleItemCount;
            private int currentScrollState;
            private int currentFirstVisibleItem;
            private int totalItem;



            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

                
                super.onScrollStateChanged(recyclerView, newState);


            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }


    private void getPopularPersonResponce() {

         ApiName apiName = RetrofitApi.getInstance(ApiName.class);
          Call<PopulaerPersonResponse> call = apiName.popularPersonResponseGetData(Utility.KEY);
          call.enqueue(new Callback<PopulaerPersonResponse>() {
              @Override
              public void onResponse(Call<PopulaerPersonResponse> call, Response<PopulaerPersonResponse> response) {
                progressDialog.dismiss();
                List<PopulaerPersonPojo> populaerPersonResponses = new ArrayList<>();
                 populaerPersonResponses =  response.body().getResultsPersonData();

                  Log.d("MyResponse",populaerPersonResponses.toString());

                  PopularPersonAdapter popularPersonAdapter = new PopularPersonAdapter(MainActivity.this,populaerPersonResponses);
                  popularPersonAdapter.notifyDataSetChanged();
                  binding.popularRecyclerview.setAdapter(popularPersonAdapter);

              }

              @Override
              public void onFailure(Call<PopulaerPersonResponse> call, Throwable t) {
                  Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
              }
          });


    }
}