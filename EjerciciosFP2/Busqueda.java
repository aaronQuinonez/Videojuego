package EjerciciosFP2;
import java.util.*;

public class Busqueda {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño el arreglo: ");
        int n = sc.nextInt();
        System.out.println("Ingrese el valor a buscar");
        int val = sc.nextInt();
        int[] arreglo = new int[n];
        for(int i=0; i<arreglo.length; i++){
            int num = sc.nextInt();
            arreglo[i] = num;
        }
        System.out.println(busquedaBinaria(arreglo, val));
    }
    public static int busquedaBinaria(int[] lista, int valor){
        int baja, alta, media;
        baja = 0;
        alta = lista.length-1;
        while(baja <= alta){
            media = (int) ((baja+alta)/2);
            if(lista[media] == valor){
                return media;
            }
            else if(lista[media] < valor){
                baja = media + 1;
            }
            else{
                alta = media - 1;
            }
        }
        return -1;
    }
}
