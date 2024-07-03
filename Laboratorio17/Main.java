package Laboratorio17;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(1<2){
            System.out.println("Seleccione una opción:\n(1)Comenzar juego\n(2)Salir");
            int opcion = sc.nextInt();
            if(opcion == 1){
                //JUEGO
                //Creamos la clase ejército que contendra a los espadachines, arqueros y caballeros
                Ejercito ejercito1 = new Ejercito();
                ejercito1.asignarEstadisticas();
                ejercito1.establecerEquipo(1);
                ejercito1.asignarNombres();

                Ejercito ejercito2 = new Ejercito();
                ejercito2.asignarEstadisticas();
                ejercito2.establecerEquipo(2);
                ejercito2.asignarNombres();
                //Imprimimos a los soldados en el orden que fueron creados
                System.out.println("EJERCITO 1: \n" + ejercito1.toString());
                System.out.println("\n------------------------------\n");
                System.out.println("EJERCITO 2: \n" + ejercito2.toString());
                //Imprimimos el promedio de vida, soldado con más vida, ranking de poder
                System.out.println("\n------------------------------\nEJÉRCITO 1:");
                vidaEjercito(ejercito1.getEjercito());
                soldadoMayorVida(ejercito1.getEjercito());
                rankingPoder(ejercito1.getEjercito());
                System.out.println("\n------------------------------\n");
                System.out.println("\n------------------------------\nEJÉRCITO2:");
                vidaEjercito(ejercito2.getEjercito());
                soldadoMayorVida(ejercito2.getEjercito());
                rankingPoder(ejercito2.getEjercito());
                System.out.println("\n------------------------------\n");
                //Imprimimos el tablero
                Mapa tablero = new Mapa();
                tablero.establecerPosEjercito(ejercito1.getEjercito(), ejercito2.getEjercito());
                tablero.impTableroPers(ejercito1.getEjercito(), ejercito2.getEjercito());
                //Comienza el juego entre los usuarios
                int ganador = 0;
                boolean continuar = true;
                while(continuar){
                    //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                    System.out.println("=============================================\nEJERCITO 1:");
                    actitudSoldadoPers(ejercito1.getEjercito(), ejercito2, tablero.getTablero());
                    tablero.impTableroActual();
                    if(estaVacioPers(ejercito2.getEjercito())){
                        ganador = 1;
                        continuar = false;
                        break;
                    }
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + ejercito1.getVivos());
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + ejercito2.getVivos());
                    System.out.println("=============================================\nEJERCITO 2:");
                    actitudSoldadoPers(ejercito2.getEjercito(), ejercito1, tablero.getTablero());
                    tablero.impTableroActual();
                    //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
                    if(estaVacioPers(ejercito1.getEjercito())){
                        ganador = 2;
                        continuar = false;
                        break;
                    }
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + ejercito1.getVivos());
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + ejercito2.getVivos());
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
                        ejercito.remove(numSoldado);
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
}