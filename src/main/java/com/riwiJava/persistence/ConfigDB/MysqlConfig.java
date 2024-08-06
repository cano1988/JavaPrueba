package com.riwiJava.persistence.ConfigDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig {

    //Creamos un atributo statis para la clase, con static puede ser reutilizado en otras clases
    public static Connection objConnection = null;

    public static Connection openConnection() {

        // Las conexiones pueden fallar por ende se crea un try catch
        try {
            //clase para traer el  Driver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configurar credenciales
            String url = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
            String user = "root";
            String password = "Rlwl2023."; //

            objConnection = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to database");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver not found " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: Database failed (open)" + e.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection() {
        try {

            if (objConnection != null) {
                objConnection.close();
                System.out.println("Connection closed");
            }

        } catch (SQLException e) {
            System.out.println("Error: Database failed (close)" + e.getMessage());
        }
    }



}
