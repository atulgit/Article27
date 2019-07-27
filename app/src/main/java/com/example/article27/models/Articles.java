package com.example.article27.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Articles extends BusinessObject {

    @SerializedName("results")
    @Expose
    private ArrayList<Article> articles;

    public ArrayList<Article> getArticles() {
        return articles;
    }
}
