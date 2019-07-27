package com.example.article27.views.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.article27.R;
import com.example.article27.Util.ImageLoadTask;
import com.example.article27.Util.Utils;
import com.example.article27.models.Article;
import com.example.article27.models.Articles;
import com.example.article27.view_models.ArticlesFragment;
import com.example.article27.views.HomeActivity;
import com.example.article27.views.fragments.ArticleDetailFragment;
import com.example.article27.views.view_holders.ArticleItemViewHolder;

import java.util.Map;

public class ArticlesAdapter extends RecyclerView.Adapter {

    private Articles _articles;
    private Context _context;

    public ArticlesAdapter(Context context, Articles articles) {
        _articles = articles;
        _context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.article_item_view, null);
        return new ArticleItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArticleItemViewHolder articleItemViewHolder = (ArticleItemViewHolder) viewHolder;
        final Article article = _articles.getArticles().get(i);
        Glide.with(_context)
                .load(article.getMedia().get(0).getMediaMetadata().get(0).getUrl())
                .into(((ImageView) articleItemViewHolder.mIcon));
        articleItemViewHolder.tvTitle.setText(article.getTitle());
        articleItemViewHolder.tvByline.setText(article.getByLine());
        articleItemViewHolder.tvPublished_date.setText(article.getPublishedDate());
        articleItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayArticleDetail(article.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return _articles.getArticles().size();
    }

    private void displayArticleDetail(String url) {

        Fragment fragment = new ArticleDetailFragment();
        if (fragment != null) {
            Bundle bundle = new Bundle();
            bundle.putString("URL", url);
            fragment.setArguments(bundle);
            FragmentTransaction ft = ((HomeActivity) _context).getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack("article");
            ft.commit();
        }
    }

}
