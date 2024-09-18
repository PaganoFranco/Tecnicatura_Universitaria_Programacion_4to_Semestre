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
        }
    }
}