package Laboratorio19;

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
                //Comienza el juego entre los usuarios
                int ganador = 0;
                boolean continuar = true;
                while(continuar){
                    //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                    System.out.println("=============================================\nEJERCITO 1:");
                    actitudSoldadoPers(reino1.getReino().get(0).getEjercito(), reino2.getReino().get(0), tablero.getTablero());
                    tablero.impTableroActual();
                    if(estaVacioPers(reino2.getReino().get(0).getEjercito())){
                        ganador = 1;
                        continuar = false;
                        break;
                    }
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + reino1.getReino().get(0).getVivos());
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + reino2.getReino().get(0).getVivos());
                    System.out.println("=============================================\nEJERCITO 2:");
                    actitudSoldadoPers(reino2.getReino().get(0).getEjercito(), reino1.getReino().get(0), tablero.getTablero());
                    tablero.impTableroActual();
                    //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
                    if(estaVacioPers(reino1.getReino().get(0).getEjercito())){
                        ganador = 2;
                        continuar = false;
                        break;
                    }
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + reino1.getReino().get(0).getVivos());
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + reino2.getReino().get(0).getVivos());
                    System.out.println("Desea continuar?\n(1)Sí\n(2)No");
                    int cont = sc.nextInt();
                    while(cont != 1 && cont !=2){
                        System.out.println("Escoja una opción válida");
                        cont = sc.nextInt();
                    }
                    if(cont == 1)
                        continue;
                    else if(cont == 2)
                        continuar = false;
                }
                if(ganador == 1)
                    System.out.println("EL GANADOR ES EL EJÉRCITO 1");
                else if(ganador == 2)
                    System.out.println("EL GANADOR ES EL EJÉRCITO 2");

            }else if(opcion == 2){
                System.out.println("Saliendo del juego ...");
                break;
            }
            else{
                System.out.println("Seleccione una opción válida");
            }
        }
    }
    public static void actitudSoldadoPers(ArrayList<Soldado> ejercito, Ejercito ejercito2, Soldado[][] tablero){
        System.out.println("Escoja al soldado:");
        Scanner sc = new Scanner(System.in);
        int numSoldado = sc.nextInt();
        System.out.println("Seleccione su actitud:\n(1)Defensivo\n(2)Ofensivo\n(3)Fuga(retroceder)");
        int actitud = sc.nextInt();
        //Segun la actitud que se eligio vamos a usar metodos para comprobar si hay un soldado del equipo enemigo al retroceder/avanzar
        int velocidad = ejercito.get(numSoldado).getVelocidad();
        if(actitud == 3 && velocidad != 0){
            //Si es distinto a 0, entonces tendra que detenerse y tomar actitud defensiva
            System.out.println("Velocidad distinta a 0, cambiando a posicion defensiva.");
            actitud = 1;
        }
        if(actitud == 1){
            //Defensivo, no cambia de posicion
            ejercito.get(numSoldado).setActitud("Defensivo");
            velocidad = 0;
            ejercito.get(numSoldado).setVelocidad(velocidad);
        }
        else if(actitud == 2){
            //Ofensivo, avanzará una casilla y su velocidad también cambiará
            ejercito.get(numSoldado).setActitud("Ofensivo");
            velocidad++;
            ejercito.get(numSoldado).setVelocidad(velocidad);
            int filaAnterior = ejercito.get(numSoldado).getFila();
            int columnaAnterior = ejercito.get(numSoldado).getColumna();
            //Le preguntamos al usuario hacia donde va a mover el soldado (arriba, derecha o izquierda)
            System.out.println("Hacia donde se moverá el soldado\n(1)Arriba\n(2)Derecha\n(3)Izquierda");
            int mov = sc.nextInt();
            while(1<2){
                if(mov != 3 && mov != 2 && mov != 1)
                    System.out.println("Ingrese una opción válida");
                else break;
                System.out.println("Hacia donde se moverá el soldado\n(1)Arriba\n(2)Derecha\n(3)Izquierda");
                mov = sc.nextInt();
            }
            ejercito.get(numSoldado).moverSoldado(mov);
            //Comprobamos si cruza con un enemigo o aliado. Si es enemigo, lo ataca; si es aliado, vuelve a su posicion original
            int numEjercito = ejercito.get(numSoldado).getNumEjercito();
            int fila = ejercito.get(numSoldado).getFila();
            int columna = ejercito.get(numSoldado).getColumna();
            if(tablero[fila][columna] != null){
                //Si es aliado
                if(tablero[fila][columna].getNumEjercito() == numEjercito){
                    System.out.println("Es aliado, volviendo a la casilla original");
                    if(mov == 1){
                        ejercito.get(numSoldado).retroceder();
                    }
                    else if(mov == 2){
                        ejercito.get(numSoldado).izquierda();
                    }
                    else{
                        ejercito.get(numSoldado).derecha();
                    }
                }
                //Si es enemigo
                else{
                    ejercito.get(numSoldado).atacar(tablero[fila][columna]);
                    //Comprobamos quien muere para actualizar el tablero
                    if(!ejercito.get(numSoldado).getVive()){
                        tablero[filaAnterior][columnaAnterior] = null;
                        ejercito.get(numSoldado).setVive(false);
                    }
                    else{
                        ejercito2.eliminarSoldado(fila, columna);
                        tablero[fila][columna] = ejercito.get(numSoldado);
                        tablero[filaAnterior][columnaAnterior] = null;
                    }
                }
            }
            else{
                tablero[fila][columna] = ejercito.get(numSoldado);
                tablero[filaAnterior][columnaAnterior] = null;
            }
        }
        else{
            //Fuga, retrocederá 1 casilla si su velocidad es 0, no se moverá si su velocidad es mayor a 0
            ejercito.get(numSoldado).setActitud("Fuga");
            int filaAnterior = ejercito.get(numSoldado).getFila();
            int columnaAnterior = ejercito.get(numSoldado).getColumna();
            if(ejercito.get(numSoldado).getVelocidad() != 0){
                System.out.println("Velocidad cambiada a 0, cambiando a actitud de defensa");
                ejercito.get(numSoldado).setActitud("Defensivo");
                velocidad = 0;
                ejercito.get(numSoldado).setVelocidad(velocidad);
            }
            else{
                ejercito.get(numSoldado).retroceder();
                if(ejercito.get(numSoldado).getFila() < 0 || ejercito.get(numSoldado).getFila() > 9){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    ejercito.get(numSoldado).avanzar();
                }
                else{
                    int fila = ejercito.get(numSoldado).getFila();
                    int columna = ejercito.get(numSoldado).getColumna();
                    if(tablero[fila][columna] != null){
                        //Si es aliado
                        if(tablero[fila][columna].getNumEjercito() == ejercito.get(numSoldado).getNumEjercito()){
                            System.out.println("Es aliado, volviendo a la casilla original");
                            ejercito.get(numSoldado).avanzar();
                        }
                        //Si es enemigo
                        else{
                            ejercito.get(numSoldado).atacar(tablero[fila][columna]);
                            //Comprobamos quien muere para actualizar el tablero
                            if(!ejercito.get(numSoldado).getVive()){
                                tablero[filaAnterior][columnaAnterior] = null;
                            }
                            else{
                                tablero[fila][columna] = ejercito.get(numSoldado);
                                tablero[filaAnterior][columnaAnterior] = null;
                            }
                        }
                    }
                    else{
                        tablero[fila][columna] = ejercito.get(numSoldado);
                        tablero[filaAnterior][columnaAnterior] = null;
                    }
                }
            }
        }
    }
    public static boolean estaVacioPers(ArrayList<Soldado> ejercito){
        int muerteTotal = 0;
        for(int i=0; i<ejercito.size(); i++){
            if(!ejercito.get(i).getVive())
                muerteTotal++;
        }
        if(muerteTotal == ejercito.size())
            return true;
        return false;
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
        String nombreReino = "";
        //Establecemos el nombre del reino que escogió
        if(eleccion == 1){
            reino.setNombreReino("Inglaterra");
            nombreReino = "Inglaterra";
        }
        else if(eleccion == 2){
            reino.setNombreReino("Francia");
            nombreReino = "Francia";
        }
        else if(eleccion == 3){
            reino.setNombreReino("Sacro Imperio");
            nombreReino = "Sacro Imperio";
        }
        else if(eleccion == 4){
            reino.setNombreReino("Castilla-Aragón");
            nombreReino = "Castilla-Aragón";
        }
        else if(eleccion == 5){
            reino.setNombreReino("Moros");
            nombreReino = "Moros";
        }
        //Establecemos la cantidad de ejercitos que contendrá el reino
        Ejercito ejercito = new Ejercito();
        ejercito.asignarEstadisticas(nombreReino);
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