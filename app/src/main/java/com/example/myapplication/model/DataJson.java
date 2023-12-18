package com.example.myapplication.model;

import java.util.List;

public class DataJson<T> {
    private String status;
    private List<T> data;
    private String message;

    public DataJson() {
    }

    public DataJson(String status, List<T> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
