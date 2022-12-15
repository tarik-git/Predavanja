package org.tarik.numberfacts.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NumbersService {

    @GET("random/trivia")
    Call<MainResponse> getTriviaAnswer();

}
