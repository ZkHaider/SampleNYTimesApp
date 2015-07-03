package com.samplenytimesapp.api.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class Result {

    public Result(String title, Multimedia ... multimedia) {
        this.mTitle = title.replace("\"", "");;
        mMultimedia = Arrays.asList(multimedia);
    }

    @SerializedName("section")
    private String mSection;
    public String getSection() {
        return mSection;
    }

    @SerializedName("subsection")
    private String mSubSection;
    public String getSubSection() {
        return mSubSection;
    }

    @SerializedName("title")
    private String mTitle;
    public String getTitle() {
        return mTitle;
    }

    @SerializedName("abstract")
    private String mAbstract;
    public String getAbstract() {
        return mAbstract;
    }

    @SerializedName("url")
    private String mUrl;
    public String getUrl() {
        return mUrl;
    }

    @SerializedName("byline")
    private String myByLine;
    public String getMyByLine() {
        return myByLine;
    }

    @SerializedName("item_type")
    private String mItemType;
    public String getItemType() {
        return mItemType;
    }

    @SerializedName("updated_date")
    private String mUpdatedDate;
    public String getUpdatedDate() {
        return mUpdatedDate;
    }

    @SerializedName("created_date")
    private String mCreatedDate;
    public String getCreatedDate() {
        return mCreatedDate;
    }

    @SerializedName("multimedia")
    private List<Multimedia> mMultimedia;
    public List<Multimedia> getMultimedia() {
        return mMultimedia;
    }

}
