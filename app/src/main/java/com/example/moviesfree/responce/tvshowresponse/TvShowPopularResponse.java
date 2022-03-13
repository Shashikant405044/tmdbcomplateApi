package com.example.moviesfree.responce.tvshowresponse;

import com.example.moviesfree.subresponse.PopulaerPersonPojo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShowPopularResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<BackDropPojo> resultData;

    public int getPage() {
        return page;
    }

    public List<BackDropPojo> getResultData() {
        return resultData;



    }
}