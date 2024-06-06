package EjerciciosFP2;
import java.util.*;

public class Ejercicio01 {
    public static void main(String[] args){
        String nombre, celular;
        int contador = 0;
        boolean isQ = false;
        Scanner sc = new Scanner(System.in);
        final int N = 100;
        //Declaramos y dimensionamos el arreglo de tipo Contactos
        Contactos[] listaContactos = new Contactos[N];
        //Creamos un bucle para introducir los datos correspondientes
        System.out.println("Agregue a sus contactos, para detener el proceso escriba q en el nombre del contacto");
        for(int i=0; i<N; i++){
            //Pedimos el nombre y celular con sus respectivas condiciones
            System.out.println("\nIngrese el nombre del contacto "+(i+1)+":");
            nombre = sc.next();
            if(nombre.equalsIgnoreCase("q")){
                contador = i;
                //Booleano que indicará si se pulsó 'q'
                isQ = true;
                break;
            }
            System.out.println("Ingrese el telefono:");
            celular = sc.next();
            while(celular.length()!=9){
                System.out.println("Ingrese nueve digitos");
                celular = sc.next();
            }

            //Introducimos los datos a nuestro arreglo
            listaContactos[i] = new Contactos();
            listaContactos[i].setNombre(nombre);
            listaContactos[i].setNumero(celular);
        }
        //solo si q es escrito, imprime a todos los contactos que se guardaron
        if(isQ){
            for(int i=0; i<contador; i++){
                System.out.println("\nCONTACTO "+(i+1)+":");
                System.out.println("    Nombre:"+listaContactos[i].getNombre() +"\n   Telefono:"+listaContactos[i].getNumero());
            }
        }
        //Imprime completamente los 100 contactos
        else{
            for(int i=0; i<N; i++){
                System.out.println("CONTACTO "+(i+1)+":");
                System.out.println("    Nombre:"+listaContactos[i].getNombre() +"\n   Telefono:"+listaContactos[i].getNumero());
            }
        }

        //Ahora buscaremos a un contacto por su nombre e imprimiremos su numero
        System.out.println("\nINGRESE EL NOMBRE DE UNO DE SUS CONTACTOS: ");
        String buscarContacto = sc.next();
        if(isQ){
            for(int i=0; i<contador; i++){
                if(buscarContacto.equals(listaContactos[i].getNombre())){
                    System.out.println("Su numero es: " + listaContactos[i].getNumero());
                    break;
                }
            }
        }
        else{
            for(int i=0; i<N; i++){
                if(buscarContacto.equals(listaContactos[i].getNombre())){
                    System.out.println("Su nmero es: " + listaContactos[i].getNumero());
                }
            }
        }
    }
}
