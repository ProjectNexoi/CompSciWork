package com.example.compsciwork;

import java.util.ArrayList;

public class User {
    private String username;
    private String email;

    private String uId;

    private ArrayList<SaveFile> saveFiles;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public ArrayList<SaveFile> getSaveFiles() {
        return saveFiles;
    }

    public void setSaveFiles(ArrayList<SaveFile> saveFiles) {
        this.saveFiles = saveFiles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void AddSaveFile(SaveFile s){
        saveFiles.add(s);
    }

    public void RemoveSaveFile(SaveFile s){
        saveFiles.remove(s);
    }
}

