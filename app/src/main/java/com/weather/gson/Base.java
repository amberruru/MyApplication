package com.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/12/19.
 */

public class Base {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
