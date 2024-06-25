package Laboratorio16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(1<2){
            System.out.println("Seleccione una opción:\n(1)Comenzar juego\n(2)Salir");
            int opcion = sc.nextInt();
            if(opcion == 1){
                //JUEGO
                //Creamos la clase ejército que contendra a los espadachines, arqueros y caballeros
                Ejercito ejercito1 = new Ejercito();
                ejercito1.asignarEstadisticas();
                ejercito1.establecerEquipo(1);
                ejercito1.asignarNombres();

                Ejercito ejercito2 = new Ejercito();
                ejercito2.asignarEstadisticas();
                ejercito2.establecerEquipo(2);
                ejercito2.asignarNombres();

                System.out.println("EJERCITO 1: \n" + ejercito1.toString());
            }else if(opcion == 2){

            }
            else{
                System.out.println("Seleccione una opción válida");
            }
        }
    }
}
