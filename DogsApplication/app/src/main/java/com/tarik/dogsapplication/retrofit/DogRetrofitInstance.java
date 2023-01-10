package com.tarik.dogsapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogRetrofitInstance {

    private static String BASE_URL = "https://dog.ceo/api/";
    private static Retrofit instance = null;

    private DogRetrofitInstance() {

    }

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
