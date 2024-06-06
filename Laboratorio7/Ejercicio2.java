package Laboratorio7;

public class Ejercicio2 {
    public static void main(String[] args){
        //Creamos los objetos de tipo Fraccion y comprobamos que los constructores funcionan
        System.out.println("Expresion 1 (valores por defecto):");
        Fraccion fraccion = new Fraccion();
        System.out.println(fraccion.toString());

        System.out.println("\nExpresion 2 (valor denominador por defecto):");
        Fraccion fraccion2 = new Fraccion(5);
        System.out.println(fraccion2.toString());

        System.out.println("\nExpresion 3 (uso de numerador y denominador):");
        Fraccion fraccion3 = new Fraccion(2, 5);
        System.out.println(fraccion3.toString());

        //Ponemos 0 en el denominador para mostrar mensaje de error y poner otro valor por defecto
        System.out.println("\nExpresion 4 (uso del 0 en la fraccion: '4/0'):");
        Fraccion fraccion4 = new Fraccion(4, 0);
        System.out.println(fraccion4.toString());

        //Usamos el metodo para simplificar fracciones
        System.out.println("\nSimplificacion de fracciones:");
        Fraccion fraccion5 = new Fraccion(15, 45);
        System.out.println("FRACCION ORIGINAL: " + fraccion5.toString());
        System.out.println("FRACCION SIMPLIFICADA: " + fraccion5.simplificar().getFraccion());

        //Comprobamos el metodo suma sumamos la expresion 3 (2/5) con 4/3
        System.out.println("\nComprobación del metodo suma:");
        Fraccion fraccion6 = new Fraccion(4, 3);
        System.out.println("Suma: " + fraccion3.suma(fraccion6).simplificar().getFraccion());   

        //Comprobamos el metodo multiplicacion con la expresion 3 (2/5) con 3/4 
        System.out.println("\nComprobación del metodo multiplicacion:");
        Fraccion fraccion7 = new Fraccion(3, 4);
        System.out.println("Multiplicacion: " + fraccion3.multiplicacion(fraccion7).simplificar().getFraccion());

        //Comprobamos el metodo division con la expresion 3 (2/5) con 5/3
        System.out.println("\nComprobación del metodo division:");
        Fraccion fraccion8 = new Fraccion(5, 3);
        System.out.println("Division: " + fraccion3.division(fraccion8).simplificar().getFraccion());

        //Comprobamos el metodo resta con la expresion 3 (2/5) con -1/5
        System.out.println("\nComprobación del metodo resta:");
        Fraccion fraccion9 = new Fraccion(-1, 5);
        System.out.println("Resta: " + fraccion3.resta(fraccion9).simplificar().getFraccion());

        System.out.println("------------------------");
        System.out.println("Suma: " + (fraccion3.suma(fraccion6).suma(fraccion7).multiplicacion(fraccion8)).getFraccion());
    }
}