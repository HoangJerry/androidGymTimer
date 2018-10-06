package com.milano.minh.gymtimer.models;

public class Lesson {
    private String lesson;
    private int image;

    public Lesson(String lesson, int image) {
        this.lesson = lesson;
        this.image = image;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
