package Guia_Laboratorio1;
// Laboratorio Nro 1 - Ejercicio 2
// Autor: Quiñonez Delgado Aaron

import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nombre1, nombre2, nombre3, nombre4, nombre5;
        String nivelJugador1, nivelJugador2, nivelJugador3, nivelJugador4, nivelJugador5;
        //Ingresamos los nombres y niveles de jugadores
        System.out.println("Ingrese el nombre del jugador 1:");
        nombre1 = sc.next();
        System.out.println("Ingrese su nivel (novato, profesional, veterano o estrella):");
        nivelJugador1 = sc.next();

        System.out.println("Ingrese el nombre del jugador 2:");
        nombre2 = sc.next();
        System.out.println("Ingrese su nivel (novato, profesional, veterano o estrella):");
        nivelJugador2 = sc.next();

        System.out.println("Ingrese el nombre del jugador 3:");
        nombre3 = sc.next();
        System.out.println("Ingrese su nivel (novato, profesional, veterano o estrella):");
        nivelJugador3 = sc.next();

        System.out.println("Ingrese el nombre del jugador 4:");
        nombre4 = sc.next();
        System.out.println("Ingrese su nivel (novato, profesional, veterano o estrella):");
        nivelJugador4 = sc.next();

        System.out.println("Ingrese el nombre del jugador 5:");
        nombre5 = sc.next();
        System.out.println("Ingrese su nivel (novato, profesional, veterano o estrella):");
        nivelJugador5 = sc.next();

        //Imprimimos la lista de jugadores
        System.out.println("\nLos jugadores son:");
        System.out.print("Jugador 1: " + nombre1 + "-" + nivelJugador1 + "\nJugador 2: " + nombre2 + "-" 
        + nivelJugador2 + "\nJugador 3: " + nombre3 + "-" + nivelJugador3 + "\nJugador 4: " 
        + nombre4 + "-" + nivelJugador4 + "\nJugador 5: " + nombre5 + "-" + nivelJugador5);
    }
}