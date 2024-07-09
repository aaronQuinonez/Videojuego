package Laboratorio19;

public class EspadachinTeutonico extends Espadachin{
    private int cantidadJabalinas;
    private int tamañoJabalinas;

    public EspadachinTeutonico() {
        super();
        this.nombre = "EspadachinT";
        this.nivelVida = 13;
        this.vidaActual = nivelVida;
        this.cantidadJabalinas = 4;
        this.tamañoJabalinas = 3;
    }

    public void lanzarJabalina() {
        // Implementación para lanzar jabalinas
        if (cantidadJabalinas > 0) {
            System.out.println("Lanzando jabalina de tamaño " + tamañoJabalinas);
            cantidadJabalinas--;
        } else {
            System.out.println("No quedan jabalinas disponibles.");
        }
    }

}
