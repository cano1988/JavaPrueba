package com.riwiJava.entity;

public class Student {

    private int id;
    private String name;
    private String email;
    private String statu;
    private String courseSigned;


    public Student() {
    }

    public Student(int id, String name, String email, String statu, String courseSigned) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.statu = statu;
        this.courseSigned = courseSigned;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getCourseSigned() {
        return courseSigned;
    }

    public void setCourseSigned(String courseSigned) {
        this.courseSigned = courseSigned;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", name: " + name +
                ", email: " + email +
                ", statu: " + statu +
                ", courseSigned: " + courseSigned;


    }
}
