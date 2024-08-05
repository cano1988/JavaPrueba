package com.riwiJava.repository;

import com.riwiJava.entity.Course;

import java.util.List;

public interface CourseCrudRepository {

    public boolean Course(Course course);

    public List<Course> findAll();

    public boolean updateCourse(Course course);

    public boolean deleteCourse(Course course);

    public List<Course> getByField(String field, String search);
}

