package com.riwiJava.model;

import com.riwiJava.entity.Student;
import com.riwiJava.persistence.ConfigDB.MysqlConfig;
import com.riwiJava.repository.StudentCrudRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscriptionModel implements StudentCrudRepository {


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
            pStatement.setString(3, objstudent.getStatu());
            pStatement.setString(4, objstudent.getCourseSigned());


            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Created Successfully Student");
            }

        } catch (SQLException e) {
            System.out.println("Error creating Student: " + e.getMessage() );
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
            pStatement.setString(3, objStudent.getStatu());
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

        Connection objConnection = MysqlConfig.openConnection();
        List<Student> filter = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder WHERE "+ field +" = ?;";

            PreparedStatement pStatement = objConnection.prepareStatement(sql);

            switch (field) {
                case "student.email":
                    pStatement.setString(1, search);
                    break;

                case "student.id":
                    pStatement.setInt(1, Integer.parseInt(search));
                    break;
            }

            ResultSet rs = pStatement.executeQuery();
            fillStudent(filter, rs);

        } catch (SQLException e) {
            System.out.println("Error finding Coder: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return filter;
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

    private void fillStudent(List<Student> list, ResultSet rs) {

        try {
            while (rs.next()) {
                Student objCoder = new Student();

                objCoder.setId(rs.getInt("student.id"));
                objCoder.setName(rs.getString("student.name"));
                objCoder.setEmail(rs.getString("student.email"));
                objCoder.setStatu(String.valueOf(rs.getBoolean("student.statu")));
                objCoder.setCourseSigned(rs.getString("student.courseSigned"));


                list.add(objCoder);
            }
        } catch (SQLException e) {
            System.out.println("Error fill Student: " + e.getMessage() );
        }
    }


}
