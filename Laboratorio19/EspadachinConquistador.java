package Laboratorio19;

public class EspadachinConquistador extends Espadachin {
    private int cantidadHachas;
    private int tamañoHachas;

    public EspadachinConquistador() {
        super();
        this.nombre = "EspadachinC";
        this.nivelVida = 14;
        this.vidaActual = nivelVida;
        this.cantidadHachas = 3;
        this.tamañoHachas = 2;
    }

    public void lanzarHacha() {
        // Implementación para lanzar hachas
        if (cantidadHachas > 0) {
            System.out.println("Lanzando hacha de tamaño " + tamañoHachas);
            cantidadHachas--;
            tamañoHachas++;
        } else {
            System.out.println("No quedan hachas disponibles.");
        }
    }
}
