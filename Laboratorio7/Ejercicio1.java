package Laboratorio7;

//Autor: Quiñonez Delgado Aarón
public class Ejercicio1 {
    public static void main(String[] args){
        //Creamos objetos de tipo Fecha, utilizando la sobrecarga de constructores
        Fecha fecha = new Fecha();
        Fecha fecha2 = new Fecha(1950);
        Fecha fecha3 = new Fecha(5, 1999);
        Fecha fecha4 = new Fecha(7, 5, 2004);
        //Comprobamos que los constructores funcionen correctamente
        System.out.println(fecha.toString() + "\n");
        System.out.println(fecha2.toString() + "\n");
        System.out.println(fecha3.toString() + "\n");
        System.out.println(fecha4.toString() + "\n");
        //Cambiamos meses y dias para comprobar la verificacion de datos
        //fecha2 no es bisiesto, comprobamos el mensaje de error cambiando al 29 de febrero, por lo que solo cambiara el mes, no el dia
        System.out.println("Comprobacion del mensaje de error\nUsamos fecha2 (1/1/1950) para que sea 29 de febrero");
        fecha2.setMes(2);
        fecha2.setDia(29);
        System.out.println(fecha2.toString() + "\n");
    }
}
