package Laboratorio9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Soldado[] ejercito1 = new Soldado[random()];
        Soldado[] ejercito2 = new Soldado[random()];

        Soldado[][] tablero = new Soldado[10][10];

        System.out.println("EJERCITO 1:");
        asignarEstadisticas(ejercito1);
        System.out.println("\n--------------------------\n");
        System.out.println("EJERCITO 2:");
        asignarEstadisticas(ejercito2);

        ejercito1 = nombresEjercito1(ejercito1);
        ejercito2 = nombresEjercito2(ejercito2);

        System.out.println("\nEJERCITO 1:");
        for(int i=0; i<ejercito1.length; i++){
            System.out.println(ejercito1[i].toString());
        }
        System.out.println("------------------\n------------------");
        System.out.println("EJERCITO 2:");
        for(int i=0; i<ejercito2.length; i++){
            System.out.println(ejercito2[i].toString());
        }

        System.out.println("\nEJÉRCITO 1");
        soldadoMayorVida(ejercito1);
        System.out.println("\nEJÉRCITO 2");
        soldadoMayorVida(ejercito2);

        System.out.println("\nEJÉRCITO 1");
        vidaEjercito(ejercito1);
        System.out.println("\nEJÉRCITO 2");
        vidaEjercito(ejercito2);

        System.out.println("\nTABLERO\n");
        impTablero(tablero, ejercito1, ejercito2);

        int ganador = 0;
        boolean continuar = true;
        while(continuar){
            //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
            System.out.println("=============================================\nEJERCITO 1:");
            actitudSoldado(ejercito1, tablero);
            
            if(estaVacio(ejercito2)){
                ganador = 1;
                continuar = false;
                break;
            }

            System.out.println("=============================================\nEJERCITO 2:");
            actitudSoldado(ejercito2, tablero);

            //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
            if(estaVacio(ejercito1)){
                ganador = 2;
                continuar = false;
            }
        }
        if(ganador == 1){
            System.out.println("EL GANADOR ES EL EJÉRCITO 1");
        }
        else if(ganador == 2){
            System.out.println("EL GANADOR ES EL EJÉRCITO 2");
        }
    }  
    
    //Metodo random entre 1 y 10
    public static int random(){
        int rand = (int) (Math.random()*10+1);
        return rand;
    }
    //Metodo para asignar las estadísticas (ataque, defensa y vida)
    public static void asignarEstadisticas(Soldado[] ejercito){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<ejercito.length; i++){
            System.out.println("Soldado " + (i+1) + ":");
            //Pedimos al usuario que ingrese las estadísticas de cada soldado según la opción a escoger (1, 2 o las 3 estadisticas)
            System.out.println("Escoja cuántas estadisticas va a personalizar:\n(0)Ninguna estadistica\n(1)Solo una estadistica\n(2)Dos estadisticas\n(3)Tres estadisticas");
            int opcion = sc.nextInt();
            while(opcion < 0 || opcion > 3){
                System.out.println("Ingrese una opcion valida");
                opcion = sc.nextInt();
            }
            //Creamos un objeto de tipo Soldado para que sus datos se almacenen en el Array de ejercito1
            Soldado objeto;
            //Hacemos 3 casos segun la opcion que escogió
            if(opcion == 0){
                objeto = new Soldado();
            }
            else if(opcion == 1){
                System.out.print("Ingrese el nivel de ataque: ");
                int ataque = sc.nextInt();
                objeto = new Soldado(ataque);
            }
            else if(opcion == 2){
                System.out.print("Ingrese el nivel de ataque: ");
                int ataque = sc.nextInt();
                System.out.print("Ingrese el nivel de defensa: ");
                int defensa = sc.nextInt();
                objeto = new Soldado(ataque, defensa);
            }
            else{
                System.out.print("Ingrese el nivel de ataque: ");
                int ataque = sc.nextInt();
                System.out.print("Ingrese el nivel de defensa: ");
                int defensa = sc.nextInt();
                System.out.print("Ingrese el nivel de vida: ");
                int vida = sc.nextInt();
                System.out.println();
                objeto = new Soldado(ataque, defensa, vida);
            }
            //Ahora asignamos a ejercito1[i] los valores de objeto;
            ejercito[i] = objeto;
        }
    }
    //Metodo para generar nombres
    public static Soldado[] nombresEjercito1(Soldado[] ejercit1){
        for(int i=0; i<ejercit1.length; i++){
            String nombre = "Soldado" + i + "x" + "1";
            ejercit1[i].setNombre(nombre);
            ejercit1[i].setEjercito(1);
        }
        return ejercit1;
    }
    public static Soldado[] nombresEjercito2(Soldado[] ejercit2){
        for(int i=0; i<ejercit2.length; i++){
            String nombre = "Soldado" + i + "x" + "2";
            ejercit2[i].setNombre(nombre);
            ejercit2[i].setEjercito(2);
        }
        return ejercit2;
    }
    //Metodo para imprimir el tablero
    public static void impTablero(Soldado[][] tablero,Soldado[] ejer1, Soldado[] ejer2){
        //Usamos el metodo establecerPos para asignar las posiciones en el tablero de cada soldado
        establecerPos(ejer1, ejer2);
        for (int i = 0; i < ejer1.length; i++) {
            int fila = ejer1[i].getFila();
            int columna = ejer1[i].getColumna();
            tablero[fila][columna] = ejer1[i];
        }
        for (int i = 0; i < ejer2.length; i++) {
            int fila = ejer2[i].getFila();
            int columna = ejer2[i].getColumna();
            tablero[fila][columna] = ejer2[i];
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tablero[i][j] != null){
                    System.out.printf("| %-11s ", tablero[i][j].getNombre());
                } else {
                    System.out.print("|      _      ");
                }
            }
            System.out.println("|");
        }
    }
    public static void soldadoMayorVida(Soldado[] soldado){
        int mayorV = soldado[0].getNivelVida();
        String sold = "";
        for(int i = 1; i < soldado.length; i++){
            if(soldado[i].getNivelVida() >= mayorV){
                mayorV = soldado[i].getNivelVida();
                sold = soldado[i].getNombre();
            }
        }
        System.out.println("El soldado con mayor vida es: " + sold);
    }

    public static void vidaEjercito(Soldado[] soldado){
        double suma = 0.0;
        for(int i = 0; i < soldado.length; i++){
            suma += soldado[i].getNivelVida();
        }
        double promedio = suma/soldado.length;
        System.out.println("El promedio de puntos de vida de los soldados es: " + promedio);
        System.out.println("El nivel de vida de todo el ejercito es: " + ( (int) suma));
    }

    public static void rankingPoder(Soldado[] soldados){
        System.out.println("RANKING DE PODER:");
        for (int i = 1; i < soldados.length; i++) {
            Soldado soldadoActual = soldados[i];
            int j = i - 1;
            while (j >= 0 && soldados[j].getNivelVida() < soldadoActual.getNivelVida()) {
                soldados[j + 1] = soldados[j];
                j--;
            }
            soldados[j + 1] = soldadoActual;
        }
        for(int i = 0; i < soldados.length; i++){
            System.out.println(soldados[i].getNombre() + "\t" + soldados[i].getNivelVida());
        }
    }
    //Metodo para imprimir el tablero despues de atacar/huir
    public static void impTableroActual(Soldado[][] tablero){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tablero[i][j] != null){
                    System.out.printf("| %-11s ", tablero[i][j].getNombre());
                } else {
                    System.out.print("|      _      ");
                }
            }
            System.out.println("|");
        }
    }
    //Metodo para establecer las posiciones de cada soldado sin que se repitan
    public static void establecerPos(Soldado[] ejer1, Soldado[] ejer2){
        boolean[][] posiciones = new boolean[10][10];
        //Todos los valores de la tabla estarán en false por defecto
        for(int indice = 0; indice < ejer1.length; indice++){
            //Establecemos valores aleatorios de columna y fila para cada soldado
            int columna = (int) (Math.random()*10);
            int fila = (int) (Math.random()*10);
            //Comprobamos si fila y columna no se repiten
            //Si es true, entonces la posicion ya está ocupada. Si es false, la posicion no está ocupada
            while(posiciones[fila][columna]){
                columna = (int) (Math.random()*10);
                fila = (int) (Math.random()*10);
            }
            posiciones[fila][columna] = true;
            //Guardamos los valores de fila y columna en los objetos de tipo Soldado
            ejer1[indice].setFila(fila);
            ejer1[indice].setColumna(columna);
        }
        //Realizamos lo mismo para el ejercito2
        for(int indice = 0; indice < ejer2.length; indice++){
            int columna = (int) (Math.random()*10);
            int fila = (int) (Math.random()*10);
            while(posiciones[fila][columna]){
                columna = (int) (Math.random()*10);
                fila = (int) (Math.random()*10);
            }
            posiciones[fila][columna] = true;
            ejer2[indice].setFila(fila);
            ejer2[indice].setColumna(columna);
        }
    }
    //Metodo para escoger la actitud del soldado
    public static void actitudSoldado(Soldado[] ejercito, Soldado[][] tablero){
        System.out.println("Escoja al soldado:");
        Scanner sc = new Scanner(System.in);
        int numSoldado = sc.nextInt();
        System.out.println("Seleccione su actitud:\n(1)Defensivo\n(2)Ofensivo\n(3)Fuga(retroceder)");
        int actitud = sc.nextInt();
        //Segun la actitud que se eligio vamos a usar metodos para comprobar si hay un soldado del equipo enemigo al retroceder/avanzar
        int velocidad = ejercito[numSoldado].getVelocidad();
        if(actitud == 3 && velocidad != 0){
            //Si es distinto a 0, entonces tendra que detenerse y tomar actitud defensiva
            System.out.println("Velocidad distinta a 0, cambiando a posicion defensiva.");
            actitud = 1;
        }
        if(actitud == 1){
            //Defensivo, no cambia de posicion
            ejercito[numSoldado].setActitud("Defensivo");
            velocidad = 0;
            ejercito[numSoldado].setVelocidad(velocidad);
        }  
        else if(actitud == 2){
            //Ofensivo, avanzará una casilla y su velocidad también cambiará
            ejercito[numSoldado].setActitud("Ofensivo");
            velocidad++;
            ejercito[numSoldado].setVelocidad(velocidad);
            int filaAnterior = ejercito[numSoldado].getFila();
            int columnaAnterior = ejercito[numSoldado].getColumna();
            //Le preguntamos al usuario hacia donde va a mover el soldado (arriba, derecha o izquierda)
            moverSoldado(ejercito[numSoldado]);
            //Comprobamos si cruza con un enemigo o aliado. Si es enemigo, lo ataca; si es aliado, vuelve a su posicion original
            int numEjercito = ejercito[numSoldado].getEjercito();
            int fila = ejercito[numSoldado].getFila();
            int columna = ejercito[numSoldado].getColumna();
            if(tablero[fila][columna] != null){
                //Si es aliado
                if(tablero[fila][columna].getEjercito() == numEjercito){
                    System.out.println("Es aliado, volviendo a la casilla original");
                    ejercito[numSoldado].retroceder();
                    impTableroActual(tablero);
                }
                //Si es enemigo
                else{
                    ejercito[numSoldado].atacar(tablero[fila][columna]);
                    //Comprobamos quien muere para actualizar el tablero
                    if(!ejercito[numSoldado].getVive()){
                        tablero[filaAnterior][columnaAnterior] = null;
                    }
                    else{
                        tablero[fila][columna] = ejercito[numSoldado];
                        tablero[filaAnterior][columnaAnterior] = null;
                    }
                    impTableroActual(tablero);
                }
            }
            else{
                tablero[fila][columna] = ejercito[numSoldado];
                tablero[filaAnterior][columnaAnterior] = null;
                impTableroActual(tablero);
            }
        }
        else{
            //Fuga, retrocederá 1 casilla si su velocidad es 0, no se moverá si su velocidad es mayor a 0
            ejercito[numSoldado].setActitud("Fuga");
            int filaAnterior = ejercito[numSoldado].getFila();
            int columnaAnterior = ejercito[numSoldado].getColumna();
            if(ejercito[numSoldado].getVelocidad() != 0){
                System.out.println("Velocidad cambiada a 0, cambiando a actitud de defensa");
                ejercito[numSoldado].setActitud("Defensivo");
                velocidad = 0;
                ejercito[numSoldado].setVelocidad(velocidad);
                impTableroActual(tablero);
            }
            else{
                ejercito[numSoldado].retroceder();
                if(!dentroDelTablero(ejercito[numSoldado])){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    ejercito[numSoldado].avanzar();
                }
                else{
                    int fila = ejercito[numSoldado].getFila();
                    int columna = ejercito[numSoldado].getColumna();
                    if(tablero[fila][columna] != null){
                        //Si es aliado
                        if(tablero[fila][columna].getEjercito() == ejercito[numSoldado].getEjercito()){
                            System.out.println("Es aliado, volviendo a la casilla original");
                            ejercito[numSoldado].retroceder();
                            impTableroActual(tablero);
                        }
                        //Si es enemigo
                        else{
                            ejercito[numSoldado].atacar(tablero[fila][columna]);
                            //Comprobamos quien muere para actualizar el tablero
                            if(!ejercito[numSoldado].getVive()){
                                tablero[filaAnterior][columnaAnterior] = null;
                            }
                            else{
                                tablero[fila][columna] = ejercito[numSoldado];
                                tablero[filaAnterior][columnaAnterior] = null;
                            }
                            impTableroActual(tablero);
                        }
                    }
                    else{
                        tablero[fila][columna] = ejercito[numSoldado];
                        tablero[filaAnterior][columnaAnterior] = null;
                        impTableroActual(tablero);
                    }
                }
            }
        }
    }
    //Metodo para comprobar si se sale del tablero
    public static boolean dentroDelTablero(Soldado soldado){
        if(soldado.getFila() >= 0 && soldado.getFila() <= 9){
            if(soldado.getColumna() >= 0 && soldado.getColumna() <= 9){
                return true;
            }
        }
        return false;
    }
    //Metodo si el soldado tiene actitud ofensiva y que el usuario escoja la direccion a ir (arriba, derecha o izquierda)
    public static void moverSoldado(Soldado soldado){
        Scanner sc = new Scanner(System.in);
        boolean repetir = true;
        while(repetir){
            System.out.println("Hacia donde se moverá el soldado\n(1)Arriba\n(2)Derecha\n(3)Izquierda");
            int mov = sc.nextInt();
            if(mov == 1){
                soldado.avanzar();
                if(!dentroDelTablero(soldado)){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    soldado.retroceder();
                }
                else repetir = false;
            }
            else if(mov == 2){
                soldado.derecha();
                if(!dentroDelTablero(soldado)){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    soldado.izquerda();
                }
                else repetir = false;
            }
            else{
                soldado.izquerda();
                if(!dentroDelTablero(soldado)){
                    System.out.println("Esta moviéndose fuera del tablero, regresando a la posicion anterior.");
                    soldado.derecha();
                }
                else repetir = false;
            }
        }
    }
    public static boolean estaVacio(Soldado[] ejercito){
        //Creamos un bucle que revisará el estado de cada soldado
        int muerteTotal = 0;
        for(int i=0; i<ejercito.length; i++){
            if(!ejercito[i].getVive()){
                muerteTotal++;
            }
        }
        //Si muerteTotal es igual a la cantidad de soldados del ejercito entonces ese equipo ya perdió
        if(muerteTotal == ejercito.length){
            return true;
        }
        return false;
    }
}