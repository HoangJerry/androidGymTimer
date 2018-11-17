package com.milano.minh.gymtimer.models;

public class Execise {
    private int id;
    private String name;
    private String content;
    private byte[] picture;

    public Execise(int id, String name, String content, byte[] picture) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}

