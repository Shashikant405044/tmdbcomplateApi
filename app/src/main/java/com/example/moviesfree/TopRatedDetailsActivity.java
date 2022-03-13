package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.moviesfree.databinding.ActivityTopRatedDetailsBinding;
import com.example.moviesfree.utilitty.Utility;

public class TopRatedDetailsActivity extends AppCompatActivity {

    ActivityTopRatedDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTopRatedDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String releaseDate  =  intent.getStringExtra("date");
        String vot_user  =  intent.getStringExtra("vot_user");
        String getOverView  =  intent.getStringExtra("getOverView");
        String posterPath = intent.getStringExtra("posterPath");


        String imageUrl = Utility.IMAGE_BASE_URL + posterPath;
        Glide.with(TopRatedDetailsActivity.this).load(imageUrl).into(binding.poseterPathTopRatesM);
        binding.realeaseDateTRM.setText("Release Date :"+releaseDate);
        binding.overview.setText( "OverView "+getOverView);
        binding.userScorePopularity.setText( vot_user);



    }
}