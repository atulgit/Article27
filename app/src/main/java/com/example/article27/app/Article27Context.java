package com.example.article27.app;

import android.app.Application;
import android.content.Context;

public class Article27Context extends Application {

    private static Article27Context _article27Context;

    public static Context getAppContext() {
        return _article27Context;
    }

    public Article27Context() {
        _article27Context = this;
    }
}
