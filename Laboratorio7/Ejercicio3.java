package Laboratorio7;

public class Ejercicio3 {
    public static void main(String[] args){
        //Creamos 5 fracciones para realizar el encadenamiento
        Fraccion f1 = new Fraccion(7, 9);
        Fraccion f2 = new Fraccion(5, 13);
        Fraccion f3 = new Fraccion(2, 5);
        Fraccion f4 = new Fraccion(4, 3);
        Fraccion f5 = new Fraccion(1,6);
        System.out.println("------------------------");
        //Se realizara la siguiente operación: (((f1+f4)*f3)-f2)/f5
        //(((7/9 + 4/3)*2/5)-5/13)/1/6
        System.out.println("Resultado: " + (f1.suma(f4).multiplicacion(f3).resta(f2).division(f5)).getFraccion());
        System.out.println("Simplificado: " + (f1.suma(f4).multiplicacion(f3).resta(f2).division(f5)).simplificar().getFraccion());
    }
}
