package Laboratorio6.Ejer1;

public class Rectangulo {
    private int lado;
    private int ancho;
    
    public Rectangulo(){}

    public Rectangulo(int lado, int ancho){
        this.lado = lado;
        this.ancho = ancho;
    }

    public int getLado(){
        return lado;
    }
    public void setLado(int lado){
        this.lado = lado;
    }
    public int getAncho(){
        return ancho;
    }
    public void setAncho(int ancho){
        this.ancho = ancho;
    }
    public int area(int lado, int ancho){
        return lado*ancho;
    }

    public int perimetro(int lado, int ancho){
        return lado+ancho;
    }

    public boolean esCuadrado(int lado, int ancho){
        if(lado == ancho){
            return true;
        }
        return false;
    }
}
