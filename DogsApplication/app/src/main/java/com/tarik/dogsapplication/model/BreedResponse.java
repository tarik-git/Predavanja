package com.tarik.dogsapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class BreedResponse {

    @SerializedName("message")
    public Map<String, List<String>> message;
    @SerializedName("status")
    public String status;

    public boolean isSuccessful() {
        return status.equals("success");
    }

}
