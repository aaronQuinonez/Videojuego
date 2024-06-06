package Guia_Laboratorio1;
// Laboratorio Nro 1 - Ejercicio 1
// Autor: Quiñonez Delgado Aaron
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nombre1, nombre2, nombre3, nombre4, nombre5;
        //Ingresamos los nombres de jugadores
        System.out.println("Ingrese el nombre del jugador 1:");
        nombre1 = sc.next();
        System.out.println("Ingrese el nombre del jugador 2:");
        nombre2 = sc.next();
        System.out.println("Ingrese el nombre del jugador 3:");
        nombre3 = sc.next();
        System.out.println("Ingrese el nombre del jugador 4:");
        nombre4 = sc.next();
        System.out.println("Ingrese el nombre del jugador 5:");
        nombre5 = sc.next();
        //Imprimimos la lista de jugadores
        System.out.println("\nLos jugadores son:");
        System.out.print("Jugador 1: " + nombre1 + "\nJugador 2: " + nombre2 + 
        "\nJugador 3: " + nombre3 + "\nJugador 4: " + nombre4 + "\nJugador 5: " + nombre5);
    }
}