package org.tarik.numberfacts.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumbersService {

    @GET("{number}/trivia?json")
    Call<MainResponse> getTriviaAnswer(@Path("number") String number);

    @GET("{number}/date?json")
    Call<MainResponse> getDateAnswer(@Path("number") String number);

    @GET("{number}/year?json")
    Call<MainResponse> getYearAnswer(@Path("number") String number);

    @GET("{number}/math?json")
    Call<MainResponse> getMathAnswer(@Path("number") String number);

}
