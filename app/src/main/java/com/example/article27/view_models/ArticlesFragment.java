package com.example.article27.view_models;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.article27.R;
import com.example.article27.models.Articles;
import com.example.article27.reopository.ArticleRepository;
import com.example.article27.views.adapters.ArticlesAdapter;
import com.example.article27.views.fragments.ArticlesViewModel;

public class ArticlesFragment extends Fragment {

    private ArticlesViewModel mViewModel;
    RecyclerView articles_recycler_view;
    View root_view;
    ArticlesViewModel articlesViewModel;

    public static ArticlesFragment newInstance() {
        return new ArticlesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (root_view == null) {
            root_view = inflater.inflate(R.layout.articles_fragment, container, false);
            articlesViewModel = new ArticlesViewModel();
            initUI();
            loadArticles();
        }

        return root_view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initUI() {
        articles_recycler_view = root_view.findViewById(R.id.articles_recycler_view);
    }

    private void loadArticles() {
        articlesViewModel.getAllArticles().observe(this, new Observer<Articles>() {
            @Override
            public void onChanged(@Nullable Articles articles) {
                bindArticles(articles);
            }
        });
    }

    private void bindArticles(Articles articles) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        articles_recycler_view.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
        articles_recycler_view.setAdapter(new ArticlesAdapter(getContext(), articles));
    }
}
