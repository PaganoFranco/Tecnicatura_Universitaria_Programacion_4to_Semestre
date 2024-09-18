package UTN.presentacion;

import UTN.datos.EstudianteDAO;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false; // recuerden esto ya lo hicimos antes
        var consola = new Scanner(System.in); // Para leer informacion de la consola
        // se crea una instancia de la clase servicio, esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO(); // Esta instancia se hacer una unica vez
        while(!salir){
            try{
                mostrarMenu(); // Esto sera el metodo que devolvera un booleano
                salir = ejecutarOpciones(consola, estudianteDao); // Esto arroja una expresion
            } catch(Exception e){
                System.out.println("Ocurrio un error al ejecutar la operacion " + e.getMessage());
            }
        }// Fin while
    }// Fin main

private static void mostrarMenu(){
    System.out.println("""
            ******** Sistema de Estudiantes ********
            1. Listar Estudiantes
            2. Buscar Estudiantes
            3. Agregar Estudiantes
            4. Modificar Estudiantes
            5. Eliminar Estudiante
            6. Salir
            Elige una opcion: 
            """);
}

// Metodo para ejecutar las opciones, va a regresar un valor booleano, ya que es el que
    // puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes... ");
                // No mostrar la informacion, solo recupera informacion y regresa una lista
                var estudiantes = estudianteDAO.ListarEstudiantes(); // Recibe el listado
                // Vamos a tener cada objeto de tipo estudiante

            }
        }
    }

}
