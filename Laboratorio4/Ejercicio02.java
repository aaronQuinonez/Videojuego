package Laboratorio4;
import java.util.*;

public class Ejercicio02{
    public static void main(String[] args){
        String ahor1 = "  +---+  \n"+
                       "  |   |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "========== ";
        String ahor2 = "  +---+  \n"+
                       "  |   |  \n"+
                       "  O   |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "========== ";
        String ahor3 = "  +---+  \n"+
                       "  |   |  \n"+
                       "  O   |  \n"+
                       "  |   |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "========== ";
        String ahor4 = "  +---+  \n"+
                       "  |   |  \n"+
                       "  O   |  \n"+
                       " /|   |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "========== ";
        String ahor5 = "  +---+  \n"+
                       "  |   |  \n"+
                       "  O   |  \n"+
                       " /|\\ |  \n"+
                       "      |  \n"+
                       "      |  \n"+
                       "========== ";
        String ahor6 = "  +---+  \n"+
                       "  |   |  \n"+
                       "  O   |  \n"+
                       " /|\\ |  \n"+
                       " /    |  \n"+
                       "      |  \n"+
                       "========== ";
        String ahor7 = "  +---+  \n"+
                       "  |   |  \n"+
                       "  O   |  \n"+
                       " /|\\ |  \n"+
                       " / \\ |  \n"+
                       "      |  \n"+
                       "========== ";

        String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
        int contador = 1;
        String letra;
        String[] palabras = {"programacion", "java", "identacion", "clases", 
                                "objetos", "desarrollador", "pruebas"};
        String palSecreta = getPalabraSecreta(palabras);
        System.out.println(figuras[0]);
        mostrarBlancos(palSecreta);
        System.out.println("\n");
        //Creamos un arreglo de string que almacenaran los caracteres correctos, se inicializará con "_"
        String[] palabraCorrecta = new String[palSecreta.length()];
        for(int i=0; i<palabraCorrecta.length; i++)
            palabraCorrecta[i] = "_";

        int turnos = 0;
        while(contador <= 6){
            letra = ingreseLetra();
            if(letraEnPalabraSecreta(letra, palSecreta)){
                palabraCorrecta = actualizarLetrasCorrectas(letra, palSecreta, palabraCorrecta);
                mostrarBlancosActualizados(letra, palSecreta, palabraCorrecta);
                if(estaCompleto(palabraCorrecta)){
                    turnos++;
                    break;
                }
                contador--;
            }
            else
                System.out.println(figuras[contador]);
            contador++;
            turnos++;
        }
        //COMPLETAR PARA INDICAR SI GANÓ, PERDIÓ Y CUÁNTOS TURNOS NECESITÓ
        System.out.println("\n");
        if(contador == 7)
            System.out.println("PERDISTE");
        else
            System.out.println("GANASTE");
        System.out.println("Usó " + turnos + " turnos");
    }

    public static String getPalabraSecreta(String[] lasPalabras){
        int ind;
        int indiceMayor = lasPalabras.length;
        ind = (int) (Math.random()*indiceMayor);
        return lasPalabras[ind];
    }

    public static void mostrarBlancos(String palabra){
        for(int i=0; i<palabra.length(); i++)
            System.out.print("_ ");
    }

    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        while(laLetra.length() != 1 || !Character.isLetter(laLetra.charAt(0))){
            System.out.println("Ingrese letra: ");
            laLetra = sc.next();
        }
        return laLetra;
    }
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta){
        //COMPLETAR
        for(int i=0; i<palSecreta.length(); i++){
            if(letra.equals(palSecreta.substring(i, i+1)))
                return true;
        }
        return false;
    }
    public static void mostrarBlancosActualizados(String letra, String palSecreta, String[] palCorrecta){
        //COMPLETAR
        System.out.println("PROCESANDO.....");
        for(int i=0; i<palSecreta.length(); i++){
            System.out.print(palCorrecta[i] + " ");
        }
        System.out.println("\n");
    }
    public static String[] actualizarLetrasCorrectas(String letra, String palSecreta ,String[] palCorrecta){
        for(int i=0; i<palSecreta.length(); i++){
            if(letra.equals(palSecreta.substring(i, i+1)))
                palCorrecta[i] = letra;
        }
        return palCorrecta;
    }
    public static boolean estaCompleto(String[] palCorrecta){
        for(int i=0; i<palCorrecta.length; i++){
            if(palCorrecta[i] == "_")
                return false;
        }
        return true;
    }
}