package Laboratorio19;

import java.util.ArrayList;

public class Mapa {
    private boolean[][] tableroPosiciones;
    private Soldado[][] tablero;
    private Ejercito[][] tableroEjercito;
    private String tipoTerritorio;

    public Mapa(){
        this.tableroPosiciones = new boolean[10][10];
        this.tablero = new Soldado[10][10];
        this.tableroEjercito = new Ejercito[10][10];
    }
    
    public String getTipoTerritorio(){
        return this.tipoTerritorio;
    }
    public void setTipoTerritorio(String tipoTerritorio){
        this.tipoTerritorio = tipoTerritorio;
    }
    //Método para que nos retorne al ejercito
    public Ejercito[][] getEjercito(){
        return this.tableroEjercito;
    }
    public Soldado[][] getTablero(){
        return this.tablero;
    }
    //Metodo para imprimir el tablero despues de atacar/huir
    public void impTableroActual(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tablero[i][j] != null){
                    System.out.printf("| %-14s ", this.tablero[i][j].getNombre());
                } else {
                    System.out.print("|       _       ");
                }
            }
            System.out.println("|");
        }
    }
    public void impTableroActualReino(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tableroEjercito[i][j] != null){
                    System.out.printf("| %-11s ", this.tableroEjercito[i][j].getNombreEjercito());
                } else {
                    System.out.print("|      _      ");
                }
            }
            System.out.println("|");
        }
    }
    public void establecerPosEjercito(ArrayList<Soldado> ejer1, ArrayList<Soldado> ejer2){
        for(int i=0; i<ejer1.size(); i++){
            int columna = (int) (Math.random()*10);
            int fila = (int) (Math.random()*10);
            while(this.tableroPosiciones[fila][columna]){
                columna = (int) (Math.random()*10);
                fila = (int) (Math.random()*10);
            }
            this.tableroPosiciones[fila][columna] = true;
            //Guardamos los valores de fila y columna en los objetos de tipo Soldado
            ejer1.get(i).setFila(fila);
            ejer1.get(i).setColumna(columna);
        }
        for(int i=0; i<ejer2.size(); i++){
            int columna = (int) (Math.random()*10);
            int fila = (int) (Math.random()*10);
            while(this.tableroPosiciones[fila][columna]){
                columna = (int) (Math.random()*10);
                fila = (int) (Math.random()*10);
            }
            this.tableroPosiciones[fila][columna] = true;
            //Guardamos los valores de fila y columna en los objetos de tipo Soldado
            ejer2.get(i).setFila(fila);
            ejer2.get(i).setColumna(columna);
        }
    }
    public void establecerPosReino(ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2){
        for(int i=0; i<reino1.size(); i++){
            int columna = (int) (Math.random()*10);
            int fila = (int) (Math.random()*10);
            while(this.tableroPosiciones[fila][columna]){
                columna = (int) (Math.random()*10);
                fila = (int) (Math.random()*10);
            }
            this.tableroPosiciones[fila][columna] = true;
            //Guardamos los valores de fila y columna en los objetos de tipo Ejercito
            reino1.get(i).setFila(fila);
            reino1.get(i).setColumna(columna);
        }
        for(int i=0; i<reino2.size(); i++){
            int columna = (int) (Math.random()*10);
            int fila = (int) (Math.random()*10);
            while(this.tableroPosiciones[fila][columna]){
                columna = (int) (Math.random()*10);
                fila = (int) (Math.random()*10);
            }
            this.tableroPosiciones[fila][columna] = true;
            //Guardamos los valores de fila y columna en los objetos de tipo Ejercito
            reino2.get(i).setFila(fila);
            reino2.get(i).setColumna(columna);
        }
    }
    public void impTableroReino(ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2){
        for (int i = 0; i < reino1.size(); i++) {
            int fila = reino1.get(i).getFila();
            int columna = reino1.get(i).getColumna();
            this.tableroEjercito[fila][columna] = reino1.get(i);
        }
        for (int i = 0; i < reino2.size(); i++) {
            int fila = reino2.get(i).getFila();
            int columna = reino2.get(i).getColumna();
            this.tableroEjercito[fila][columna] = reino2.get(i);
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tableroEjercito[i][j] != null){
                    System.out.printf("| %-14s ", this.tableroEjercito[i][j].getNombreEjercito());
                } else {
                    System.out.print("|        _         ");
                }
            }
            System.out.println("|");
        }
    }
    public void establecerNuevaPos(Soldado soldado){
        int columna = (int) (Math.random()*10);
        int fila = (int) (Math.random()*10);
        while(this.tableroPosiciones[fila][columna]){
            columna = (int) (Math.random()*10);
            fila = (int) (Math.random()*10);
        }
        this.tableroPosiciones[fila][columna] = true;
        soldado.setFila(fila);
        soldado.setColumna(columna);
    }
    public void quitarPos(int fila, int columna){
        this.tableroPosiciones[fila][columna] = false;
    }
    public void cambiarPos(Soldado soldado, Soldado soldado2){
        int fila = soldado.getFila();
        int columna = soldado.getColumna();
        int fila2 = soldado2.getFila();
        int columna2 = soldado2.getColumna();
        this.tableroPosiciones[fila][columna] = this.tableroPosiciones[fila2][columna2];
        this.tableroPosiciones[fila2][columna2] = this.tableroPosiciones[fila][columna];
    }
    //Metodo para imprimir el tablero inicial sin repetir posiciones
    public void impTableroPers(ArrayList<Soldado> ejer1, ArrayList<Soldado> ejer2){
        for (int i = 0; i < ejer1.size(); i++) {
            int fila = ejer1.get(i).getFila();
            int columna = ejer1.get(i).getColumna();
            this.tablero[fila][columna] = ejer1.get(i);
        }
        for (int i = 0; i < ejer2.size(); i++) {
            int fila = ejer2.get(i).getFila();
            int columna = ejer2.get(i).getColumna();
            this.tablero[fila][columna] = ejer2.get(i);
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tablero[i][j] != null){
                    System.out.printf("| %-14s ", this.tablero[i][j].getNombre());
                } else {
                    System.out.print("|       _       ");
                }
            }
            System.out.println("|");
        }
    }
}