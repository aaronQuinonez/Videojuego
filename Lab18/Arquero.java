package Lab18;

public class Arquero extends Soldado{
    private int flechas;
    public Arquero(){
        super();
        nombre = "Arquero";
        nivelAtaque = 7;
        nivelDefensa = 3;
        nivelVida = (int) (Math.random()*3+3);
        vidaActual = nivelVida;
        //Tendrá 10 flechas por predeterminado
        flechas = 10;
    }
    public int getFlechas(){
        return flechas;
    }
    public void disparar(){
        if(flechas == 0){
            System.out.println("El arquero ya no tiene flechas");
        }else{
            flechas--;
        }
    }
    public String toString(){
        return super.toString() + "\nNúmero de flechas: " + flechas;
    }
}