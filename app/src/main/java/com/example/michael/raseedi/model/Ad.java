package com.example.michael.raseedi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * It is a class that represent the json which come from the api
 */
public class Ad {
    @SerializedName("picture")
    private String picture;

    @SerializedName("action")
    private String action;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("order")
    private int order;

    public Ad() {
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * It is a method that compare the value of orders of 2 ads.
     * @param ad
     * @return
     */
    public int compareTo(Ad ad) {
        return this.order > ad.order ? 1 : this.order < ad.order ? -1 : 0;
    }
}
