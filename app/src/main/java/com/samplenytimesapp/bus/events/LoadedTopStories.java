package com.samplenytimesapp.bus.events;

import com.samplenytimesapp.api.models.TopStories;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class LoadedTopStories {

    private TopStories mTopStories;

    public LoadedTopStories(TopStories topStories) {
        this.mTopStories = topStories;
    }

    public TopStories getTopStories() {
        return mTopStories;
    }

}
