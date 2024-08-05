package com.riwiJava.model;

import com.riwiJava.persistence.ConfigDB.MysqlConfig;
import com.riwiJava.repository.Nombre1CrudRepository;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Entity1Model implements Nombre1CrudRepository {


    @Override
    public boolean createNombreEntity1(Nombre1 nombre) {

        Connection objConnection = MysqlConfig.openConnection();
        Nombre1 objcoder = new Nombre1 ();

        boolean result = false;

        try {
            String slq = "INSERT INTO coder(name, lastName, document, cohorte, cv, clan) VALUES (?,?,?,?,?,?);";
            PreparedStatement pStatement = objConnection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);

            pStatement.setString(1, objCoder.getName());
            pStatement.setString(2, objCoder.getLastName());
            pStatement.setString(3, objCoder.getDocument());
            pStatement.setInt(4, objCoder.getCohorte());
            pStatement.setString(5, objCoder.getCv());
            pStatement.setString(6, objCoder.getClan());

            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Created Successfully Coder");
            }

        } catch (SQLException e) {
            System.out.println("Error creating Coder: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }

    @Override
    public List<Entity> findAll() {
        //1. Abrimos la conexion
        Connection objConnection = MysqlConfig.openConnection();
        //Instanciamos
        List<Entity> listEntity = new ArrayList<>();

        //try-catch ya que algo puede fallar
        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "select * from avion ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                Entity objEntity = new Entity();
                objEntity.setId(objResult.getString("id"));
                objEntity.setModelo(objResult.getString("modelo"));
                objEntity.setCapacidad(objResult.getInt("capacidad"));

                listEntity.add(objEntity);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MysqlConfig.closeConnection();
        return listEntity;

    }

    @Override
    public boolean updateNombre1(Nombre1 nombre) {

        Nombre1 objcoder = new Nombre1 ();
        Connection objConnection = MysqlConfig.openConnection();

        boolean result = false;

        try {
            String sql = "UPDATE coder SET name = ?, lastName = ?, document = ?, cohorte = ?, cv = ? WHERE id = ?;";
            PreparedStatement pStatement = objConnection.prepareStatement(sql);

            pStatement.setString(1, objCoder.getName());
            pStatement.setString(2, objCoder.getLastName());
            pStatement.setString(3, objCoder.getDocument());
            pStatement.setInt(4, objCoder.getCohorte());
            pStatement.setString(5, objCoder.getCv());
            pStatement.setInt(6, objCoder.getId());

            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Updated Successfully Coder");
            }

        } catch (SQLException e) {
            System.out.println("Error updating Coder: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }




    @Override
    public List<Entity> getByField(String field, String search) {
        return List.of();
    }





    @Override
    public boolean deleteNombre1(Nombre1 nombre) {
        Nombre1 objcoder = new Nombre1 ();

        boolean result = false;

        try {
            String sql = "DELETE FROM coder WHERE id = ?;";
            PreparedStatement pStatement = objConnection.prepareStatement(sql);

            pStatement.setInt(1, objCoder.getId());
            result = pStatement.executeUpdate() > 0;

            if (result) {
                JOptionPane.showMessageDialog(null, "Deleted Successfully Coder");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting Coder: " + e.getMessage() );
        }

        MysqlConfig.closeConnection();
        return result;

    }


}
