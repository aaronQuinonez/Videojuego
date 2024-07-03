package Laboratorio17;

public class Caballero extends Soldado{
    private boolean montadoCaballo;
    private String armaActual;
    public Caballero(){
        super();
        nivelVida = (int) (Math.random()*3+3);
        vidaActual = nivelVida;
        nombre = "Caballero";
        //Por predeterminado el caballero siempre estará montado en el caballo
        montadoCaballo = true;
        armaActual = "Lanza";
    }
    public void desmontar(){
        if(montadoCaballo){
            System.out.println("Desmontándose del caballo");
            montadoCaballo = false;
            armaActual = "Espada";
        }
        else{
            System.out.println("Ya está desmontado");
        }
    }
    public void montar(){
        if(!montadoCaballo){
            System.out.println("Montándose en el caballo");
            montadoCaballo = true;
            armaActual = "Lanza";
        }
        else{
            System.out.println("Ya está montado");
        }
    }
    public void envestir(){
        if(montadoCaballo){
            System.out.println("Envistiendo 3 veces");
        }else{
            System.out.println("Envistiendo 2 veces");
        }
    }
    public String toString(){
        return super.toString() + "\nArma actual: " + armaActual;
    }
}