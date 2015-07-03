package com.samplenytimesapp.delegate;

import android.content.Context;
import android.util.Log;

import com.samplenytimesapp.api.NYTimesService;
import com.samplenytimesapp.api.models.TopStories;
import com.samplenytimesapp.bus.events.LoadTopStories;
import com.samplenytimesapp.bus.events.LoadedTopStories;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class NYTimesDelegate {

    private static final String TAG = NYTimesDelegate.class.getSimpleName();

    private NYTimesService sClient;
    private Context mContext;
    private Bus mBus;

    public NYTimesDelegate(Context context, Bus bus) {
        this.mContext = context;
        this.mBus = bus;
        this.sClient = NYTimesService.getInstance();
    }

    @Subscribe
    public void onLoadTopStories(LoadTopStories loadTopStories) {
        Log.d(TAG, "onLoadTopStories");
        Callback<TopStories> callback = new Callback<TopStories>() {
            @Override
            public void success(TopStories topStories, Response response) {
                Log.d(TAG, "onSuccess");
                mBus.post(new LoadedTopStories(topStories));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, error.getMessage());
                Log.d(TAG, error.getResponse().getReason());
            }
        };
        sClient.getTopStories(callback);
    }

}
