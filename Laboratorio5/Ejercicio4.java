package Laboratorio5;

//Autor: Quiñonez Delgado Aarón Fernando
import java.util.*;
public class Ejercicio4 {
    public static void main(String[] args){
        HashMap<String, String> postalMap = new HashMap<String, String> (); 
        String nombre; 
        Scanner scan = new Scanner(System.in); 
        while(true) { 
        System.out.println("Ingresar nombre de ciudad?(ENTER si no hay):"); 
        nombre = scan.nextLine(); 
        if(nombre.isEmpty()) break; 
        String key = nombre.substring(0,2).toUpperCase(); 
        String value = nombre; 
        System.out.println("ciudad = " + value + " y clave = " + key); 
        postalMap.put(key, value); 
        } 
        while(true) { 
        System.out.println("Ingresar el codigo? (ENTER si quieres salir):"); 
        String codigo = scan.nextLine().toUpperCase(); 
        if(codigo.isEmpty()) break; 
        System.out.println(codigo.length()); 
        String ciudad = postalMap.get(codigo); 
        if(ciudad==null) 
        System.out.println("No hay tal abreviacion, intenta de nuevo"); 
        else 
        System.out.println("el codigo "+codigo+" es ciudad: "+ciudad); 
        } 
    }
}
