package com.example.moviesfree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesfree.R;
import com.example.moviesfree.responce.tvshowresponse.airringtoday.ResultAriringTodayPojo;
import com.example.moviesfree.responce.tvshowresponse.topRatedshow.ResultsPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.List;

public class TvAirToadayAdapter extends RecyclerView.Adapter<TvAirToadayAdapter.MyViewHolder> {

    private Context context;
    List<ResultAriringTodayPojo> resultsPojos;

    public TvAirToadayAdapter(Context context, List<ResultAriringTodayPojo> resultsPojos) {
        this.context = context;
        this.resultsPojos = resultsPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tv_show_airing_item,parent,false);
          return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

         ResultAriringTodayPojo resultAriringTodayPojo = resultsPojos.get(position);

        holder.name_rated.setText(resultAriringTodayPojo.getName());
        holder.first_air_date_rated.setText(PopularTvShowAdapter.getMyFormattedDate(resultAriringTodayPojo.getFirst_air_date()));
        holder.vote_avarage_rated.setText(resultAriringTodayPojo.getVote_average());
        String imageUrl = Utility.IMAGE_BASE_URL + resultAriringTodayPojo.getPoster_path();
        Glide.with(context).load(imageUrl).into(holder.backdrop_path_rated);
        holder.overview.setText(resultAriringTodayPojo.getOverview());


    }



    @Override
    public int getItemCount() {
        return resultsPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView backdrop_path_rated;
        TextView vote_avarage_rated,name_rated,first_air_date_rated,overview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            backdrop_path_rated = itemView.findViewById(R.id.poster_path);
            vote_avarage_rated = itemView.findViewById(R.id.vote_avarage_airing);
            name_rated = itemView.findViewById(R.id.name_airing);
            first_air_date_rated = itemView.findViewById(R.id.date_airing);
            overview = itemView.findViewById(R.id.overView_airing);

        }
    }
}
