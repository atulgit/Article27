package com.example.article27.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Media extends BusinessObject {


    @SerializedName("media-metadata")
    @Expose
    private ArrayList<MediaMetadata> _media_meta;

    public ArrayList<MediaMetadata> getMediaMetadata(){
        return _media_meta;
    }

    public static class MediaMetadata extends BusinessObject {

        @SerializedName("url")
        private String url;

        @SerializedName("height")
        private int height;

        @SerializedName("width")
        private int width;

        public String getUrl() {
            return url;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

    }
}
