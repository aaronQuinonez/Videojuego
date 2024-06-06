package Laboratorio1;

//Nombre, puntos de vida, fila y columna
public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private int columna;

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }

    public int getFila(){
        return fila;
    }
    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna(){
        return columna;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }

}
