package com.example.moviesfree.adapter;

import android.annotation.SuppressLint;
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
import com.example.moviesfree.subresponse.PopulaerPersonPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.List;

public class PopularPersonAdapter extends RecyclerView.Adapter<PopularPersonAdapter.MyViewHolder> implements View.OnClickListener {
    int position;

    private Context context;
    List<PopulaerPersonPojo> populaerPersonPojos;
    PopulaerPersonPojo populaerPerson;

    public PopularPersonAdapter(Context context, List<PopulaerPersonPojo> populaerPersonPojos) {
        this.context = context;
        this.populaerPersonPojos = populaerPersonPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(R.layout.popular_person_list,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        populaerPerson = populaerPersonPojos.get(position);

        String imageUrl = Utility.IMAGE_BASE_URL + populaerPerson.getProfilePath();
        Glide.with(context).load(imageUrl).into(holder.profileImg);
        holder.Name.setText("Name-  "+populaerPerson.getName());
        holder.department.setText("Dept-"+populaerPerson.getDepartment());
        holder.popularity.setText(" Rating-"+populaerPerson.getPopularity());
        holder.cardView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return populaerPersonPojos.size();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.card:
                Intent intent = new Intent(context,PopulerPersonOverView.class);
                intent.putExtra("original_lng",populaerPerson.getKnownFor().get(position).getOriginalLanguage());
                intent.putExtra("getOverView",populaerPerson.getKnownFor().get(position).getOverView());
                intent.putExtra("getPosterPath",populaerPerson.getKnownFor().get(position).getPosterPath());
                intent.putExtra("getReleaseDate",populaerPerson.getKnownFor().get(position).getReleaseDate());
                intent.putExtra("getMediaType",populaerPerson.getKnownFor().get(position).getMediaType());


                context.startActivity(intent);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImg;
        TextView Name, popularity, department;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            profileImg =itemView.findViewById(R.id.profile_Path);
            Name =itemView.findViewById(R.id.name);
            popularity =itemView.findViewById(R.id.popularity);
            department =itemView.findViewById(R.id.department);
        }
    }
}
