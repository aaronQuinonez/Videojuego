package Lab16;

public class Main {
    public static void main(String[] args) {
        Espadachin espadachin = new Espadachin();
        System.out.println("Estadisticas espadachin:");
        System.out.println(espadachin.toString());
        espadachin.crearMuroDeEscudos();
        System.out.println("Estadisticas espadachin:");
        System.out.println(espadachin.toString());
        System.out.println("-----------------------------");
        Arquero arquero = new Arquero();
        System.out.println("Estadísticas arquero:");
        System.out.println(arquero.toString());
        arquero.disparar();
        System.out.println("Estadísticas arquero:");
        System.out.println(arquero.toString());
        System.out.println("-----------------------------");
        Caballero caballero = new Caballero();
        System.out.println("Estadísticas caballero:");
        System.out.println(caballero.toString());
        caballero.desmontar();
        System.out.println(caballero.toString());
        caballero.desmontar();
    }
}
