package Laboratorio12;

import java.util.ArrayList;

public class Reino {
    private ArrayList<Ejercito> reino;
    private String nombreReino;
    
    public Reino(){
        reino = new ArrayList<Ejercito>();
    }

    public int getSize(){
        return reino.size();
    }
    public ArrayList<Ejercito> getReino(){
        return reino;
    }
    public String getNombreReino(){
        return nombreReino;
    }
    public void setNombreReino(String nombreReino){
        this.nombreReino = nombreReino;
    }
    //Metodo para generar nombres
    public void asignarNombres(int numReino){
        for(int i=0; i<this.reino.size(); i++){
            String nombre = "Ejercito" + i + "x" + numReino;
            this.reino.get(i).setNombreEjercito(nombre);
        }
    }
    public String toString(){
        String nombre = "Nombre del reino: " + nombreReino;
        String cantidad = "Cantidad de ejércitos: " + reino.size();
        String ejercitos = "";
        for(int i=0; i<reino.size(); i++){
            ejercitos += "\nEJERCITO " + i + "\n";
            ejercitos += reino.get(i).toString();
        }
        return "\n" + nombre + "\n" + cantidad + "\n" + ejercitos;
    }
}