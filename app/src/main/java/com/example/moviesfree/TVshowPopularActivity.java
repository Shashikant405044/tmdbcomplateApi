package com.example.moviesfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.moviesfree.adapter.PopularPersonAdapter;
import com.example.moviesfree.adapter.PopularTvShowAdapter;
import com.example.moviesfree.databinding.ActivityTvshowPopularBinding;
import com.example.moviesfree.intarface.ApiName;
import com.example.moviesfree.responce.tvshowresponse.BackDropPojo;
import com.example.moviesfree.responce.tvshowresponse.TvShowPopularResponse;
import com.example.moviesfree.subresponse.PopulaerPersonPojo;
import com.example.moviesfree.utilitty.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVshowPopularActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    ActivityTvshowPopularBinding binding;
    List<BackDropPojo> backDropPojoArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTvshowPopularBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();
       TVshowPopularActivity.this.setTitle("Popular TV-Show");
        getPopulartvShowData();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL);
        binding.populaershowRecyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

    private void getPopulartvShowData() {
              ApiName apiName = RetrofitApi.getInstance(ApiName.class);

              Call<TvShowPopularResponse> call = apiName.tvShowPopularResponseData(Utility.KEY);

              call.enqueue(new Callback<TvShowPopularResponse>() {
                  @Override
                  public void onResponse(Call<TvShowPopularResponse> call, Response<TvShowPopularResponse> response) {

                      progressDialog.dismiss();
                      backDropPojoArrayList =  response.body().getResultData();

                      Log.d("MyResponse",backDropPojoArrayList.toString());

                      PopularTvShowAdapter popularTvShowAdapter = new PopularTvShowAdapter(TVshowPopularActivity.this,backDropPojoArrayList);
                      popularTvShowAdapter.notifyDataSetChanged();
                      binding.populaershowRecyclerView.setAdapter(popularTvShowAdapter);
                  }

                  @Override
                  public void onFailure(Call<TvShowPopularResponse> call, Throwable t) {
                      progressDialog.dismiss();
                         Toast.makeText(TVshowPopularActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                  }
              });
//              Call<TvShowPopularResponse<BackDropPojo>> call = apiName.tvShowPopularResponseData(Utility.KEY);
//              call.enqueue(new Callback<TvShowPopularResponse>() {
//                  @Override
//                  public void onResponse(Call<TvShowPopularResponse> call, Response<TvShowPopularResponse> response) {
//                 progressDialog.dismiss();
//
//
//                 if (response.isSuccessful() && response.code()==200) {
//
//                     List<BackDropPojo> backDropPojoList = response.body().getBackDropPojos();
//
//                     for (BackDropPojo backDropPojo: backDropPojoList)
//                     {
//                         Toast.makeText(TVshowPopularActivity.this, ""+backDropPojo.getBackdrop_path(), Toast.LENGTH_SHORT).show();
//                     }
//                 }
//
//                  }
//
//                  @Override
//                  public void onFailure(Call<TvShowPopularResponse> call, Throwable t) {
//                      progressDialog.hide();
//                      Toast.makeText(TVshowPopularActivity.this, "ffffff", Toast.LENGTH_SHORT).show();
//
//                  }
//              });
//
   }

    }


