package com.example.article27.views.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.article27.R;

public class ArticleItemViewHolder extends RecyclerView.ViewHolder {

    public View mView;
    public View mIcon;
    public TextView tvTitle;
    public TextView tvByline;
    public TextView tvPublished_date;

    public ArticleItemViewHolder(View view) {
        super(view);
        mView = view;
        mIcon = view.findViewById(R.id.icon);
        tvTitle = view.findViewById(R.id.title);
        tvByline =  view.findViewById(R.id.byline);
        tvPublished_date =  view.findViewById(R.id.published_date);
    }
}
