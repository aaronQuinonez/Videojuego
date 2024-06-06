package Laboratorio6;

import java.util.*;
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Pedimos la cantidad de libros a registrar
        System.out.println("Ingrese la cantidad de libros para registrar");
        int cantidad = sc.nextInt();
        sc.nextLine();
        //Creamos un arreglo que almacenara los datos de tipo Libro
        Libro[] libros = new Libro[cantidad];
        //Hacemos un bucle para almacenar los datos correspondientes de cada libro
        for(int i=0; i<cantidad; i++){
            //Solicitamos el titulo, autor y el numero de ejemplares
            System.out.println("Ingrese el nombre del titulo");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el nombre del autor");
            String autor = sc.nextLine();
            System.out.println("Ingrese el numero de ejemplares");
            int ejemplares = sc.nextInt();
            sc.nextLine();
            //Asignamos cada valor guardado en nuestro objeto de tipo Libro
            Libro libro = new Libro();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEjemplares(ejemplares);
            //Lo guardamos en el arreglo
            libros[i] = libro;
        }
        for(int i=0; i<cantidad; i++){
            System.out.println("LIBRO " + (i+1) + ":");
            System.out.println("Titulo: " + libros[i].getTitulo());
            System.out.println("Autor:" + libros[i].getAutor());
            System.out.println("Ejemplares: " + libros[i].getEjemplares() + "\n");
        }
        //Creamos un bucle para pedirle al usuario si va a pedir un libro prestado o lo devolvera
        boolean seguirPreguntando = true;
        while(seguirPreguntando){
            //Preguntamos si habra algun libro prestado
            System.out.println("Desea pedir prestado algun ejemplar? (1 para SI y 2 para NO)");
            int decision = sc.nextInt();
            if(decision == 1){
                //Preguntamos por cual libro se va a pedir prestado
                System.out.println("Ingrese el numero del libro para prestar:");
                int num = sc.nextInt();
                //Usamo el metodo Prestamo
                if(!libros[num-1].prestamo()){
                    System.out.println("ERROR");
                }
            }
            //Hacemos lo mismo para la devolucion
            System.out.println("Desea devolver algun ejemplar? (1 para SI y 2 para NO)");
            int decision2 = sc.nextInt();
            if(decision2 == 1){
                //Preguntamos que numero de libro se devolvera
                System.out.println("Ingrese el numero del libro a devolver:");
                int num = sc.nextInt();
                //Usamo el metodo devolucion
                if(!libros[num-1].devolucion()){
                    System.out.println("ERROR");
                }
            }
            System.out.println("Desea continuar? (1 para SI y 2 para NO)");
            int decisionFinal = sc.nextInt();
            if(decisionFinal == 2){
                seguirPreguntando = false;
            }
        }
        //Finalmente imprimimos los datos actualizados con el metodo toString
        for(int i=0; i<cantidad; i++){
            System.out.println("LIBRO " + (i+1) + ":");
            System.out.println(libros[i].toString());
            System.out.println("--------------------");
        }
    }
}
