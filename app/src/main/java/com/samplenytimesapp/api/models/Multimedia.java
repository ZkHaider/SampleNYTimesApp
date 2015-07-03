package com.samplenytimesapp.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class Multimedia {

    @SerializedName("url")
    private String mUrl;
    public String getUrl() {
        return mUrl;
    }
    public String getFormattedUrl() {
        return getUrl().replace("\\", "");
    }

    @SerializedName("format")
    private String mFormat;
    public String getFormat() {
        return mFormat;
    }

    @SerializedName("height")
    private int mHeight;
    public int getHeight() {
        return mHeight;
    }

    @SerializedName("width")
    private int mWidth;
    public int getWidth() {
        return mWidth;
    }

    @SerializedName("type")
    private String mType;
    public String getType() {
        return mType;
    }

    @SerializedName("subtype")
    private String mSubType;
    public String getSubType() {
        return mSubType;
    }

    @SerializedName("caption")
    private String mCaption;
    public String getCaption() {
        return mCaption;
    }

    @SerializedName("copyright")
    private String mCopyright;
    public String getCopyright() {
        return mCopyright;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public void setFormat(String format) {
        mFormat = format;
    }
}
