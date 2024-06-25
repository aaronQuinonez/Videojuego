package Laboratorio16;

public class Espadachin extends Soldado{
    private int longEspada;
    public Espadachin(){
        super();
        longEspada = (int) (Math.random()*5+1);
        nombre = "Espadachin";
    }
    public int getLongEspada(){
        return longEspada;
    }
    public void crearMuroDeEscudos(){
        System.out.println("Creando muro de escudos");
        setNivelDefensa(getNivelDefensa()+3);
    }
    public String toString(){
        return super.toString() + "\nLongitud espada:" + getLongEspada();
    }
}
