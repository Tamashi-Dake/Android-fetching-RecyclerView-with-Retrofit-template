package com.example.myapplication;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String title;
//    private String description;
//    private String imageUrl;

    public Item(int id,String name
//            , String description, String imageUrl
    ) {
        this.id = id;
        this.title = name;
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
}
