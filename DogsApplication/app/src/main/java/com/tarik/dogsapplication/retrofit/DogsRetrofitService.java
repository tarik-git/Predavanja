package com.tarik.dogsapplication.retrofit;

import com.tarik.dogsapplication.model.BreedResponse;
import com.tarik.dogsapplication.model.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//BASE_URL = "https://dog.ceo/api/"

public interface DogsRetrofitService {

//    https://dog.ceo/api/breeds/image/random
    @GET("breeds/image/random")
    Call<DogResponse> getRandomDogImage();

//    https://dog.ceo/api/breeds/list/all
    @GET("breeds/list/all")
    Call<BreedResponse> getBreedList();

//    https://dog.ceo/api/breed/affenpinscher/images/random

    @GET("breed/{breed}/images/random")
    Call<DogResponse> getDogBreed(@Path("breed") String breed);



}
