package Laboratorio19;

public class CaballeroFranco extends Caballero {
    private int cantidadLanzas;
    private int tamañoLanzas;

    public CaballeroFranco() {
        super();
        this.nombre = "CaballeroF";
        this.nivelVida = 15;
        this.vidaActual = 15;
        this.cantidadLanzas = 3;
        this.tamañoLanzas = 2;
    }

    public void lanzarLanza() {
        // Implementación para lanzar lanzas
        if (cantidadLanzas > 0) {
            System.out.println("Lanzando lanza de tamaño " + tamañoLanzas);
            cantidadLanzas--;
        } else {
            System.out.println("No quedan lanzas disponibles.");
        }
    }
}
