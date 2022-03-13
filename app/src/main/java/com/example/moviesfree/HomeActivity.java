package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.moviesfree.databinding.ActivityHomeBinding;
import com.example.moviesfree.utilitty.NetworkUtility;
import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MenuDrawarLayout();
        binding.MPopularPerson.setOnClickListener(this);
        binding.CardViewTvshowAiringToday.setOnClickListener(this);
        binding.cardViewMovies.setOnClickListener(this);
        binding.populartvshow.setOnClickListener(this);
        binding.topRateTvShow.setOnClickListener(this);
    }

    private void MenuDrawarLayout() {

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.nav_header_main, binding.drawarLayout, false);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.MPopular_Person:

                    Intent popular = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(popular);


                break;

            case R.id.CardViewTvshow_airing_today:

                Intent populartvs = new Intent(HomeActivity.this,TvShowAiringTodayActivity.class);
                startActivity(populartvs);

                break;


            case R.id.cardViewMovies:

                Intent cardViewMovies = new Intent(HomeActivity.this,MoviesUpComingActivity.class);
                startActivity(cardViewMovies);

                break;

            case R.id.populartvshow:
                Intent popular_TVShow = new Intent(HomeActivity.this,TVshowPopularActivity.class);
                startActivity(popular_TVShow);

                break;
            case R.id.top_rate_tvShow:

                Intent top_rate_tvShow = new Intent(HomeActivity.this,TopRatedTvShowActivity.class);
                startActivity(top_rate_tvShow);

                break;

        }
    }



}