package Laboratorio12;

import java.util.ArrayList;

public class Ejercito{
    private ArrayList<Soldado> ejercito;
    private String nombreEjercito;
    private int numReino;
    private int fila;
    private int columna;
    private boolean vive;

    public Ejercito(){
        this.ejercito = new ArrayList<Soldado>();
        vive = true;
    }

    public int getLength(){
        return this.ejercito.size();
    }
    public ArrayList<Soldado> getEjercito(){
        return this.ejercito;
    }
    public String getNombreEjercito(){
        return this.nombreEjercito;
    }
    public void setNombreEjercito(String nombre){
        this.nombreEjercito = nombre;
    }
    public int getFila(){
        return this.fila;
    }
    public void setFila(int fila){
        this.fila = fila;
    }
    public int getColumna(){
        return this.columna;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    public int getNumReino(){
        return numReino;
    }
    public void setNumReino(int numReino){
        this.numReino = numReino;
    }
    public boolean getVive(){
        return vive;
    }
    public void setVive(boolean vive){
        this.vive = vive;
    }
    public void asignarEstadisticas(){
        int length = (int) (Math.random()*10+1);
        for(int i=0; i<length; i++){
            //Creamos un objeto de tipo Soldado para que sus datos se almacenen en el ArrayList de ejercito
            Soldado objeto;
            objeto = new Soldado();
            //Ahora asignamos a ejercito los valores del objeto;
            this.ejercito.add(objeto);
        }
    }
    public void establecerEquipo(int numEjercito){
        for(int i=0; i<this.ejercito.size(); i++){
            this.ejercito.get(i).setEjercito(numEjercito);
        }
    }
    //Metodo para generar nombres
    public void asignarNombres(){
        for(int i=0; i<this.ejercito.size(); i++){
            String nombre = "Soldado" + i + "x" + this.ejercito.get(i).getNumEjercito();
            this.ejercito.get(i).setNombre(nombre);
        }
    }
    public void eliminarSoldado(int fila, int columna){
        for(int i=0; i<this.ejercito.size(); i++){
            if(this.ejercito.get(i).getFila() == fila && this.ejercito.get(i).getColumna() == columna){
                this.ejercito.remove(i);
            }
        }
    }
    public void avanzar(){
        this.fila--;
    }
    public void retroceder(){
        this.fila++;
    }
    public void derecha(){
        this.columna++;
    }
    public void izquierda(){
        this.columna--;
    }
    public void moverEjercito(int mov){
        boolean repetir = true;
        while(repetir){
            if(mov == 1){
                avanzar();
                if(this.getFila() < 0 || this.getFila() > 9){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    retroceder();
                }
                else repetir = false;
            }
            else if(mov == 2){
                derecha();
                if(this.getFila() < 0 || this.getFila() > 9){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    izquierda();
                }
                else repetir = false;
            }
            else if(mov == 3){
                izquierda();
                if(this.getFila() < 0 || this.getFila() > 9){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    derecha();
                }
                else repetir = false;
            }
            else if(mov == 4){
                retroceder();
                if(this.getFila() < 0 || this.getFila() > 9){
                    System.out.println("Está moviéndose fuera del tablero, regresando a la posición anterior.");
                    avanzar();
                }
                else repetir = false;
            }
        }
    }
    public String toString(){
        String ejer = "";
        for(int i=0; i<ejercito.size(); i++){
            ejer += "\nNombre: " + ejercito.get(i).getNombre() + "\nAtaque: " + ejercito.get(i).getNivelAtaque() + "\nDefensa: " + ejercito.get(i).getNivelDefensa()
            + "\nVida: " + ejercito.get(i).getNivelVida();
        }
        return ejer;
    }
}