package Laboratorio6.Ejer1;

import java.util.*;
//Ejercicio n: 1
//Autor: Quiñonez Delgado Aaron Fernando
public class Ejercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Pedimos el lado y ancho del rectangulo
        System.out.println("Ingrese el lado");
        int lado = sc.nextInt();
        System.out.println("Ingrese el ancho");
        int ancho = sc.nextInt();
        //Asignamos los valores a nuestro objeto de tipo Rectangulo
        Rectangulo rectangulo = new Rectangulo();
        rectangulo.setLado(lado);
        rectangulo.setAncho(ancho);
        //Comprobamos que es un rectangulo y no un cuadrado
        if(!rectangulo.esCuadrado(lado, ancho)){
            //Calculamos su area y perimetro
            System.out.println("Su area mide: " + rectangulo.area(lado, ancho));
            System.out.println("Su perimetro mide: " + rectangulo.perimetro(lado, ancho));
        }else{
            System.out.println("Es un cuadrado");
        }
    }
}