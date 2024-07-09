package Laboratorio19;

public class EspadachinReal extends Espadachin implements EspadachinRealInterfaz {
    private int cantidadCuchillos;
    private int tamañoCuchillos;
    public EspadachinReal() {
        super();
        this.nombre = "EspadachinR";
        this.nivelVida = 12;
        this.vidaActual = nivelVida;
        this.cantidadCuchillos = 5;
        this.tamañoCuchillos = 1;
    }

    public void lanzarCuchillo() {
        if (cantidadCuchillos > 0) {
            System.out.println("Lanzando cuchillo de tamaño " + tamañoCuchillos);
            cantidadCuchillos--;
            tamañoCuchillos++;
        } else {
            System.out.println("No quedan cuchillos disponibles.");
        }
    }
}