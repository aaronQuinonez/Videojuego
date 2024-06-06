package Laboratorio1;

//Laboratorio Nro 1
//Autor: Quiñonez Delgado Aarón Fernando
public class VideoJuego2 {
    public static void main(String[] args){
        //Creamos el tablero de 10x10
        Soldado[][] tablero = new Soldado[10][10];
        //Creamos el numero de soldados (entre 1 y 10)
        int cantSoldados = (int) (Math.random()*10+1);
        //Creamos un arreglo unidimensional que almacenara a los soldados y sus respectivos datos(nombre, vida, fila y columna)
        Soldado[] soldados = new Soldado[cantSoldados];
        //Usamos el metodo asignarNombres para generar los nombres
        asignarNombres(soldados);
        //Establecemos las estadísticas de los soldados
        estadisticasSoldados(soldados);
        //Imprimimos el tablero
        impTablero(tablero, soldados);
        System.out.println("----------------------------");
        //Imprimimos los datos del soldado con mayor vida
        soldadoMayorVida(soldados);
        System.out.println("----------------------------");
        //Imprimimos el promedio y suma de vida de todos los soldados
        vidaEjercito(soldados);
        System.out.println("----------------------------");
        //Imprimimos los datos de todos los soldados
        listaSoldados(soldados);
        System.out.println("----------------------------");
        //Imprimimos el ranking de poder
        rankingPoder(soldados);
    }
    public static Soldado[] asignarNombres(Soldado[] nombres){
        for(int indice = 0; indice < nombres.length; indice++){
            String nombre = "Soldado";
            //Asignamos el nombre de cada soldado segun la posicion del indice más uno
            nombre += String.valueOf(indice+1);
            //Creamos un objeto de tipo soldado para cambiar el nombre
            Soldado nombreSold = new Soldado();
            nombreSold.setNombre(nombre);
            nombres[indice] = nombreSold;
        }
        return nombres;
    }

    public static Soldado[] estadisticasSoldados(Soldado[] soldado){
        int vida, columna, fila;
        //Creamos un arreglo bidimensional booleano de tamaño 10x10 para asegurarnos que las filas y columnas no se repitan en los soldados
        boolean[][] comprobarPos = new boolean[10][10];
        for(int indice = 0; indice < soldado.length; indice++){
            //Establecemos valores aleatorios para vida, columna y fila
            vida = (int) (Math.random()*5+1);
            columna = (int) (Math.random()*10);
            fila = (int) (Math.random()*10);
            //Comprobamos si fila y columna no se repiten
            //Si es true, entonces la posicion ya está ocupada. Si es false, la posicion no está ocupada
            while(comprobarPos[fila][columna]){
                columna = (int) (Math.random()*9);
                fila = (int) (Math.random()*9);
            }
            comprobarPos[fila][columna] = true;
            //Guardamos los valores en los objetos de tipo Soldado
            soldado[indice].setVida(vida);
            soldado[indice].setColumna(columna);
            soldado[indice].setFila(fila);
        }
        return soldado;
    }
    public static void impTablero(Soldado[][] tablero,Soldado[] soldado){
		for (int i = 0; i < soldado.length; i++) {
            int fila = soldado[i].getFila();
            int columna = soldado[i].getColumna();
            tablero[fila][columna] = soldado[i];
        }
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(tablero[i][j] != null){
					System.out.print("| " + tablero[i][j].getNombre() + "(" + tablero[i][j].getVida() + ") ");
				} else {
					System.out.print("|      _      ");
				}
			}
			System.out.println("|");
		}	
	}

    public static void soldadoMayorVida(Soldado[] soldado){
        int mayorV = soldado[0].getVida();
		String sold = "";
		for(int i = 1; i < soldado.length; i++){
			if(soldado[i].getVida() >= mayorV){
				mayorV = soldado[i].getVida();
				sold = soldado[i].getNombre();
			}
		}
		System.out.println("El soldado con mayor vida es: " + sold);
    }

    public static void vidaEjercito(Soldado[] soldado){
        double suma = 0.0;
		for(int i = 0; i < soldado.length; i++){
			suma += soldado[i].getVida();
		}
		double promedio = suma/soldado.length;
		System.out.println("El promedio de puntos de vida de los soldados es: " + promedio);
		System.out.println("El nivel de vida de todo el ejercito es: " + ( (int) suma));
    }

    public static void listaSoldados(Soldado[] soldados){
        for(int i = 0; i < soldados.length; i++){
			System.out.println(soldados[i].getNombre());
			System.out.println("Vida: " + soldados[i].getVida());
			System.out.println("Fila: " + soldados[i].getFila());
			System.out.println("Columna: " + soldados[i].getColumna() + "\n");
		}
    }

    public static void rankingPoder(Soldado[] soldados){
        System.out.println("RANKING DE PODER:");
        for (int i = 1; i < soldados.length; i++) {
			Soldado soldadoActual = soldados[i];
            int j = i - 1;
            while (j >= 0 && soldados[j].getVida() < soldadoActual.getVida()) {
                soldados[j + 1] = soldados[j];
                j--;
            }
            soldados[j + 1] = soldadoActual;
		}
		for(int i = 0; i < soldados.length; i++){
			System.out.println(soldados[i].getNombre() + "\t" + soldados[i].getVida());
		}
    }
}