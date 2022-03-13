package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moviesfree.databinding.ActivityTvShowBinding;

public class TvShowActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityTvShowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTvShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       TvShowActivity.this.setTitle("Tv Shows");
        binding.popularTVShow.setOnClickListener(this);
       binding.topRatedShows.setOnClickListener(this);
       binding.airingToday.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.popularTV_show:

                Intent intent = new Intent(TvShowActivity.this,TVshowPopularActivity.class);
                startActivity(intent);

                break;

            case R.id.topRated_shows:

                Intent toprated = new Intent(TvShowActivity.this,TopRatedTvShowActivity.class);
                startActivity(toprated);
                break;


            case R.id.airing_today:

                Intent airing_today = new Intent(TvShowActivity.this,TvShowAiringTodayActivity.class);
                startActivity(airing_today);
                break;

        }

    }
}