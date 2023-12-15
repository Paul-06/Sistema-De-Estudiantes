/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vasquez.datos;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.vasquez.dominio.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
// import static para utilizar directamente el metodo
// recordemos la clase conexion es estatica
import static com.vasquez.conexion.Conexion.obtenerConexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author klogew
 */
public class EstudianteDAO {

    public List<Estudiante> listarEstudiantes() {

        // Creamos nuestra de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        // Preparamos todo para la consulta y obtencion de datos
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = obtenerConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante")); // usamos getInt() porque el id es un entero
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                estudiantes.add(estudiante); // Agregamos cada nuevoEstudiante a la lista
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al seleccionar los datos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al intentar cerrar la conexion: " + e.getMessage());
            }
        }

        return estudiantes;

    } // end listarEstudiantes()

    public boolean buscarEstudiantePorID(Estudiante estudiante) {
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = obtenerConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, estudiante.getIdEstudiante()); // usamos setInt() por que el id es un entero

            rs = pstmt.executeQuery();

            if (rs.next()) { // si existe el registro
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                return true;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al buscar al estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
    } // end buscarEstudiantePorID()

    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement pstmt;
        Connection con = obtenerConexion();
        String sql = "INSERT INTO estudiante (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, estudiante.getNombre()); // usamos setString() porque los datos son cadenas de texto
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getTelefono());
            pstmt.setString(4, estudiante.getEmail());

            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar el estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
    } // end agregarEstudiante()

    public boolean modificarEstudiante(Estudiante estudiante) {
        PreparedStatement pstmt;
        Connection con = obtenerConexion();
        String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, "
                + "telefono = ?, email = ? WHERE id_estudiante = ?";

        try {
            pstmt = con.prepareStatement(sql); // Preparamos la consulta
            pstmt.setString(1, estudiante.getNombre());
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getTelefono());
            pstmt.setString(4, estudiante.getEmail());
            pstmt.setInt(5, estudiante.getIdEstudiante());

            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al modificar el estudiante. " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
    } // end modificarEstudiante()

    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement pstmt;
        Connection con = obtenerConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, estudiante.getIdEstudiante());

            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Ocurrio un problemar al eliminar el estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
    } // end eliminarEstudiante()

}
