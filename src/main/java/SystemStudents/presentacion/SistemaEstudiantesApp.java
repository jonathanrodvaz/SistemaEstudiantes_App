package SystemStudents.presentacion;


import SystemStudents.datos.EstudianteDAO;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Se crea una instancia de la clase servicio
        var estudianteDao = new EstudianteDAO();
        while(!salir){
            try {

                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            } catch(Exception e){
                System.out.println("Ocurrio un error en la ejecucion: " + e.getMessage());
            }
            System.out.println();
            }//Fin while

        }

        private static void mostrarMenu(){
        System.out.println("""
                *** Sistema de Estudiantes ***
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opcion:
                """);
    }
    private static boolean ejecutarOpciones(Scanner conaola, EstudianteDAO estudianteDAO){
       var opcion = Integer.parseInt(consola.nextLine());
       var salir = false;
       switch (opcion){
           case 1 -> { //Listar Estudiantes
               System.out.println("Listado de estudiantes...");
               var estudiantes = estudianteDAO.listarEstudiantes();
               estudiantes.forEach(System.out::println);
           }
           case 2 -> { //Buscar Estudiante por ID
               System.out.println("Introduce el id_estudiante a buscar: ");
               var idEstudiante = Integer.parseInt(consola.nextLine());


           }
       }

    }

    }
