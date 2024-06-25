package Lab16;

public class Arquero extends Soldado{
    private int flechas;
    public Arquero(){
        super();
        nombre = "Arquero";
        flechas = (int) (Math.random()*10+1);
    }
    public int getFlechas(){
        return flechas;
    }
    public void disparar(){
        flechas--;
    }
    public String toString(){
        return super.toString() + "\nNúmero de flechas: " + getFlechas();
    }
}
