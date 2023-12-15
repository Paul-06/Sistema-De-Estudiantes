/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vasquez.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author klogew
 */
public class Conexion {

    public static Connection obtenerConexion() {
        Connection conexion = null;
        String bd = "estudiantes_db";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        String usuario = "root";
        String contrasenia = ""; // Colocamos la contrasenia del usuario root

        // Cargamos la clase del driver de mysql en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrio un error en la conexion: " + e.getMessage());
        }

        return conexion;
    }
    
    public static void main(String[] args) {
        Connection conexion = Conexion.obtenerConexion();
        
        if (conexion != null) {
            System.out.println("Conexion exitosa: " + conexion);
        } else {
            System.out.println("Error al conectarse.");
        }
    }
}
