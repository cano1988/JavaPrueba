package com.riwiJava.model;

import com.riwiJava.entity.Student;
import com.riwiJava.persistence.ConfigDB.MysqlConfig;
import com.riwiJava.repository.StudentCrudRepository;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements StudentCrudRepository {


    @Override
    public boolean createStudent(Student student) {

        Connection objConnection = MysqlConfig.openConnection();
        Student objstudent = new Student ();

        boolean result = false;

        try {
            String slq = "INSERT INTO student(name, email, statu, courseSigned) VALUES (?,?,?,?);";
            PreparedStatement pStatement = objConnection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);

            pStatement.setString(1, objstudent.getName());
            pStatement.setString(2, objstudent.getEmail());
            pStatement.setBoolean(3, objstudent.getStatu());
            pStatement.setString(4, objstudent.getCourseSigned());


            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Created Successfully Student");
            }

        } catch (SQLException e) {
            System.out.println("Error creating Coder: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }

    @Override
    public List<Student> findAll() {
        //1. Abrimos la conexion
        Connection objConnection = MysqlConfig.openConnection();
        //Instanciamos
        List<Student> listStudent = new ArrayList<>();

        //try-catch ya que algo puede fallar

        try {
            //3. Creo la sentencia SQL
            String sql = "select * from student ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                 Student objStudent = new Student();
               objStudent.setId(objResult.getInt("name"));
               objStudent.setEmail(objResult.getString("email"));
               objStudent.setStatu(String.valueOf(objResult.getBoolean("statu")));
               objStudent.setCourseSigned(objResult.getString("courseSigned"));

                listStudent.add(objStudent);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MysqlConfig.closeConnection();
        return listStudent;

    }

    @Override
    public boolean updateStudent(Student student) {

        Student objStudent = new Student ();
        Connection objConnection = MysqlConfig.openConnection();

        boolean result = false;

        try {
            String sql = "UPDATE student SET name = ?, email = ?, statu = ?, courseSigned = ?  WHERE id = ?;";
            PreparedStatement pStatement = objConnection.prepareStatement(sql);

            pStatement.setString(1, objStudent.getName());
            pStatement.setString(2, objStudent.getEmail());
            pStatement.setBoolean(3, objStudent.getStatu());
            pStatement.setString(4, objStudent.getCourseSigned());


            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Updated Successfully Student");
            }

        } catch (SQLException e) {
            System.out.println("Error updating Student: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }




    @Override
    public List<Student> getByField(String field, String search) {

        return List.of();
    }





    @Override
    public boolean deleteStudent(Student student) {
        Connection objConnection = MysqlConfig.openConnection();
        Student objStudent = new Student ();

        boolean result = false;

        try {
            String sql = "DELETE FROM coder WHERE id = ?;";
            PreparedStatement pStatement = objConnection.prepareStatement(sql);

            pStatement.setInt(1, objStudent.getId());
            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Deleted Successfully Student");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting Student: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }


}
