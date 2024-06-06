package Guia_Laboratorio1;
// Laboratorio Nro 1 - Ejercicio 3
// Autor: Quiñonez Delgado Aaron

import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Declaramos y dimensionamos el arreglo de tamaño 5
        String[] jugadores = new String[5];
        //Creamos un bucle para guardar los datos
        for(int indice = 0; indice < jugadores.length; indice++){
            System.out.println("Ingrese el nombre del jugador " + (indice+1) + ":");
            jugadores[indice] = sc.next();
        }
        //Imprimimos todos los jugadores
        System.out.println("\nLos jugadores son:");
        for(int indice = 0; indice < jugadores.length; indice++){
            System.out.println("Jugador " + (indice+1) + ": " + jugadores[indice]);
        }
    }
}