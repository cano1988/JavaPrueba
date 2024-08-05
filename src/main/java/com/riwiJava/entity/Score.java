package com.riwiJava.entity;

public class Score {

    private int id;
    private String description;
    private int  studentId;

    public Score() {
    }

    public Score(int id, String description, int studentId) {
        this.id = id;
        this.description = description;
        this.studentId = studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                " description: " + description +
                " studentId=" + studentId;

    }
}
