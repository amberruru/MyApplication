package com.weather.gson;

/**
 * Created by Administrator on 2017/12/19.
 */

public class AQI {
    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
