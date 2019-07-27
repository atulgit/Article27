package com.example.article27.models;

import android.support.annotation.StyleableRes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Article extends BusinessObject {
    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private String id;

    @SerializedName("published_date")
    private String published_date;

    @SerializedName("byline")
    private String byline;

    @SerializedName("url")
    private String url;

    @SerializedName("media")
    @Expose
    private ArrayList<Media> media;

    public ArrayList<Media> getMedia() {
        return media;
    }

    public String getByLine() {
        return byline;
    }

    public String getPublishedDate() {
        return published_date;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

}
