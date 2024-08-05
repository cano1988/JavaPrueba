package com.riwiJava.entity;

public class Inscription {

    private int id;
    private String description;
    private int courseId;

    public Inscription() {
    }

    public Inscription(int id, String description, int courseId) {
        this.id = id;
        this.description = description;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return  " id: " + id +
                " description: " + description +
                " courseId: " + courseId;

    }
}
