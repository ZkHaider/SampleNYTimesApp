package com.samplenytimesapp.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class TopStories {

    @SerializedName("status")
    private String mStatus;
    public String getStatus() {
        return mStatus;
    }

    @SerializedName("copyright")
    private String mCopyright;
    public String getCopyright() {
        return mCopyright;
    }

    @SerializedName("last_updated")
    private String mLastUpdated;
    public String getLastUpdated() {
        return mLastUpdated;
    }

    @SerializedName("num_results")
    private int mNumResults;
    public int getNumResults() {
        return mNumResults;
    }

    @SerializedName("results")
    private List<Result> mResults;
    public List<Result> getResults() {
        return mResults;
    }

}
