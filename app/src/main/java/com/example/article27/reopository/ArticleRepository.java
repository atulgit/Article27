package com.example.article27.reopository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.article27.Util.UrlConstants;
import com.example.article27.app.Article27Context;
import com.example.article27.models.Article;
import com.example.article27.models.Articles;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;


public class ArticleRepository {

    private MutableLiveData<Articles> mutableLiveData = new MutableLiveData<>();

    public void getArticles(final IArticleListener articleListener) {

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, UrlConstants.GET_ARTICLES_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Gson gson = new Gson();
                            Articles articles = gson.fromJson(response.toString(), Articles.class);
                            Log.d("Response", response.toString());

                            if (articleListener != null) articleListener.onResponse(articles);
                        } catch (Exception e) {
                            Log.d("Crash", "exception");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String data = "";
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(Article27Context.getAppContext());
        queue.add(getRequest);
        queue.start();
    }

    public MutableLiveData<Articles> getMutableArticles() {

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, UrlConstants.GET_ARTICLES_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Gson gson = new Gson();
                            Articles articles = gson.fromJson(response.toString(), Articles.class);
                            mutableLiveData.setValue(articles);
                        } catch (Exception e) {
                            Log.d("Crash", "exception");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String data = "";
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(Article27Context.getAppContext());
        queue.add(getRequest);
        queue.start();

        return mutableLiveData;
    }

    public interface IArticleListener {
        void onResponse(Articles articles);

        void onError();
    }
}
