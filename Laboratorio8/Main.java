package Laboratorio8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Ponemos un numero aleatorio entre 1 y 10 para la cantidad de soldados
        Soldado[] ejercito1 = new Soldado[random()];
        Soldado[] ejercito2 = new Soldado[random()];

        //Creamos un tablero de 10x10 para almacenar ambos ejercitos
        Soldado[][] tablero = new Soldado[10][10];

        //Usamos el método asignarEstadisticas para ambos ejercitos
        System.out.println("EJERCITO 1:");
        asignarEstadisticas(ejercito1);
        System.out.println("--------------------------");
        System.out.println("EJERCITO 2:");
        asignarEstadisticas(ejercito2);

        //Generamos sus nombres autogenerados con el metodo nombres
        ejercito1 = nombresEjercito1(ejercito1);
        ejercito2 = nombresEjercito2(ejercito2);

        //Imprimimos el tablero
        impTablero(tablero, ejercito1, ejercito2);

        //Imprimimos las estadisticas base (nombre, vida, ataque, defensa, fila y columna)
        for(int i=0; i<ejercito1.length; i++){
            System.out.println(ejercito1[i].toString());
        }
        System.out.println("------------------\n------------------");
        for(int i=0; i<ejercito2.length; i++){
            System.out.println(ejercito2[i].toString());
        }

        //Ahora preguntamos al usuario que escoja la actitud del soldado que escoja
        boolean continuar = true;
        while(continuar){
            System.out.println("Escoja al soldado: (Solo del ejercito 1)");
            int numSoldado = sc.nextInt();
            System.out.println("Seleccione su actitud:\n(1)Defensivo\n(2)Ofensivo(arriba-abajo)\n(3)Fuga(abajo-arriba)");
            int actitud = sc.nextInt();
            //Segun la actitud que se eligio vamos a usar metodos para comprobar si hay un soldado del equipo enemigo al retroceder/avanzar
            int velocidad = ejercito1[numSoldado].getVelocidad();
            if(actitud == 3 && velocidad != 0){
                //Si es distinto a 0, entonces tendra que detenerse y tomar actitud defensiva
                System.out.println("Velocidad distinta a 0, cambiando a posicion defensiva.");
                actitud = 1;
            }
            if(actitud == 1){
                //Defensivo, no cambia de posicion
                ejercito1[numSoldado].setActitud("Defensivo");
                velocidad = 0;
                ejercito1[numSoldado].setVelocidad(velocidad);
            }  
            else if(actitud == 2){
                //Ofensivo, avanzará una casilla y su velocidad también cambiará
                ejercito1[numSoldado].setActitud("Ofensivo");
                velocidad++;
                ejercito1[numSoldado].setVelocidad(velocidad);
                ejercito1[numSoldado].avanzar();
                //Comprobamos si cruza con un enemigo o aliado. Si es enemigo, lo ataca; si es aliado, vuelve a su posicion original
                int fila = ejercito1[numSoldado].getFila();
                int columna = ejercito1[numSoldado].getColumna();
                if(tablero[fila][columna] != null){
                    //Si es aliado
                    if(tablero[fila][columna].getEjercito() == 1){
                        System.out.println("Es aliado, volviendo a la casilla original");
                        ejercito1[numSoldado].retroceder();
                    }
                    //Si es enemigo
                    else{
                        while(ejercito1[numSoldado].getVive() && tablero[fila][columna].getVive()){
                            ejercito1[numSoldado].atacar(tablero[fila][columna]);
                            if(tablero[fila][columna].getVive()){
                                tablero[fila][columna].atacar(ejercito1[numSoldado]);
                            }
                        }
                        //Comprobamos quien muere para actualizar el tablero
                        if(!ejercito1[numSoldado].getVive()){
                            tablero[fila-1][columna] = null;
                        }
                        else{
                            tablero[fila][columna] = ejercito1[numSoldado];
                            tablero[fila-1][columna] = null;
                        }
                    }
                }
                else{
                    tablero[fila][columna] = ejercito1[numSoldado];
                    fila--;
                    tablero[fila][columna] = null;
                    impTableroActual(tablero);
                }
            }
            else{
                //Fuga, retrocederá 1 casilla si su velocidad es 0, no se moverá si su velocidad es mayor a 0
                ejercito1[numSoldado].setActitud("Fuga");
                if(ejercito1[numSoldado].getVelocidad() != 0){
                    System.out.println("Velocidad cambiada a 0, cambiando a actitud de defensa");
                    ejercito1[numSoldado].setActitud("Defensivo");
                    velocidad = 0;
                    ejercito1[numSoldado].setVelocidad(velocidad);
                    impTableroActual(tablero);
                }
                else{
                    ejercito1[numSoldado].retroceder();
                    int fila = ejercito1[numSoldado].getFila();
                    int columna = ejercito1[numSoldado].getColumna();
                    if(tablero[fila][columna] != null){
                        //Si es aliado
                        if(tablero[fila][columna].getEjercito() == 1){
                            System.out.println("Es aliado, volviendo a la casilla original");
                            ejercito1[numSoldado].retroceder();
                        }
                        //Si es enemigo
                        else{
                            while(ejercito1[numSoldado].getVive() && tablero[fila][columna].getVive()){
                                ejercito1[numSoldado].atacar(tablero[fila][columna]);
                                if(tablero[fila][columna].getVive()){
                                    tablero[fila][columna].atacar(ejercito1[numSoldado]);
                                }
                            }
                            //Comprobamos quien muere para actualizar el tablero
                            if(!ejercito1[numSoldado].getVive()){
                                tablero[fila+1][columna] = null;
                            }
                            else{
                                tablero[fila][columna] = ejercito1[numSoldado];
                                tablero[fila+1][columna] = null;
                            }
                            impTableroActual(tablero);
                        }
                    }
                    else{
                        tablero[fila][columna] = ejercito1[numSoldado];
                        fila++;
                        tablero[fila][columna] = null;
                        impTableroActual(tablero);
                    }
                }
                
            }
            
            System.out.println("Escriba '1' para no continuar. Pulse cualquier otro numero si quiere continuar");
            int decision = sc.nextInt();
            if(decision == 1){
                continuar = false;
            }
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
}