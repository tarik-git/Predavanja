package com.tarik.dogsapplication.model;

import com.google.gson.annotations.SerializedName;

public class DogResponse {

    @SerializedName("message")
    public String message;
    @SerializedName("status")
    public String status;

    public boolean isSuccessful() {
        return status.equals("success");
    }

}
