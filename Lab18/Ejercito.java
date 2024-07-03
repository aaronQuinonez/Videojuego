package Lab18;

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
    //Método para obtener la vida total del ejército
    public int getVidaTotal(){
        int vidaTotal = 0;
        for(int i=0; i<ejercito.size(); i++){
            vidaTotal += ejercito.get(i).getNivelVida();
        }
        return vidaTotal;
    }
    //Método para obtener el ataque total del ejército
    public int getAtaqueTotal(){
        int ataqueTotal = 0;
        for(int i=0; i<ejercito.size(); i++){
            ataqueTotal += ejercito.get(i).getNivelAtaque();
        }
        return ataqueTotal;
    }
    //Método para obtener la defensa total del ejército
    public int getDefensaTotal(){
        int defensaTotal = 0;
        for(int i=0; i<ejercito.size(); i++){
            defensaTotal += ejercito.get(i).getNivelDefensa();
        }
        return defensaTotal;
    }
    public void asignarEstadisticas(){
        int length = (int) (Math.random()*10+1);
        for(int i=0; i<length; i++){
            //Creamos de manera aleatoria un espadachin, arquero o caballero que se almacenará en el ArrayList
            int numRand = (int) (Math.random()*4+1);
            if(numRand == 1){
                Espadachin objeto = new Espadachin();
                this.ejercito.add(objeto);
            }else if(numRand == 2){
                Arquero objeto = new Arquero();
                this.ejercito.add(objeto);
            }else if(numRand == 3){
                Caballero objeto = new Caballero();
                this.ejercito.add(objeto);
            }else{
                Lancero objeto = new Lancero();
                this.ejercito.add(objeto);
            }
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
            String nombre = this.ejercito.get(i).getNombre() + i + "x" + this.ejercito.get(i).getNumEjercito();
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
        if(mov == 1){
            avanzar();
            if((this.getFila() < 0 || this.getFila() > 9) || (this.getColumna() < 0 || this.getColumna() >9)){
                System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                retroceder();
            }
        }
        else if(mov == 2){
            derecha();
            if(this.getFila() < 0 || this.getFila() > 9 || (this.getColumna() < 0 || this.getColumna() >9)){
                System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                izquierda();
            }
        }
        else if(mov == 3){
            izquierda();
            if(this.getFila() < 0 || this.getFila() > 9 || (this.getColumna() < 0 || this.getColumna() >9)){
                System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                derecha();
            }
        }
        else if(mov == 4){
            retroceder();
            if((this.getFila() < 0 || this.getFila() > 9) || (this.getColumna() < 0 || this.getColumna() >9)){
                System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                avanzar();
            }
        }
    }
    //Método para atacar entre ejércitos
    public void atacar(Ejercito ejercitoEnemigo){
        int totalVida = ejercitoEnemigo.getVidaTotal() + this.getVidaTotal();
        
        double probabilidadEjercitoEnemigo = (ejercitoEnemigo.getVidaTotal() * 100) / totalVida;
        double probabilidadSold = (this.getVidaTotal() * 100) / totalVida;
        if(probabilidadSold > probabilidadEjercitoEnemigo){
            System.out.println("Venciste al enemigo por mayor probabilidad de triunfo " + "(" + probabilidadSold + "%)");
            ejercitoEnemigo.setVive(false);
            for(int i=0; i<ejercito.size(); i++){
                ejercito.get(i).setNivelVida(ejercito.get(i).getNivelVida()+1);
            }
        }
        else if(probabilidadSold < probabilidadEjercitoEnemigo){
            System.out.println("El enemigo te venció porque tiene mayor probabilidad de triunfo" + "(" + probabilidadEjercitoEnemigo + "%)");
            this.vive = false;
            for(int i=0; i<ejercitoEnemigo.getLength(); i++){
                ejercitoEnemigo.getEjercito().get(i).setVidaActual(ejercitoEnemigo.getEjercito().get(i).getVidaActual()+1);
            }
        }
        else{
            //Usamos el nivel de ataque cuando tengan el mismo nivel de vida
            if(this.getAtaqueTotal() > ejercitoEnemigo.getAtaqueTotal()){
                System.out.println("Venciste al enemigo por mayor nivel de ataque");
                ejercitoEnemigo.setVive(false);
                for(int i=0; i<ejercito.size(); i++){
                    ejercito.get(i).setNivelVida(ejercito.get(i).getNivelVida()+1);
                }
            }
            else if(this.getAtaqueTotal() < ejercitoEnemigo.getAtaqueTotal()){
                System.out.println("El enemigo te venció por mayor nivel de ataque");
                this.vive = false;
                for(int i=0; i<ejercitoEnemigo.getLength(); i++){
                    ejercitoEnemigo.getEjercito().get(i).setVidaActual(ejercitoEnemigo.getEjercito().get(i).getVidaActual()+1);
                }
            }
            else{
                //Si también tiene el mismo nivel de ataque, entonces usamos la defensa
                if(this.getDefensaTotal() > ejercitoEnemigo.getDefensaTotal()){
                    System.out.println("Venciste al enemigo por mayor nivel de defensa");
                    ejercitoEnemigo.setVive(false);
                    for(int i=0; i<ejercito.size(); i++){
                        ejercito.get(i).setNivelVida(ejercito.get(i).getNivelVida()+1);
                    }
                }
                else if(this.getDefensaTotal() > ejercitoEnemigo.getDefensaTotal()){
                    System.out.println("El enemigo te venció por mayor nivel de defensa");
                    this.vive = false;
                    for(int i=0; i<ejercitoEnemigo.getLength(); i++){
                        ejercitoEnemigo.getEjercito().get(i).setVidaActual(ejercitoEnemigo.getEjercito().get(i).getVidaActual()+1);
                    }
                }
                else{
                    //Si tienen todas sus estadísticas iguales, entonces se decidirá al azar
                    int azar = (int) (Math.random()*2+1);
                    if(azar == 1){
                        System.out.println("Venciste al enemigo contra todo pronóstico (al azar)");
                        ejercitoEnemigo.setVive(false);
                        for(int i=0; i<ejercito.size(); i++){
                            ejercito.get(i).setNivelVida(ejercito.get(i).getNivelVida()+1);
                        }
                    }else{
                        System.out.println("El enemigo te venció contra todo pronóstico (al azar)");
                        this.vive = false;
                        for(int i=0; i<ejercitoEnemigo.getLength(); i++){
                            ejercitoEnemigo.getEjercito().get(i).setVidaActual(ejercitoEnemigo.getEjercito().get(i).getVidaActual()+1);
                        }
                    }
                }
            }
        }
    }
    public int getVivos(){
        int cont = 0;
        for(int i=0; i<this.ejercito.size(); i++){
            if(this.ejercito.get(i).getVive()){
                cont++;
            }
        }
        return cont;
    }
    public void cantidadSoldados(ArrayList<Soldado> soldados){
        System.out.println("Cantidad total del ejercito: " + ejercito.size());
        int esp = 0;
        int arq = 0;
        int cab = 0;
        int lan = 0;
        for(int i=0; i<ejercito.size(); i++){
            if(ejercito.get(i).getNombre().startsWith("Espadachin")) esp++;
            else if(ejercito.get(i).getNombre().startsWith("Arquero")) arq++;
            else if(ejercito.get(i).getNombre().startsWith("Caballero")) cab++;
            else if(ejercito.get(i).getNombre().startsWith("Lancero")) lan++;
        } 
        System.out.println("Espadachines: " + esp);
        System.out.println("Arqueros: " + arq);
        System.out.println("Caballeros: " + cab);
        System.out.println("Lanceros: " + lan);
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