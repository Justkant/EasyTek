package com.example.kant.epiandroid.EpitechAPI;

import java.util.HashMap;
import java.util.Map;

public class Current {

    private String activeLog;
    private String creditsMin;
    private String creditsNorm;
    private String creditsObj;
    private String nslogMin;
    private String nslogNorm;
    private String semesterCode;
    private String semesterNum;
    private int achieved;
    private int failed;
    private int inprogress;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The activeLog
     */
    public String getActiveLog() {
        return activeLog;
    }

    /**
     * @param activeLog The active_log
     */
    public void setActiveLog(String activeLog) {
        this.activeLog = activeLog;
    }

    /**
     * @return The creditsMin
     */
    public String getCreditsMin() {
        return creditsMin;
    }

    /**
     * @param creditsMin The credits_min
     */
    public void setCreditsMin(String creditsMin) {
        this.creditsMin = creditsMin;
    }

    /**
     * @return The creditsNorm
     */
    public String getCreditsNorm() {
        return creditsNorm;
    }

    /**
     * @param creditsNorm The credits_norm
     */
    public void setCreditsNorm(String creditsNorm) {
        this.creditsNorm = creditsNorm;
    }

    /**
     * @return The creditsObj
     */
    public String getCreditsObj() {
        return creditsObj;
    }

    /**
     * @param creditsObj The credits_obj
     */
    public void setCreditsObj(String creditsObj) {
        this.creditsObj = creditsObj;
    }

    /**
     * @return The nslogMin
     */
    public String getNslogMin() {
        return nslogMin;
    }

    /**
     * @param nslogMin The nslog_min
     */
    public void setNslogMin(String nslogMin) {
        this.nslogMin = nslogMin;
    }

    /**
     * @return The nslogNorm
     */
    public String getNslogNorm() {
        return nslogNorm;
    }

    /**
     * @param nslogNorm The nslog_norm
     */
    public void setNslogNorm(String nslogNorm) {
        this.nslogNorm = nslogNorm;
    }

    /**
     * @return The semesterCode
     */
    public String getSemesterCode() {
        return semesterCode;
    }

    /**
     * @param semesterCode The semester_code
     */
    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    /**
     * @return The semesterNum
     */
    public String getSemesterNum() {
        return semesterNum;
    }

    /**
     * @param semesterNum The semester_num
     */
    public void setSemesterNum(String semesterNum) {
        this.semesterNum = semesterNum;
    }

    /**
     * @return The achieved
     */
    public int getAchieved() {
        return achieved;
    }

    /**
     * @param achieved The achieved
     */
    public void setAchieved(int achieved) {
        this.achieved = achieved;
    }

    /**
     * @return The failed
     */
    public int getFailed() {
        return failed;
    }

    /**
     * @param failed The failed
     */
    public void setFailed(int failed) {
        this.failed = failed;
    }

    /**
     * @return The inprogress
     */
    public int getInprogress() {
        return inprogress;
    }

    /**
     * @param inprogress The inprogress
     */
    public void setInprogress(int inprogress) {
        this.inprogress = inprogress;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
