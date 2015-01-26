package com.example.kant.epiandroid.EpitechAPI;

import java.util.HashMap;
import java.util.Map;

public class User {

    private Object picture;
    private String title;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The picture
     */
    public Object getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(Object picture) {
        this.picture = picture;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
