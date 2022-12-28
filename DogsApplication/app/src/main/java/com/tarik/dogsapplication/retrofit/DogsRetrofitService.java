package com.tarik.dogsapplication.retrofit;

import retrofit2.http.GET;

public interface DogsRetrofitService {

    @GET("/image/random")
    void getRandomDogImage();

}
