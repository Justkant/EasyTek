package com.example.kant.epiandroid.EpitechAPI;

import java.util.HashMap;
import java.util.Map;

public class Projet {

    private String title;
    private String titleLink;
    private String timelineStart;
    private String timelineEnd;
    private String timelineBarre;
    private boolean dateInscription;
    private String idActivite;
    private String soutenanceName;
    private String soutenanceLink;
    private int soutenanceDate;
    private String soutenanceSalle;
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
     * @return The titleLink
     */
    public String getTitleLink() {
        return titleLink;
    }

    /**
     * @param titleLink The title_link
     */
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    /**
     * @return The timelineStart
     */
    public String getTimelineStart() {
        return timelineStart;
    }

    /**
     * @param timelineStart The timeline_start
     */
    public void setTimelineStart(String timelineStart) {
        this.timelineStart = timelineStart;
    }

    /**
     * @return The timelineEnd
     */
    public String getTimelineEnd() {
        return timelineEnd;
    }

    /**
     * @param timelineEnd The timeline_end
     */
    public void setTimelineEnd(String timelineEnd) {
        this.timelineEnd = timelineEnd;
    }

    /**
     * @return The timelineBarre
     */
    public String getTimelineBarre() {
        return timelineBarre;
    }

    /**
     * @param timelineBarre The timeline_barre
     */
    public void setTimelineBarre(String timelineBarre) {
        this.timelineBarre = timelineBarre;
    }

    /**
     * @return The dateInscription
     */
    public boolean isDateInscription() {
        return dateInscription;
    }

    /**
     * @param dateInscription The date_inscription
     */
    public void setDateInscription(boolean dateInscription) {
        this.dateInscription = dateInscription;
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
     * @return The soutenanceName
     */
    public String getSoutenanceName() {
        return soutenanceName;
    }

    /**
     * @param soutenanceName The soutenance_name
     */
    public void setSoutenanceName(String soutenanceName) {
        this.soutenanceName = soutenanceName;
    }

    /**
     * @return The soutenanceLink
     */
    public String getSoutenanceLink() {
        return soutenanceLink;
    }

    /**
     * @param soutenanceLink The soutenance_link
     */
    public void setSoutenanceLink(String soutenanceLink) {
        this.soutenanceLink = soutenanceLink;
    }

    /**
     * @return The soutenanceDate
     */
    public int getSoutenanceDate() {
        return soutenanceDate;
    }

    /**
     * @param soutenanceDate The soutenance_date
     */
    public void setSoutenanceDate(int soutenanceDate) {
        this.soutenanceDate = soutenanceDate;
    }

    /**
     * @return The soutenanceSalle
     */
    public String getSoutenanceSalle() {
        return soutenanceSalle;
    }

    /**
     * @param soutenanceSalle The soutenance_salle
     */
    public void setSoutenanceSalle(String soutenanceSalle) {
        this.soutenanceSalle = soutenanceSalle;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
