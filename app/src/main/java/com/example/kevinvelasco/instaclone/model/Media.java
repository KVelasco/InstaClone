package com.example.kevinvelasco.instaclone.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class Media {

    @SerializedName("images")
    @Expose
    Images images;

    @SerializedName("id")
    @Expose
    String mediaId;

    @SerializedName("user_has_liked")
    @Expose
    boolean userHasLiked;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public boolean isUserHasLiked() {
        return userHasLiked;
    }

    public void setUserHasLiked(boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }
}
