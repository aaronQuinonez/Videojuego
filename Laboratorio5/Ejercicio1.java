package Laboratorio5;

import java.util.HashMap;
import java.util.Scanner;

//Autor: Quiñonez Delgado Aarón Fernando
public class Ejercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> cursos = new HashMap<String, String>();
        String controlador = "";
        //Hacemos un bucle hasta que el usuario ingrese la letra q
        System.out.println("Ingrese el nombre del curso (Presione 'q' para terminar)");
        controlador = sc.nextLine();
        while(!controlador.equals("q")){
            //Creamos el valor de las key
            String codigoRep = controlador;
            String codigo = (controlador.substring(0, 2)).toUpperCase();
            //Comprobamos que el codigo no se repita
            if(cursos.containsKey(codigo)){
                codigo += ("" + codigoRep.charAt(2)).toUpperCase();
            }
            cursos.put(codigo, controlador);
            System.out.println("Ingrese el nombre del curso (Presione 'q' para terminar)");
            controlador = sc.nextLine();
        }
        //Imprimimos los cursos con sus respectivos códigos
        System.out.println("\nLos cursos son:");
        for(String value : cursos.keySet()){
            System.out.println(value + ": "+ cursos.get(value));
        }
        //Consultamos el codigo
        while(true){
            System.out.println("Ingrese codigo del curso (Presionar ENTER para salir):");
            String code = sc.nextLine().toUpperCase();
            if(code.isEmpty())
                break;
            if(cursos.containsKey(code))
                System.out.println(code + ": " + cursos.get(code));
            else
                System.out.println("No existe el codigo ingresado");
        }
    }
}