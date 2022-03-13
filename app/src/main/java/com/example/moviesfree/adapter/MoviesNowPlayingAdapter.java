package com.example.moviesfree.adapter;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesfree.R;
import com.example.moviesfree.responce.movies.nowplaylish.NowPlayingMoviesResultsPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.List;

public class MoviesNowPlayingAdapter extends RecyclerView.Adapter<MoviesNowPlayingAdapter.MyViewHolder> {

    private Context context;
    List<NowPlayingMoviesResultsPojo> nowPlayingMoviesResultsPojos;

    public MoviesNowPlayingAdapter(Context context, List<NowPlayingMoviesResultsPojo> nowPlayingMoviesResultsPojos) {
        this.context = context;
        this.nowPlayingMoviesResultsPojos = nowPlayingMoviesResultsPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movies_playing_list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NowPlayingMoviesResultsPojo playingMoviesResultsPojo = nowPlayingMoviesResultsPojos.get(position);
        String imageUrl = Utility.IMAGE_BASE_URL + playingMoviesResultsPojo.getPosterPath();
        Glide.with(context).load(imageUrl).into(holder.imageView);
        holder.MovieName.setText("Name-  "+playingMoviesResultsPojo.getOriginalTitle());
        holder.Rating.setText("Dept-"+playingMoviesResultsPojo.getVoteAverage());
        holder.ReleaseDate.setText(" Rating-"+playingMoviesResultsPojo.getPopularity());
    }

    @Override
    public int getItemCount() {
        return nowPlayingMoviesResultsPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;
        TextView Rating, MovieName,ReleaseDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ImageNowPlayingMovies);
            Rating = itemView.findViewById(R.id.RatingNowPlayingMovies);
            MovieName = itemView.findViewById(R.id.NameNowPlayingMovies);
            ReleaseDate = itemView.findViewById(R.id.ReleaseDateNowPlayingMovies);
            cardView = itemView.findViewById(R.id.NowPlayingMoviesCard);
        }
    }
}
