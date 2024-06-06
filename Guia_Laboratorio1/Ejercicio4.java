package Guia_Laboratorio1;
// Laboratorio Nro 1 - Ejercicio 4
// Autor: Quiñonez Delgado Aaron

import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Creamos un arreglo de nombres
        String[] jugadores = new String[5];
        //Creamos un arreglo del nivel de cada jugador
        String[] nivel = new String[5];
        //Creamos un bucle para introducir los nombres y su respectivos niveles
        for(int indice = 0; indice < jugadores.length; indice++){
            System.out.println("Ingrese el nombre del jugador " + (indice+1) + ":");
            jugadores[indice] = sc.next();
            System.out.println("Ingrese su nivel (novato, profesional, veterano o estrella):");
            nivel[indice] = sc.next();
        }
        //Imprimimos los datos
        System.out.println("Los jugadores son:");
        for(int indice = 0; indice < jugadores.length; indice++){
            System.out.println("Jugador " + (indice+1) + ": " + jugadores[indice] + "-" + nivel[indice]);
        }
    }
}