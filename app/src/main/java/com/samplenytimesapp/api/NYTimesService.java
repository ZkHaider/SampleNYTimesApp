package com.samplenytimesapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samplenytimesapp.api.interfaces.ITopStories;
import com.samplenytimesapp.api.models.Result;
import com.samplenytimesapp.api.models.TopStories;
import com.samplenytimesapp.api.utils.ResultsDeserializerJson;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class NYTimesService {

    private static final String API_URL = "http://api.nytimes.com/svc";
    private static final String API_KEY = "******************************************";

    private static NYTimesService mNYTimesService;
    private static RestAdapter mAsyncRestAdapter;

    public static NYTimesService getInstance() {
        if (mNYTimesService == null)
            mNYTimesService = new NYTimesService();
        return mNYTimesService;
    }

    private NYTimesService() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Result.class, new ResultsDeserializerJson()).create();

        mAsyncRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api-key", API_KEY);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public void getTopStories(Callback<TopStories> callback) {
        ITopStories topStories = mAsyncRestAdapter.create(ITopStories.class);
        topStories.getTopStories(callback);
    }

}
