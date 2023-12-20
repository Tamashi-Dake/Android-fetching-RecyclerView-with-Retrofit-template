package com.example.myapplication;

import java.io.Serializable;

public class Item implements Serializable {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Item(int userId,int id,String title, String body ) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
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



    public String getBody() {
        return body;
    }


}
