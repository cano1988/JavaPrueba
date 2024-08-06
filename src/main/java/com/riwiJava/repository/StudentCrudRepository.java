package com.riwiJava.repository;

import com.riwiJava.entity.Student;

import java.util.List;

public interface StudentCrudRepository {

    public boolean createStudent(Student student);

    public List<Student> findAll();

    public boolean updateStudent(Student student);

    public boolean deleteStudent(Student student);

    public List<Student> getByField(String field, String search);
}

