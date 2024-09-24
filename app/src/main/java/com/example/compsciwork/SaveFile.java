package com.example.compsciwork;

import java.util.Date;

public class SaveFile {
    private String sessionName;
    private String currentState;
    private Date startDate;
    private Date lastOpened;

    public SaveFile(String sessionName, String currentState, Date startDate, Date lastOpened) {
        this.sessionName = sessionName;
        this.currentState = currentState;
        this.startDate = startDate;
        this.lastOpened = lastOpened;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastOpened() {
        return lastOpened;
    }

    public void setLastOpened(Date lastOpened) {
        this.lastOpened = lastOpened;
    }
}
