package Laboratorio6.Ejer2;

import java.util.*;
//Ejercicio n: 2
//Autor: Quiñonez Delgado Aaron
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Pedimos el nombre del titular
        System.out.println("Ingrese el nombre del titular");
        String titular = sc.next();
        System.out.println("Ingrese su saldo");
        int saldo = sc.nextInt();

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(titular);
        cuenta.setSaldo(saldo);
        //Creamos un menu para pedir si va a depositar, retirar o ver su saldo actualizado
        System.out.println("Desea realizar alguna operacion? (1 para SI y 2 para NO)");
        int decision = sc.nextInt();
        if(decision == 1){
            System.out.println("1 si realizara un deposito\n2 si realizara un retiro\n3 para ver su saldo");
            int accion = sc.nextInt();
            if(accion == 1){
                System.out.println("Ingrese la cantidad a depositar");
                int deposito = sc.nextInt();
                cuenta.depositar(saldo, deposito);
            }
            else if(accion == 2){
                System.out.println("Ingrese la cantidad a retirar");
                int retiro = sc.nextInt();
                cuenta.retirar(saldo, retiro);
            }
            else if(accion == 3){
                System.out.println("Su saldo es de: " + cuenta.getSaldo());
            }
        }
        System.out.println("DATOS DE SU CUENTA: ");
        System.out.println("Nombre: " + cuenta.getNombre());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }
}
