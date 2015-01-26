package com.example.kant.epiandroid.EpitechAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeInfos {

    private String ip;
    private Board board;
    private List<History> history = new ArrayList<History>();
    private Infos infos;
    private Current current;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip The ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board The board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return The history
     */
    public List<History> getHistory() {
        return history;
    }

    /**
     * @param history The history
     */
    public void setHistory(List<History> history) {
        this.history = history;
    }

    /**
     * @return The infos
     */
    public Infos getInfos() {
        return infos;
    }

    /**
     * @param infos The infos
     */
    public void setInfos(Infos infos) {
        this.infos = infos;
    }

    /**
     * @return The current
     */
    public Current getCurrent() {
        return current;
    }

    /**
     * @param current The current
     */
    public void setCurrent(Current current) {
        this.current = current;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
