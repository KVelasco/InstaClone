package com.example.kevinvelasco.instaclone.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediaSearchResponse {

    @SerializedName("data")
    @Expose
    List<Media> media;

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
