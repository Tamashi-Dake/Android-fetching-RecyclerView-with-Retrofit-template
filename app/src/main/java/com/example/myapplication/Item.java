package com.example.myapplication;

import java.io.Serializable;

public class Item implements Serializable {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Item(int userId,int id,String title, boolean completed ) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean getCompleted() {
        return completed;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
