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
import com.example.moviesfree.responce.movies.upcoming.MoviesResultUpcomingPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MoviesUpcomingAdapter extends RecyclerView.Adapter<MoviesUpcomingAdapter.MyViewHolder> {

    private Context context;

    List<MoviesResultUpcomingPojo> moviesResultUpcomingPojos;

    public MoviesUpcomingAdapter(Context context, List<MoviesResultUpcomingPojo> moviesResultUpcomingPojos) {
        this.context = context;
        this.moviesResultUpcomingPojos = moviesResultUpcomingPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movies_upcoming_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MoviesResultUpcomingPojo moviesResultUpcomingPojo = moviesResultUpcomingPojos.get(position);

        String imageUrl = Utility.IMAGE_BASE_URL + moviesResultUpcomingPojo.getPoster_path();
        Glide.with(context).load(imageUrl).into(holder.imageView);
//        holder.date.setText(PopularTvShowAdapter.getMyFormattedDate(moviesResultUpcomingPojo.getRelease_date()));
//        holder.titleName.setText(moviesResultUpcomingPojo.getTitle());
      //  holder.vote.setText(moviesResultUpcomingPojo.getVote_average());

    }

    @Override
    public int getItemCount() {
        return moviesResultUpcomingPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView date, titleName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.backdrop_path_m_upcomng);
//            date = itemView.findViewById(R.id.date_m_upcomng);
//            titleName = itemView.findViewById(R.id.title_m_upcomng);
        }
    }
}
