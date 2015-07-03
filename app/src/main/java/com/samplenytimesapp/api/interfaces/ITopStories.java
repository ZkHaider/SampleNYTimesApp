package com.samplenytimesapp.api.interfaces;

import com.samplenytimesapp.api.models.TopStories;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by ZkHaider on 7/2/15.
 */
public interface ITopStories {

    @Headers("Content-Type: text/json")
    @GET("/topstories/v1/home.json")
    void getTopStories(Callback<TopStories> callback);

}
