package com.example.myapplication.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String title;
    private String employee_name;
    private String description;
    private String profile_image;

    public Item(int id,
//            String name
             String employee_name,
//            , String description
             String profile_image
    ) {
        this.id = id;
        this.employee_name = employee_name;
//        this.title = name;
//        this.description = description;
        this.profile_image = profile_image;
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

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
