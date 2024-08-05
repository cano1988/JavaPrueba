package com.riwiJava.entity;

public class Course {

    private int id;
    private String name;
    private int studentId ;


    public Course() {
    }

    public Course(int id, String name, int studentId) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " name='" + name +
                " studentId: " + studentId
                ;
    }
}
