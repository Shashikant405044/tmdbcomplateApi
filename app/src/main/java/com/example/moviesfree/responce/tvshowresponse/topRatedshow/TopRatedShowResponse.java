package com.example.moviesfree.responce.tvshowresponse.topRatedshow;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRatedShowResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<ResultsPojo> resultData;

    public int getPage() {
        return page;
    }

    public List<ResultsPojo> getResultData() {

        return resultData;
    }


}
