package Laboratorio5;

//Autor: Quiñonez Delgado Aarón Fernando
import java.util.*;
public class Ejercicio2{
    public static void main(String[] args) {
        HashMap<Integer, String> equipo=new HashMap<Integer, String>(); 
        equipo.put(1,"Gallese");
        equipo.put(2,"Tapia"); 
        equipo.put(3,"Flores"); 
        Iterator<Integer> key = equipo.keySet().iterator();
        while(key.hasNext()){
            int i = key.next();
            System.out.println(i + ": " + equipo.get(i));
        }
    } 
}