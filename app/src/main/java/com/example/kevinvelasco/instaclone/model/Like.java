package com.example.kevinvelasco.instaclone.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Like {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private Object data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
