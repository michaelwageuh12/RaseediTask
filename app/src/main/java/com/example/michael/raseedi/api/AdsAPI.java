package com.example.michael.raseedi.api;

import com.example.michael.raseedi.model.Ad;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AdsAPI {
    @Headers("Content-Type: application/json")
    @GET("/get_ad/")
    Call<List<Ad>> GetAllAds(@Query("solo")String solo);
}
