package com.samplenytimesapp.application;

import android.app.Application;

import com.samplenytimesapp.bus.BusProvider;
import com.samplenytimesapp.delegate.NYTimesDelegate;
import com.squareup.otto.Bus;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class NYTimesApplication extends Application {

    private Bus mBus = BusProvider.getInstance();
    private NYTimesDelegate mNYTimesDelegate;

    @Override
    public void onCreate() {
        super.onCreate();
        mNYTimesDelegate = new NYTimesDelegate(this, mBus);
        mBus.register(this);
        mBus.register(mNYTimesDelegate);
    }
}
