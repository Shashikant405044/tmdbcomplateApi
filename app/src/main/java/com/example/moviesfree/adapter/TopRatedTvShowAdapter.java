package com.example.moviesfree.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesfree.PopulerPersonOverView;
import com.example.moviesfree.R;
import com.example.moviesfree.TopRatedDetailsActivity;
import com.example.moviesfree.responce.tvshowresponse.BackDropPojo;
import com.example.moviesfree.responce.tvshowresponse.topRatedshow.ResultsPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.Date;
import java.util.List;

import kotlin.jvm.internal.Lambda;

public class TopRatedTvShowAdapter  extends RecyclerView.Adapter<TopRatedTvShowAdapter.MyViewHolder> implements View.OnClickListener {

    private Context context;
    int positionitem;
    List<ResultsPojo> resultsPojos;
    ResultsPojo resultsPojoData;


    public TopRatedTvShowAdapter(Context context, List<ResultsPojo> resultsPojos) {
        this.context = context;
        this.resultsPojos = resultsPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_rated_tvshoww_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        resultsPojoData = resultsPojos.get(position);

     holder.name_rated.setText(resultsPojoData.getTitle());
     holder.first_air_date_rated.setText(PopularTvShowAdapter.getMyFormattedDate(resultsPojoData.getRelease_date()));
     holder.vote_avarage_rated.setText(resultsPojoData.getVote_average());
     String imageUrl = Utility.IMAGE_BASE_URL + resultsPojoData.getBackdrop_path();
       Glide.with(context).load(imageUrl).into(holder.backdrop_path_rated);
       holder.cardView.setOnClickListener(this);
//        holder.first_air_date_rated.setText( PopularTvShowAdapter.getMyFormattedDate(resultsPojo.getReleaseDate()));
//        holder.name_rated.setText(resultsPojo.getTitle());
//        holder.vote_avarage_rated.setText(resultsPojo.getVoteAverage());
    }



    @Override
    public int getItemCount() {
        return resultsPojos.size();
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(context, TopRatedDetailsActivity.class);
        intent.putExtra("getOverView",resultsPojoData.getOverview());
        intent.putExtra("posterPath",resultsPojoData.getPoster_path());
        intent.putExtra("vot_user",resultsPojoData.getVote_count());
        intent.putExtra("date",resultsPojoData.getRelease_date());


//        intent.putExtra("getPosterPath",resultsPojoData.getKnownFor().get(position).getPosterPath());
//        intent.putExtra("getReleaseDate",resultsPojoData.getKnownFor().get(position).getReleaseDate());


        context.startActivity(intent);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView  backdrop_path_rated;
        TextView vote_avarage_rated,name_rated,first_air_date_rated;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            backdrop_path_rated = itemView.findViewById(R.id.backdrop_path_rated);
            vote_avarage_rated = itemView.findViewById(R.id.vote_avarage_rated);
            name_rated = itemView.findViewById(R.id.name_rated);
            first_air_date_rated = itemView.findViewById(R.id.first_air_date_rated);
            cardView = itemView.findViewById(R.id.card_top_rated);

        }
    }
}
