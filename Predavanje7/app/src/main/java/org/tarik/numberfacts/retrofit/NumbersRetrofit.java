package org.tarik.numberfacts.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NumbersRetrofit {

    private static Retrofit numbersRetrofit;

    private NumbersRetrofit() {

    }

    public static Retrofit getRetrofitInstance() {
        if (numbersRetrofit == null) {
            numbersRetrofit = new Retrofit.Builder()
                    .baseUrl("http://numbersapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return numbersRetrofit;
    }

}
