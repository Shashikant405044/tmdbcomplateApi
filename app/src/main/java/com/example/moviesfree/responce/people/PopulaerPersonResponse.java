package com.example.moviesfree.responce.people;

import com.example.moviesfree.responce.movies.popularperson.PopularPersonResultsPojo;
import com.example.moviesfree.subresponse.PopulaerPersonPojo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopulaerPersonResponse {

    @SerializedName("page")
      private int page;

    @SerializedName("results")
    private List<PopulaerPersonPojo> resultsPersonData;

    public int getPage() {
        return page;
    }

    public List<PopulaerPersonPojo> getResultsPersonData() {
        return resultsPersonData;
    }
}
