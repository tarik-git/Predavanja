package com.tarik.dogsapplication.retrofit;

import com.tarik.dogsapplication.model.BreedResponse;
import com.tarik.dogsapplication.model.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;

//BASE_URL = "https://dog.ceo/api/breeds/"

public interface DogsRetrofitService {

    @GET("image/random")
    Call<DogResponse> getRandomDogImage();

//    https://dog.ceo/api/breeds/list/all
    @GET("list/all")
    Call<BreedResponse> getBreedList();

}
