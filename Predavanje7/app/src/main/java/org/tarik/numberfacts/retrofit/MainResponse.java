package org.tarik.numberfacts.retrofit;

import com.google.gson.annotations.SerializedName;

public class MainResponse {

    @SerializedName("text")
    public String text;

    @SerializedName("number")
    public int number;

    @SerializedName("found")
    public boolean found;

    @SerializedName("type")
    public String type;

}
