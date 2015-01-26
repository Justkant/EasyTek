package com.example.kant.epiandroid.EpitechAPI;

import java.util.HashMap;
import java.util.Map;

public class Activite {

    private String title;
    private String module;
    private String moduleLink;
    private String moduleCode;
    private String titleLink;
    private String timelineStart;
    private String timelineEnd;
    private String timelineBarre;
    private String dateInscription;
    private String salle;
    private String intervenant;
    private Object token;
    private String tokenLink;
    private String registerLink;
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
     * @return The module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module The module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return The moduleLink
     */
    public String getModuleLink() {
        return moduleLink;
    }

    /**
     * @param moduleLink The module_link
     */
    public void setModuleLink(String moduleLink) {
        this.moduleLink = moduleLink;
    }

    /**
     * @return The moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * @param moduleCode The module_code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
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
    public String getDateInscription() {
        return dateInscription;
    }

    /**
     * @param dateInscription The date_inscription
     */
    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * @return The salle
     */
    public String getSalle() {
        return salle;
    }

    /**
     * @param salle The salle
     */
    public void setSalle(String salle) {
        this.salle = salle;
    }

    /**
     * @return The intervenant
     */
    public String getIntervenant() {
        return intervenant;
    }

    /**
     * @param intervenant The intervenant
     */
    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    /**
     * @return The token
     */
    public Object getToken() {
        return token;
    }

    /**
     * @param token The token
     */
    public void setToken(Object token) {
        this.token = token;
    }

    /**
     * @return The tokenLink
     */
    public String getTokenLink() {
        return tokenLink;
    }

    /**
     * @param tokenLink The token_link
     */
    public void setTokenLink(String tokenLink) {
        this.tokenLink = tokenLink;
    }

    /**
     * @return The registerLink
     */
    public String getRegisterLink() {
        return registerLink;
    }

    /**
     * @param registerLink The register_link
     */
    public void setRegisterLink(String registerLink) {
        this.registerLink = registerLink;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
