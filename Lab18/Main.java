package Lab18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(1<2){
            System.out.println("Seleccione una opción:\n(1)Comenzar juego\n(2)Salir");
            int opcion = sc.nextInt();
            if(opcion == 1){
                //Pedimos que escojan su reino
                System.out.println("JUGADOR 1\nEscoja su reino\n(1)Inglaterra\n(2)Francia\n(3)Sacro Imperio\n(4)Castilla-Aragón\n(5)Moros");
                int eleccion1 = sc.nextInt();
                while(eleccion1 <= 0 || eleccion1 >= 6){
                    System.out.println("Escoja una opción válida");
                    System.out.println("JUGADOR 1\nEscoja su reino\n(1)Inglaterra\n(2)Francia\n(3)Sacro Imperio\n(4)Castilla-Aragón\n(5)Moros");
                    eleccion1 = sc.nextInt();
                }
                System.out.println("JUGADOR 2\nEscoja su reino\n(1)Inglaterra\n(2)Francia\n(3)Sacro Imperio\n(4)Castilla-Aragón\n(5)Moros");
                int eleccion2 = sc.nextInt();
                while((eleccion2 <= 0 || eleccion2 >= 6) || eleccion2 == eleccion1){
                    System.out.println("Escoja una opción válida");
                    System.out.println("JUGADOR 2\nEscoja su reino\n(1)Inglaterra\n(2)Francia\n(3)Sacro Imperio\n(4)Castilla-Aragón\n(5)Moros");
                    eleccion2 = sc.nextInt();
                }
                //Creamos los respectivos reinos usando el método crearReinos
                Reino reino1 = crearReinos(eleccion1);
                reino1.establecerEquipo(eleccion1);
                reino1.asignarNombres(eleccion1);
                Reino reino2 = crearReinos(eleccion2);
                reino2.establecerEquipo(eleccion2);
                reino2.asignarNombres(eleccion2);
                
                //Creamos un String que servirá para asignar el tipo de territorio cuando creemos los tableros de reinos y ejercitos
                String territorio = crearTipoTerritorio();
                //Creamos otro tablero para los reinos
                Mapa tablero = new Mapa();
                tablero.setTipoTerritorio(territorio);
                tablero.establecerPosEjercito(reino1.getReino().get(0).getEjercito(), reino2.getReino().get(0).getEjercito());
                System.out.println("--------------------------------------");
                System.out.println("Datos de los ejercitos");
                System.out.println("\nEJERCITO 1:\n");
                soldadoMayorVida(reino1.getReino().get(0).getEjercito());
                vidaEjercito(reino1.getReino().get(0).getEjercito());
                rankingPoder(reino1.getReino().get(0).getEjercito());
                System.out.println("\nEJERCITO 2:\n");
                soldadoMayorVida(reino2.getReino().get(0).getEjercito());
                vidaEjercito(reino2.getReino().get(0).getEjercito());
                rankingPoder(reino2.getReino().get(0).getEjercito());
                System.out.println("--------------------------------------");
                System.out.println(tablero.getTipoTerritorio());
                mejoraPorTerritorio(tablero, reino1);
                mejoraPorTerritorio(tablero, reino2);
                tablero.impTableroPers(reino1.getReino().get(0).getEjercito(), reino2.getReino().get(0).getEjercito());
                reino1.getReino().get(0).cantidadSoldados(reino1.getReino().get(0).getEjercito());
                reino2.getReino().get(0).cantidadSoldados(reino2.getReino().get(0).getEjercito());
                System.out.println("Ejercito 1:" + reino1.getNombreReino() + ": " + vidaTotalEjercito(reino1.getReino().get(0).getEjercito()));
                System.out.println("\nEjercito 2:" + reino2.getNombreReino() + ": " + vidaTotalEjercito(reino2.getReino().get(0).getEjercito()) + "\n");
                int total = vidaTotalEjercito(reino1.getReino().get(0).getEjercito()) + vidaTotalEjercito(reino2.getReino().get(0).getEjercito());
                double porcentaje1 = (vidaTotalEjercito(reino1.getReino().get(0).getEjercito())*100)/total;
                double porcentaje2 = (vidaTotalEjercito(reino2.getReino().get(0).getEjercito())*100)/total;
                int numeroAleatorio = (int) (Math.random()*100+1);
                if (numeroAleatorio < porcentaje1) {
                    System.out.println("\nEl ganador es el primer ejercito con " + porcentaje1 + "%\nSe basó en el nivel de vida total de ambos ejercitos");
                } else {
                    System.out.println("\nEl ganador es el segundo ejercito con " + porcentaje2 + "%\nSe basó en el nivel de vida total de ambos ejercitos");
                }

            }else if(opcion == 2){
                System.out.println("Saliendo del juego ...");
                break;
            }
            else{
                System.out.println("Seleccione una opción válida");
            }
        }
    }
    
    public static void soldadoMayorVida(ArrayList<Soldado> ejercito){
        ArrayList<Soldado> soldado = new ArrayList<>(ejercito);
        int mayorV = soldado.get(0).getNivelVida();
        String sold = "";
        for(int i = 1; i < soldado.size(); i++){
            if(soldado.get(i).getNivelVida() >= mayorV){
                mayorV = soldado.get(i).getNivelVida();
                sold = soldado.get(i).getNombre();
            }
        }
        System.out.println("El soldado con mayor vida es: " + sold);
    }

    public static void vidaEjercito(ArrayList<Soldado> ejercito){
        ArrayList<Soldado> soldado = new ArrayList<>(ejercito);
        double suma = 0.0;
        for(int i = 0; i < soldado.size(); i++){
            suma += soldado.get(i).getNivelVida();
        }
        double promedio = suma/soldado.size();
        System.out.println("El promedio de puntos de vida de los soldados es: " + promedio);
        System.out.println("El nivel de vida de todo el ejercito es: " + ( (int) suma));
    }

    public static int vidaTotalEjercito(ArrayList<Soldado> ejercito){
        ArrayList<Soldado> soldado = new ArrayList<>(ejercito);
        int suma = 0;
        for(int i = 0; i < soldado.size(); i++){
            suma += soldado.get(i).getNivelVida();
        }
        return suma;
    }

    public static void rankingPoder(ArrayList<Soldado> ejercito){
        ArrayList<Soldado> soldados = new ArrayList<>(ejercito);
        System.out.println("RANKING DE PODER:");
        for (int i = 1; i < soldados.size(); i++) {
            Soldado soldadoActual = soldados.get(i);
            int j = i - 1;
            while (j >= 0 && soldados.get(j).getNivelVida() < soldadoActual.getNivelVida()) {
                soldados.set(j+1, soldados.get(j));
                j--;
            }
            soldados.set(j+1, soldadoActual);
        }
        for(int i = 0; i < soldados.size(); i++){
            System.out.println(soldados.get(i).getNombre() + "\t" + soldados.get(i).getNivelVida());
        }
    }
    //Método para crear reinos
    public static Reino crearReinos(int eleccion){
        Reino reino = new Reino();
        //Establecemos el nombre del reino que escogió
        if(eleccion == 1){
            reino.setNombreReino("Inglaterra");
        }
        else if(eleccion == 2){
            reino.setNombreReino("Francia");
        }
        else if(eleccion == 3){
            reino.setNombreReino("Sacro Imperio");
        }
        else if(eleccion == 4){
            reino.setNombreReino("Castilla-Aragón");
        }
        else if(eleccion == 5){
            reino.setNombreReino("Moros");
        }
        //Establecemos la cantidad de ejercitos que contendrá el reino
        Ejercito ejercito = new Ejercito();
        ejercito.asignarEstadisticas();
        ejercito.establecerEquipo(eleccion);
        ejercito.asignarNombres();
        reino.getReino().add(ejercito);
        return reino;
    }
    public static String crearTipoTerritorio(){
        //Creamos un numero aleatorio que decidirá el tipo de territorio que se generará
        int num = (int) (Math.random()*5+1);
        String territorio = "";
        if(num == 1){
            territorio = "Bosque";
        }else if(num == 2){
            territorio = "Campo Abierto";
        }else if(num == 3){
            territorio = "Montaña";
        }else if(num == 4){
            territorio = "Desierto";
        }else{
            territorio = "Playa";
        }
        return territorio;
    }
    public static void mejoraPorTerritorio(Mapa mapa, Reino reino){
        //Obtenemos el tipo de territorio y comprobamos si es apto para darle mejoras al respectivo reino
        String territorio = mapa.getTipoTerritorio();
        String tipoReino = reino.getNombreReino();
        if(tipoReino.equals("Inglaterra")){
            if(territorio.equals("Bosque")){
                System.out.println("MEJORA POR TERRITORIO FAVORABLE, AUMENTANDO VIDA DE TODOS LOS SOLDADOS DEL REINO: " + tipoReino);
                mejorarVidaSoldados(reino);
            }
        }else if(tipoReino.equals("Francia")){
            if(territorio.equals("Campo Abierto")){
                System.out.println("MEJORA POR TERRITORIO FAVORABLE, AUMENTANDO VIDA DE TODOS LOS SOLDADOS DEL REINO: " + tipoReino);
                mejorarVidaSoldados(reino);
            }
        }else if(tipoReino.equals("Castilla-Aragón")){
            if(territorio.equals("Montaña")){
                System.out.println("MEJORA POR TERRITORIO FAVORABLE, AUMENTANDO VIDA DE TODOS LOS SOLDADOS DEL REINO: " + tipoReino);
                mejorarVidaSoldados(reino);
            }
        }else if(tipoReino.equals("Moros")){
            if(territorio.equals("Desierto")){
                System.out.println("MEJORA POR TERRITORIO FAVORABLE, AUMENTANDO VIDA DE TODOS LOS SOLDADOS DEL REINO: " + tipoReino);
                mejorarVidaSoldados(reino);
            }
        }else{
            if(territorio.equals("Bosque") || territorio.equals("Playa") || territorio.equals("Campo Abierto")){
                System.out.println("MEJORA POR TERRITORIO FAVORABLE, AUMENTANDO VIDA DE TODOS LOS SOLDADOS DEL REINO: " + tipoReino);
                mejorarVidaSoldados(reino);
            }
        }
    }
    public static void mejorarVidaSoldados(Reino reino){
        for(int i=0; i<reino.getSize(); i++){
            for(int j=0; j<reino.getReino().get(i).getLength(); j++){
                //Aumentamos en 1 la vida del soldado
                int vidaAumentadaSoldado = (reino.getReino().get(i).getEjercito().get(j).getNivelVida()) + 1;
                reino.getReino().get(i).getEjercito().get(j).setNivelVida(vidaAumentadaSoldado);
            }
        }
    }
}