package Lab18;

public class Caballero extends Soldado{
    private boolean montadoCaballo;
    private String armaActual;
    public Caballero(){
        super();
        nombre = "Caballero";
        //vida entre 10 y 12
        nivelVida = (int) (Math.random()*3+10);
        vidaActual = nivelVida;
        nivelAtaque = 13;
        nivelDefensa = 7;
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