package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.moviesfree.adapter.PopularPersonAdapter;
import com.example.moviesfree.databinding.ActivityPopulerPersonOverViewBinding;
import com.example.moviesfree.utilitty.Utility;

public class PopulerPersonOverView extends AppCompatActivity {

    ActivityPopulerPersonOverViewBinding binding;
   PopularPersonAdapter popularPersonAdapter;

   int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopulerPersonOverViewBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        PopulerPersonOverView.this.setTitle("Popular-People OverView");

        Intent intent = getIntent();
        String originalLanguage  =  intent.getStringExtra("original_lng");
        String releaseDate  =  intent.getStringExtra("getReleaseDate");
        String mediya_type  =  intent.getStringExtra("getMediaType");
        String getOverView  =  intent.getStringExtra("getOverView");
        String profile_poster = intent.getStringExtra("getPosterPath");
        String imageUrl = Utility.IMAGE_BASE_URL + profile_poster;
        Glide.with(PopulerPersonOverView.this).load(imageUrl).into(binding.poseterPath);

        binding.originalLanguage.setText("Language : "+originalLanguage);
        binding.realeaseDate.setText("Release Date :"+releaseDate);
        binding.mediyaType.setText( "Mediya Type:"+mediya_type);
        binding.overview.setText( "OverView "+getOverView);


    }
}