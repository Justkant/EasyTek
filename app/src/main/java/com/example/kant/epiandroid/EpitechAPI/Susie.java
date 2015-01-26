package com.example.kant.epiandroid.EpitechAPI;

import java.util.HashMap;
import java.util.Map;

public class Susie {

    private String title;
    private String creneauLink;
    private String timelineStart;
    private boolean timelineBarre;
    private boolean timelineEnd;
    private boolean salle;
    private boolean intervenant;
    private String etat;
    private boolean type;
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
     * @return The creneauLink
     */
    public String getCreneauLink() {
        return creneauLink;
    }

    /**
     * @param creneauLink The creneau_link
     */
    public void setCreneauLink(String creneauLink) {
        this.creneauLink = creneauLink;
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
     * @return The timelineBarre
     */
    public boolean isTimelineBarre() {
        return timelineBarre;
    }

    /**
     * @param timelineBarre The timeline_barre
     */
    public void setTimelineBarre(boolean timelineBarre) {
        this.timelineBarre = timelineBarre;
    }

    /**
     * @return The timelineEnd
     */
    public boolean isTimelineEnd() {
        return timelineEnd;
    }

    /**
     * @param timelineEnd The timeline_end
     */
    public void setTimelineEnd(boolean timelineEnd) {
        this.timelineEnd = timelineEnd;
    }

    /**
     * @return The salle
     */
    public boolean isSalle() {
        return salle;
    }

    /**
     * @param salle The salle
     */
    public void setSalle(boolean salle) {
        this.salle = salle;
    }

    /**
     * @return The intervenant
     */
    public boolean isIntervenant() {
        return intervenant;
    }

    /**
     * @param intervenant The intervenant
     */
    public void setIntervenant(boolean intervenant) {
        this.intervenant = intervenant;
    }

    /**
     * @return The etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat The etat
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return The type
     */
    public boolean isType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(boolean type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
