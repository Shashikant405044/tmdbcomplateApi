package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.moviesfree.databinding.ActivityMoviesPopularBinding;

public class MoviesPopularActivity extends AppCompatActivity {

    ActivityMoviesPopularBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMoviesPopularBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}