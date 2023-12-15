/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vasquez.presentacion;

import com.vasquez.datos.EstudianteDAO;
import com.vasquez.dominio.Estudiante;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author klogew
 */
public class SistemaEstudiantesApp {

    public static void main(String[] args) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(sc, estudianteDAO);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        } // end while
    }

    public static void mostrarMenu() {
        System.out.println("""
                           *** Sistema de Estudiantes ***
                           1. Listar estudiantes
                           2. Buscar estudiante
                           3. Agregar estudiante
                           4. Modificar estudiante
                           5. Eliminar estudiante
                           6. Salir
                           """);

        System.out.print("Elija una opción: ");
    }

    public static boolean ejecutarOpciones(Scanner sc, EstudianteDAO estudianteDAO) {
        boolean salir = false;
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("");
        
        switch (opcion) {
            case 1 -> {
                List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
                System.out.println("");
            }
            case 2 -> {
                System.out.print("Proporcione el ID del estudiante: ");
                int id = Integer.parseInt(sc.nextLine());
                Estudiante estudiante = new Estudiante(id);
                boolean encontrado = estudianteDAO.buscarEstudiantePorID(estudiante);
                
                if (encontrado) {
                    System.out.println("\nEstudiante encontrado: " + estudiante);
                    System.out.println("");
                } else {
                    System.out.println("\nEstudiante no econtrado. Identificador " 
                            + estudiante.getIdEstudiante() + " no valido.\n");
                }
            }
            case 3 -> {
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Ingrese el telefono: ");
                String telefono = sc.nextLine();
                System.out.print("Ingrese el email: ");
                String email = sc.nextLine();
                
                Estudiante estudiante = new Estudiante(nombre, apellido, telefono, email);
                boolean agregado = estudianteDAO.agregarEstudiante(estudiante);
                
                if (agregado) {
                    System.out.println("\nEstudiante agregado satisfactoriamente.\n");
                } else {
                    System.out.println("\nNo se pudo agregar al estudiante: " + estudiante);
                    System.out.println("");
                }
            }
            case 4 -> {
                System.out.print("Ingrese el ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Ingrese el telefono: ");
                String telefono = sc.nextLine();
                System.out.print("Ingrese el email: ");
                String email = sc.nextLine();
                
                Estudiante estudiante = new Estudiante(id, nombre, apellido, telefono, email);
                boolean modificado = estudianteDAO.modificarEstudiante(estudiante);
                
                if (modificado) {
                    System.out.println("\nEstudiante modificado correctamente: " + estudiante);
                } else {
                    System.out.println("\nNo se pudo modificar al estudiante: " + estudiante);
                }
            }
            case 5 -> {
                System.out.print("Ingrese el ID del estudiante: ");
                int id = Integer.parseInt(sc.nextLine());
                
                Estudiante estudiante = new Estudiante(id);
                boolean eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                
                if (eliminado) {
                    System.out.println("\nEstudiante eliminado correctamente: " + estudiante);
                } else {
                    System.out.println("\nNo se pudo eliminar al estudiante: " + estudiante);
                }
            }
            case 6 -> {
                System.out.println("\nHasta pronto!");
                salir = true;
            }
            default -> System.out.println("\nOpcion no reconocida: " + opcion);
        }
        return salir;
    }
 
}
