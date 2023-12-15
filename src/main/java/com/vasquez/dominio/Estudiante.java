/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vasquez.dominio;

/**
 *
 * @author klogew
 */
public class Estudiante {

    private int idEstudiante;
    private String nombre, apellido, telefono, email;

    public Estudiante() {} // constructor vacio

    // Este constructor se usaria para eliminar o buscar
    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    // Este constructor se usaria para listar
    public Estudiante(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }
    
    // Este constructor se usaria para actualizar
    public Estudiante(int idEstudiante, String nombre, String apellido, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters & Setters
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    // Para imprimir objetos
    @Override
    public String toString() {
        return "Estudiante{" + 
                "\n  idEstudiante=" + idEstudiante + 
                ", \n  nombre=" + nombre + 
                ", \n  apellido=" + apellido + 
                ", \n  telefono=" + telefono + 
                ", \n  email=" + email + 
                System.lineSeparator() + '}';
    }
    
    
}
