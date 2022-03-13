package com.example.moviesfree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesfree.R;
import com.example.moviesfree.responce.tvshowresponse.BackDropPojo;
import com.example.moviesfree.utilitty.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kotlin.jvm.internal.Lambda;

public class PopularTvShowAdapter extends RecyclerView.Adapter<PopularTvShowAdapter.MyViewHolder> {

    private Context context;
    List<BackDropPojo> backDropPojos;

    public PopularTvShowAdapter(Context context, List<BackDropPojo> backDropPojos) {
        this.context = context;
        this.backDropPojos = backDropPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tv_show_popular_item,parent,false);
        return  new MyViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        BackDropPojo backDropPojo = backDropPojos.get(position);
        String imageUrl = Utility.IMAGE_BASE_URL + backDropPojo.getPoster_path();
        Glide.with(context).load(imageUrl).into(holder.backdrop_path);
        holder.first_air_date.setText(getMyFormattedDate(backDropPojo.getFirst_air_date()));
        holder.name.setText(backDropPojo.getName());
        holder.vote.setText(backDropPojo.getVote_average());
    }




    public static String getMyFormattedDate(String inpDate) {
        String retFmtDate = null;
        try {
            Date dateObj = new SimpleDateFormat("yyyy-MM-dd").parse(inpDate);
            String fmtDate = dateObj.toString();
            String[] arr = fmtDate.split(" ");
            String weekDay = arr[0], fullMonth = arr[1], date = arr[2], year = arr[5];
            String[] fullWeekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            };

            for (String eachWeekDay : fullWeekDays) {

                if ((eachWeekDay.indexOf(weekDay)) >= 0) {

                    weekDay = eachWeekDay;

                }
            }
            String[] fullMonthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
            };
            for (String eachMonth : fullMonthNames) {
                if ((eachMonth.indexOf(fullMonth)) >= 0) {
                    fullMonth = eachMonth;
                }
            }
            retFmtDate = weekDay + ", " + fullMonth + " " + date + ", " + year;
        } catch (Exception e) {
        }
        return retFmtDate;
    }
    @Override
    public int getItemCount() {
        return backDropPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView backdrop_path ;
        TextView first_air_date,name;
        TextView vote;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            backdrop_path = itemView.findViewById(R.id.backdrop_path);
            first_air_date = itemView.findViewById(R.id.first_air_date);
            name = itemView.findViewById(R.id.name_pop);
            vote = itemView.findViewById(R.id.vote_avarage);
        }
    }
}
