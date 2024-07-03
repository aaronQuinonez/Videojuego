package Laboratorio17;

public class Lancero extends Soldado{
    int longitudLanza;
    boolean posicionSchiltrom;
    public Lancero(){
        super();
        nombre = "Lancero";
        nivelVida = (int) (Math.random()*2+1);
        vidaActual = nivelVida;
        longitudLanza = (int) (Math.random()*5+1);
        posicionSchiltrom = false;
    }
    public void schiltrom(){
        if(!posicionSchiltrom){
            System.out.println("Asumiendo posición schiltrum");
            posicionSchiltrom = true;
            setNivelDefensa(getNivelDefensa()+1);
        }
        else{
            System.out.println("Cambiando a posición normal");
            posicionSchiltrom = false;
            setNivelDefensa(getNivelDefensa()-1);
        }
    }
}
