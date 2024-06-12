package Laboratorio12;

import java.util.ArrayList;

public class Ejercito {
    private ArrayList<Soldado> ejercito;
    private String nombreEjercito;

    public Ejercito(){
        this.ejercito = new ArrayList<Soldado>();
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
            String nombre = "Soldado" + i + "x" + this.ejercito.get(i).getEjercito();
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
    public String toString(){
        String ejer = "";
        for(int i=0; i<ejercito.size(); i++){
            ejer += "\nNombre: " + ejercito.get(i).getNombre() + "\nAtaque: " + ejercito.get(i).getNivelAtaque() + "\nDefensa: " + ejercito.get(i).getNivelDefensa()
            + "\nVida: " + ejercito.get(i).getNivelVida();
        }
        return ejer;
    }
}