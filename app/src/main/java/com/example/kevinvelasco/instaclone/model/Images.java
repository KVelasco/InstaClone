package com.example.kevinvelasco.instaclone.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("low_resolution")
    @Expose
    private LowResolution lowResolution;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("standard_resolution")
    @Expose
    private StandardResolution standardResolution;

    public LowResolution getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(LowResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public StandardResolution getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(StandardResolution standardResolution) {
        this.standardResolution = standardResolution;
    }
}