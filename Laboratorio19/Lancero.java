package Laboratorio19;

public class Lancero extends Soldado{
    private int longLanza;
    private boolean formacionSchiltrom;
    public Lancero(){
        super();
        nivelAtaque = 5;
        nivelDefensa = 10;
        nivelVida = (int) (Math.random()*4+5);
        vidaActual = nivelVida;
        nombre = "Lancero";
        longLanza = (int) (Math.random()*5+2);
        formacionSchiltrom = false;
    }

    public void schiltrom(){
        if(!formacionSchiltrom){
            System.out.println("Asumiendo formacion schiltrom, aumentado la defensa en 1");
            nivelDefensa++;
        }else{
            System.out.println("Ya realizaste la formación schiltrom en el soldado");
        }
    }
    public String toString(){
        return super.toString() + "\nLongitud de la lanza: " + longLanza;
    }

}