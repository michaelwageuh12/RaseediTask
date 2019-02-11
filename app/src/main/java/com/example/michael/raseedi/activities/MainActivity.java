package com.example.michael.raseedi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.michael.raseedi.api.AdsAPI;
import com.example.michael.raseedi.model.Ad;
import com.example.michael.raseedi.R;
import com.example.michael.raseedi.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * It is the MainActivity which represent the list of all ads. with a RecyclerView
 */
public class MainActivity extends AppCompatActivity {

    String BASE_URL = "https://simswitch.bit68.com/get_ad/?solo=false)";
    List<Ad> allAds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAds();
    }

    /**
     * Request all ads. from the api with retrofit call,
     * get the response and put it into a list of Ad called allAds
     */
    void getAds() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AdsAPI adsApi = retrofit.create(AdsAPI.class);
        Call<List<Ad>> call = adsApi.GetAllAds("false");

        call.enqueue(new Callback<List<Ad>>(){
            @Override
            public void onResponse(Call<List<Ad>> call, Response<List<Ad>> response) {
                allAds = response.body();
                sortAllAds();
                initRecyclerView();
            }

            @Override
            public void onFailure(Call<List<Ad>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail - Check Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Initialize RecyclerView with RecyclerViewAdapter
     */
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, allAds);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Sort all ads. ascending according to its order
     */
    private void sortAllAds(){
        Collections.sort(allAds, new Comparator<Ad>() {
            public int compare(Ad a1, Ad a2) {
                int res = a1.compareTo(a2);
                if(res == 0){
                    return res;
                }
                return a1.getOrder() > a2.getOrder() ? 1 : a1.getOrder() < a2.getOrder() ? -1 : 0;
            }
        });
    }
}