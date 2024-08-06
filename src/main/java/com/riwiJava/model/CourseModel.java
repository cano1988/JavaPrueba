package com.riwiJava.model;

import com.riwiJava.entity.Course;
import com.riwiJava.persistence.ConfigDB.MysqlConfig;
import com.riwiJava.repository.CourseCrudRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CourseModel implements CourseCrudRepository {
    @Override
    public boolean createCourse(Course course) {



            Connection objConnection = MysqlConfig.openConnection();


            boolean result = false;

            try {
                String slq = "INSERT INTO course(name, studentId) VALUES (?,?);";
                PreparedStatement pStatement = objConnection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);

                pStatement.setString(1,course.getName());
                pStatement.setInt(2, course.getStudentId());


                result = pStatement.executeUpdate() > 0;

                if (result) {
                    JOptionPane.showMessageDialog(null, "Created Successfully Course");
                }

            } catch (SQLException e) {
                System.out.println("Error creating Course: " + e.getMessage() );
            }

            MysqlConfig.closeConnection();
            return result;



    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public boolean updateCourse(Course course) {
        return false;
    }

    @Override
    public boolean deleteCourse(Course course) {
        return false;
    }

    @Override
    public List<Course> getByField(String field, String search) {
        return null;
    }
}
