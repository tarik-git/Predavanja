package com.example.tvmazeapp.data.remote;


import com.example.tvmazeapp.data.remote.dto.ShowResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("search/shows")
    Call<List<ShowResponse>> searchShow(@Query("q") String query);

    @GET("shows/{id}")
    Call<ShowResponse.ShowDto> getShowById(@Path("id") long id);

}
