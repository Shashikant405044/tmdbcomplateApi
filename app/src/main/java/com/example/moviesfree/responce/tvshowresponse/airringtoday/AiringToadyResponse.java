package com.example.moviesfree.responce.tvshowresponse.airringtoday;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiringToadyResponse {

    @SerializedName("page")
    String page;

    @SerializedName("results")
    List<ResultAriringTodayPojo> getResultAiringData;

    @SerializedName("total_pages")
    String total_pages;

    @SerializedName("total_results")
    String total_results;


    public String getPage() {
        return page;
    }

    public List<ResultAriringTodayPojo> getGetResultAiringData() {
        return getResultAiringData;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }
}
