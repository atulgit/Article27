package com.example.article27.views.fragments;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.article27.models.Article;
import com.example.article27.models.Articles;
import com.example.article27.reopository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

public class ArticlesViewModel extends ViewModel {

    ArticleRepository articleRepository;

    public ArticlesViewModel() {
        articleRepository = new ArticleRepository();
    }

    public LiveData<Articles> getAllArticles() {
        return articleRepository.getMutableArticles();
    }
}
