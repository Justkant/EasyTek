package com.example.kant.epiandroid.EpitechAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private List<Projet> projets = new ArrayList<Projet>();
    private List<Object> notes = new ArrayList<Object>();
    private List<Susie> susies = new ArrayList<Susie>();
    private List<Activite> activites = new ArrayList<Activite>();
    private List<Module> modules = new ArrayList<Module>();
    private List<Object> stages = new ArrayList<Object>();
    private List<Object> tickets = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The projets
     */
    public List<Projet> getProjets() {
        return projets;
    }

    /**
     * @param projets The projets
     */
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    /**
     * @return The notes
     */
    public List<Object> getNotes() {
        return notes;
    }

    /**
     * @param notes The notes
     */
    public void setNotes(List<Object> notes) {
        this.notes = notes;
    }

    /**
     * @return The susies
     */
    public List<Susie> getSusies() {
        return susies;
    }

    /**
     * @param susies The susies
     */
    public void setSusies(List<Susie> susies) {
        this.susies = susies;
    }

    /**
     * @return The activites
     */
    public List<Activite> getActivites() {
        return activites;
    }

    /**
     * @param activites The activites
     */
    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    /**
     * @return The modules
     */
    public List<Module> getModules() {
        return modules;
    }

    /**
     * @param modules The modules
     */
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    /**
     * @return The stages
     */
    public List<Object> getStages() {
        return stages;
    }

    /**
     * @param stages The stages
     */
    public void setStages(List<Object> stages) {
        this.stages = stages;
    }

    /**
     * @return The tickets
     */
    public List<Object> getTickets() {
        return tickets;
    }

    /**
     * @param tickets The tickets
     */
    public void setTickets(List<Object> tickets) {
        this.tickets = tickets;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
