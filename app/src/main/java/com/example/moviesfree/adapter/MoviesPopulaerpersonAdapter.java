package com.example.moviesfree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesfree.R;
import com.example.moviesfree.responce.movies.popularperson.PopularPersonResultsPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MoviesPopulaerpersonAdapter  extends RecyclerView.Adapter<MoviesPopulaerpersonAdapter.MyViewHolder> {

    private Context context;
    List<PopularPersonResultsPojo> popularPersonResultsPojos;

    public MoviesPopulaerpersonAdapter(Context context, List<PopularPersonResultsPojo> popularPersonResultsPojos) {
        this.context = context;
        this.popularPersonResultsPojos = popularPersonResultsPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movies_popular_person_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     PopularPersonResultsPojo popularPersonResultsPojo = popularPersonResultsPojos.get(position);
        String imageUrl = Utility.IMAGE_BASE_URL + popularPersonResultsPojo.getProfilePath();
        Glide.with(context).load(imageUrl).into(holder.profile);
        holder.title.setText(popularPersonResultsPojo.getName());

    }

    @Override
    public int getItemCount() {
        return popularPersonResultsPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.backdrop_path_m_poular_person);
            title = itemView.findViewById(R.id.title_m_p_p);
        }
    }
}
