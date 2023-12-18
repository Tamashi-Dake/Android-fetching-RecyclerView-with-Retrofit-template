package com.example.myapplication.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String title;
    private String employee_name;
    private String description;
    private String imageUrl;

    public Item(int id
//            ,String name
            , String employee_name
//            , String description, String imageUrl
    ) {
        this.id = id;
        this.employee_name = employee_name;
//        this.title = name;
//        this.description = description;
//        this.imageUrl = imageUrl;
    }
    public String getName() {
        return title;
    }
//    public String getDescription() {
//        return description;
//    }
    public int getId() {
        return id;
    }
//    public String getImageUrl() {
//        return imageUrl;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
}
