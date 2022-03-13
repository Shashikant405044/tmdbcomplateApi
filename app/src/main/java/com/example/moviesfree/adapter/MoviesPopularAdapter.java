package com.example.moviesfree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesfree.R;
import com.example.moviesfree.responce.movies.popular.MoviesPopularResponse;
import com.example.moviesfree.responce.movies.popular.PopularMoviesResultPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.List;

public class MoviesPopularAdapter extends RecyclerView.Adapter<MoviesPopularAdapter.MyViewHolder> {

    private Context context;
    List<PopularMoviesResultPojo> popularMoviesResultPojos;

    public MoviesPopularAdapter(Context context, List<PopularMoviesResultPojo> popularMoviesResultPojos) {
        this.context = context;
        this.popularMoviesResultPojos = popularMoviesResultPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movies_populer_item,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PopularMoviesResultPojo moviesResultPojo = popularMoviesResultPojos.get(position);
        String imageUrl = Utility.IMAGE_BASE_URL + moviesResultPojo.getBackDropPath();
        Glide.with(context).load(imageUrl).into(holder.backdroppath);
    }

    @Override
    public int getItemCount() {
        return popularMoviesResultPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
  ImageView backdroppath;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            backdroppath = itemView.findViewById(R.id.backdrop_path_m_popular);

        }
    }
}

