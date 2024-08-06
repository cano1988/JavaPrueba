package com.riwiJava.model;

import com.riwiJava.entity.Inscription;
import com.riwiJava.entity.Student;
import com.riwiJava.persistence.ConfigDB.MysqlConfig;
import com.riwiJava.repository.InscriptionCrudRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscriptionModel implements InscriptionCrudRepository {


    @Override
    public boolean createInscription(Inscription inscription) {

        Connection objConnection = MysqlConfig.openConnection();


        boolean result = false;

        try {
            String slq = "INSERT INTO inscription(description, courseId) VALUES (?,?);";
            PreparedStatement pStatement = objConnection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);

            pStatement.setString(1, inscription.getDescription());
            pStatement.setInt(2, inscription.getCourseId());



            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Created Successfully Inscription");
            }

        } catch (SQLException e) {
            System.out.println("Error creating Inscription: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }

    @Override
    public List<Inscription> findAll() {
        //1. Abrimos la conexion
        Connection objConnection = MysqlConfig.openConnection();
        //Instanciamos
        List<Inscription> listStudent = new ArrayList<>();

        //try-catch ya que algo puede fallar

        try {
            //3. Creo la sentencia SQL
            String sql = "select * from student ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                 Inscription objInscription = new Inscription();
               objInscription.setId(objResult.getInt("description"));
               objInscription.setCourseId(objResult.getInt("courseId"));


                listStudent.add(objInscription);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MysqlConfig.closeConnection();
        return listStudent;

    }

    @Override
    public boolean updateInscription(Inscription inscription) {
        return false;
    }

    @Override
    public boolean deleteInscription(Inscription inscription) {
        return false;
    }





    @Override
    public List<Inscription> getByField(String field, String search) {

        Connection objConnection = MysqlConfig.openConnection();
        List<Inscription> filter = new ArrayList<>();

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


        } catch (SQLException e) {
            System.out.println("Error finding Coder: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return filter;
    }






    @Override
    public boolean deleteInscription(Student student) {


        return false;
    }

    private void fillStudent(List<Student> list, ResultSet rs) {

        try {
            while (rs.next()) {
                Student objCoder = new Student();

                objCoder.setId(rs.getInt("student.id"));
                objCoder.setName(rs.getString("student.name"));
                objCoder.setEmail(rs.getString("student.email"));
                objCoder.setStatu(rs.getBoolean("student.statu"));
                objCoder.setCourseSigned(rs.getString("student.courseSigned"));


                list.add(objCoder);
            }
        } catch (SQLException e) {
            System.out.println("Error fill Student: " + e.getMessage() );
        }
    }


}
