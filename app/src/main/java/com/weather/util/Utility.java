package com.weather.util;

import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.weather.db.City;
import com.weather.db.County;
import com.weather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Utility {
    /**
     * 处理省数据
     * @param response
     * @return
     */
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray jsonElements= new JSONArray(response);
                for (int i=0;i<jsonElements.length();i++){
                    JSONObject province = (JSONObject) jsonElements.get(i);
                    Province province1 = new Province();
                    province1.setProvinceName(province.getString("name"));
                    province1.setProvinceCode(province.getInt("id"));
                    province1.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray jsonElements= new JSONArray(response);
                for (int i=0;i<jsonElements.length();i++){
                    JSONObject jsonObject = (JSONObject) jsonElements.get(i);
                    City city = new City();
                    city.setCityName(jsonObject.getString("name"));
                    city.setCityCode(jsonObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response,int cityID){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray jsonElements= new JSONArray(response);
                for (int i=0;i<jsonElements.length();i++){
                    JSONObject jsonObject = (JSONObject) jsonElements.get(i);
                    County county = new County();
                    county.setCountyName(jsonObject.getString("name"));
                    county.setWeatherId(jsonObject.getString("weather_id"));
                    county.setCityId(cityID);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
