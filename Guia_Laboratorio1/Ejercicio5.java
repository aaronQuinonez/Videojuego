package Guia_Laboratorio1;
// Laboratorio Nro 1 - Ejercicio 5
// Autor: Quiñonez Delgado Aaron

import java.util.*;
public class Ejercicio5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Creamos ambos equipos de 21 jugadores
        String[] equipo1 = new String[21];
        String[] equipo2 = new String[21];
        //Usamos el metodo asignarNombres para establecer a cada jugador de los 2 equipos
        equipo1 = asignarNombres(equipo1);
        equipo2 = asignarNombres(equipo2);
        //Inicializamos los equipos titulares
        String[] titulares1 = new String[11];
        String[] titulares2 = new String[11];
        //Asignamos de manera aleatoria los titulares con el metodo asignarJugadores
        titulares1 = asignarJugadores(equipo1, titulares1);
        titulares2 = asignarJugadores(equipo2, titulares2);
         //Usamos el metodo mostrarEquipo para mostrar los titulares de cada equipo
         System.out.println("EQUIPO 1:");
         mostrarEquipo(titulares1);
         System.out.println("EQUIPO 2:");
         mostrarEquipo(titulares2);
        //Mostramos el resultado del partido
        resultadoPartido();
    }
    public static String[] asignarNombres(String[] nombres){
        for(int indice = 0; indice < nombres.length; indice++){
            String nombre = "Jugador";
            //Asignamos el nombre de cada jugador segun la posicion del indice más uno
            nombre += String.valueOf(indice+1);
            nombres[indice] = nombre;
        }
        return nombres;
    }

    public static void mostrarEquipo(String[] nombres){
        //Imprime a todo el equipo titular
        for(int indice = 0; indice < nombres.length; indice++){
            System.out.println("    -"+nombres[indice]);
        }
    }

    public static String[] asignarJugadores(String[] jugadores, String[] titulares){
        //Creamos un array de tipo boolean para asignar jugadores de manera aleatoria y sin repetirse
        //Será false si el jugador no fue escogido, será true si ya fue escogido como titular
        boolean[] esTitular = new boolean[jugadores.length];
        //Asignamos un bucle que se repetirá 11 veces(titulares.length) para asignar a los titulares
        for(int indice = 0; indice < titulares.length; indice++){
            //Creamos un entero que será aleatorio entre 0 y 20 (indice del equipo de 21 jugadores)
            int random = (int) (Math.random()*20);
            if(!esTitular[random]){
                esTitular[random] = true;
                //Usamos la posición 'random' del array jugadores y lo asignamos al array de titulares
                titulares[indice] = jugadores[random];
            }
            //Si esTitular[random] es true entonces restamos 1 al indice para asegurarnos de llenar las 11 posiciones de los titulares
            else
                indice--;
        }
        return titulares;
    }

    public static void resultadoPartido(){
        int golesEquipo1 = (int) (Math.random()*6);
        int golesEquipo2 = (int) (Math.random()*6);
        System.out.println("El resultado fue: " + golesEquipo1 + "-" + golesEquipo2);
        if(golesEquipo1 == golesEquipo2)
            System.out.println("ES UN EMPATE");
        else if(golesEquipo1 > golesEquipo2)
            System.out.println("GANO EL EQUIPO 1");
        else
            System.out.println("GANO EL EQUIPO 2");
    }
}