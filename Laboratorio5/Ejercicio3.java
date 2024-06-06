package Laboratorio5;

//Autor: Quiñonez Delgado Aarón Fernando
import java.util.*;
public class Ejercicio3 {
    public static void main(String[] args){
        HashMap<String, String> cursos = new HashMap<String, String> (); 
        cursos.put("IS0001","Fundamentos de Programacion 1"); 
        cursos.put("IS0002","Introduccion a la Computacion"); 
        cursos.put("IS0003","Estructuras Discretas 1"); 
        System.out.println(cursos);
        cursos.remove("IS0002"); 
        System.out.println(cursos);
        String nombre = cursos.get("IS0001"); 
        System.out.println(nombre);
        boolean resultado = cursos.containsKey("IS0003"); 
        System.out.println(resultado);
        Iterator<String> keyIterator = cursos.keySet().iterator();
        while(keyIterator.hasNext()){
            String i = keyIterator.next();
            System.out.println(i+": "+cursos.get(i));
        }
        Iterator<String> keyRemove = cursos.keySet().iterator();
        while(keyRemove.hasNext()){
            keyRemove.next();
            keyRemove.remove();
        }
        System.out.println(cursos);
    }
}
