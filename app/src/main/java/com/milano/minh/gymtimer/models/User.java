package com.milano.minh.gymtimer.models;

public class User {
    private int uID;
    private String userName;
    private String gender;
    private float weight;
    private int age;

    public User () {
    }
    public User(int uID, String userName, String gender, float weight, int age) {
        this.uID = uID;
        this.userName = userName;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
    }


    public User(String userName, String gender, float weight, int age) {
        this.userName = userName;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

