package com.example.kant.epiandroid.EpitechAPI;

import java.util.HashMap;
import java.util.Map;

public class History {

    private String title;
    private User user;
    private String content;
    private String date;
    private String id;
    private String visible;
    private String idActivite;
    private String _class;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The visible
     */
    public String getVisible() {
        return visible;
    }

    /**
     * @param visible The visible
     */
    public void setVisible(String visible) {
        this.visible = visible;
    }

    /**
     * @return The idActivite
     */
    public String getIdActivite() {
        return idActivite;
    }

    /**
     * @param idActivite The id_activite
     */
    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    /**
     * @return The _class
     */
    public String getClass_() {
        return _class;
    }

    /**
     * @param _class The class
     */
    public void setClass_(String _class) {
        this._class = _class;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
