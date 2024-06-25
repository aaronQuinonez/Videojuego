package Laboratorio16;

public class Soldado{
    protected String nombre;
    private int ejercito;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private int fila;
    private int columna;

    public Soldado(){
        this.nivelAtaque = (int) (Math.random()*5+1);
        this.nivelDefensa = (int) (Math.random()*5+1);
        this.nivelVida = (int) (Math.random()*5+1);
        this.vive = true;
        this.vidaActual = this.nivelVida;
    }
    public Soldado(int nivelAtaque, int nivelDefensa, int nivelVida){
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vive = true;
        this.vidaActual = this.nivelVida;
    }
    public Soldado(Soldado s){
        this.nivelAtaque = s.nivelAtaque;
        this.nivelDefensa = s.nivelDefensa;
        this.nivelVida = s.nivelVida;
        this.vive = true;
        this.vidaActual = this.nivelVida;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getNumEjercito(){
        return this.ejercito;
    }
    public void setEjercito(int ejercito){
        this.ejercito = ejercito;
    }

    public int getNivelAtaque(){
        return this.nivelAtaque;
    }
    public void setNivelAtaque(int nivelAtaque){
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelDefensa(){
        return this.nivelDefensa;
    }
    public void setNivelDefensa(int nivelDefensa){
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelVida(){
        return this.nivelVida;
    }
    public void setNivelVida(int nivelVida){
        this.nivelVida = nivelVida;
    }

    public int getColumna(){
        return this.columna;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }

    public int getFila(){
        return this.fila;
    }
    public void setFila(int fila){
        this.fila = fila;
    }
    
    public String getActitud(){
        return this.actitud;
    }
    public void setActitud(String actitud){
        this.actitud = actitud;
    }

    public int getVelocidad(){
        return this.velocidad;
    }
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public int getVidaActual(){
        return this.vidaActual;
    }
    public void setVidaActual(int vidaActual){
        this.vidaActual = vidaActual;
    }
    public boolean getVive(){
        return this.vive;
    }
    public void setVive(boolean vive){
        this.vive = vive;
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
    public void atacar(Soldado soldadoEnemigo){
        int totalVida = soldadoEnemigo.getVidaActual() + this.vidaActual;
        double probabilidadSoldEnemigo = (soldadoEnemigo.getVidaActual() * 100) / totalVida;
        double probabilidadSold = (this.vidaActual * 100) / totalVida;
        if(probabilidadSold > probabilidadSoldEnemigo){
            System.out.println("Venciste al enemigo por mayor probabilidad de triunfo " + "(" + probabilidadSold + "%)");
            soldadoEnemigo.setVive(false);
            this.vidaActual++;
        }
        else if(probabilidadSold < probabilidadSoldEnemigo){
            System.out.println("El enemigo te venció porque tiene mayor probabilidad de triunfo" + "(" + probabilidadSoldEnemigo + "%)");
            this.vive = false;
            soldadoEnemigo.setVidaActual(soldadoEnemigo.getVidaActual()+1);;
        }
        else{
            //Usamos el nivel de ataque cuando tengan el mismo nivel de vida
            if(this.nivelAtaque > soldadoEnemigo.getNivelAtaque()){
                System.out.println("Venciste al enemigo por mayor nivel de ataque");
                soldadoEnemigo.setVive(false);
                this.vidaActual++;
            }
            else if(this.nivelAtaque < soldadoEnemigo.getNivelAtaque()){
                System.out.println("El enemigo te venció por mayor nivel de ataque");
                this.vive = false;
                soldadoEnemigo.setVidaActual(soldadoEnemigo.getVidaActual()+1);
            }
            else{
                //Si también tiene el mismo nivel de ataque, entonces usamos la defensa
                if(this.nivelDefensa > soldadoEnemigo.getNivelDefensa()){
                    System.out.println("Venciste al enemigo por mayor nivel de defensa");
                    soldadoEnemigo.setVive(false);
                    this.vidaActual++;
                }
                else if(this.nivelDefensa > soldadoEnemigo.getNivelDefensa()){
                    System.out.println("El enemigo te venció por mayor nivel de defensa");
                    this.vive = false;
                    soldadoEnemigo.setVidaActual(soldadoEnemigo.getVidaActual()+1);
                }
                else{
                    //Si tienen todas sus estadísticas iguales, entonces se decidirá al azar
                    int azar = (int) (Math.random()*2+1);
                    if(azar == 1){
                        System.out.println("Venciste al enemigo contra todo pronóstico (al azar)");
                        soldadoEnemigo.setVive(false);
                        this.vidaActual++;
                    }else{
                        System.out.println("El enemigo te venció contra todo pronóstico (al azar)");
                        this.vive = false;
                        soldadoEnemigo.setVidaActual(soldadoEnemigo.getVidaActual()+1);
                    }
                }
            }
        }
    }
    //Metodo si el soldado tiene actitud ofensiva y que el usuario escoja la direccion a ir (arriba, derecha o izquierda)
    public void moverSoldado(int mov){
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
    }
    public String toString(){
        return "\nNombre: " + this.nombre + "\nAtaque: " + this.nivelAtaque + "\nDefensa: " + this.nivelDefensa + "\nVida: " + this.nivelVida
        +"\nFila: " + this.fila + "\nColumna: " + this.columna;
    }
}