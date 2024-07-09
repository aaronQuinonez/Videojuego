package Laboratorio19;

public class CaballeroMoro extends Caballero {
    private int cantidadFlechas;
    private int tamañoFlechas;

    public CaballeroMoro() {
        super();
        this.nombre = "CaballeroM";
        this.nivelVida = 13;
        this.vidaActual = this.nivelVida;
        this.cantidadFlechas = 4;
        this.tamañoFlechas = 2;
    }

    public void lanzarFlecha() {
        // Implementación para lanzar flechas
        if (cantidadFlechas > 0) {
            System.out.println("Lanzando flecha de tamaño " + tamañoFlechas);
            cantidadFlechas--;
        } else {
            System.out.println("No quedan flechas disponibles.");
        }
    }
}
