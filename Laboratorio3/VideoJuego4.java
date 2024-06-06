package Laboratorio3;
import java.util.*;

//Autor: Quiñonez Delgado Aarón Fernando
public class VideoJuego4 {
    public static void main(String[] args){
        //Declaramos e inicializamos los ArrayList del ejercito 1 y 2
        ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>();
        ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>();
        //Creamos el tablero de 10x10
        Soldado[][] tablero = new Soldado[10][10];
        //Creamos el numero de soldados (entre 1 y 10) para cada ejercito
        int cantSoldados1 = (int) (Math.random()*10+1);
        int cantSoldados2 = (int) (Math.random()*10+1);
        //Usamos el metodo asignarNombres para generar los nombres
        nombresEjercito1(ejercito1, cantSoldados1);
        nombresEjercito2(ejercito2, cantSoldados2);
        //Establecemos las estadísticas de los soldados
        int vida, columna, fila;
        //Creamos un arreglo bidimensional booleano de tamaño 10x10 para asegurarnos que las filas y columnas no se repitan en los soldados
        boolean[][] comprobarPos = new boolean[10][10];
        for(int indice = 0; indice < ejercito1.size(); indice++){
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
            (ejercito1.get(indice)).setVida(vida);
            (ejercito1.get(indice)).setColumna(columna);
            (ejercito1.get(indice)).setFila(fila);
        }
        for(int indice = 0; indice < ejercito2.size(); indice++){
            vida = (int) (Math.random()*5+1);
            columna = (int) (Math.random()*10);
            fila = (int) (Math.random()*10);
            while(comprobarPos[fila][columna]){
                columna = (int) (Math.random()*9);
                fila = (int) (Math.random()*9);
            }
            comprobarPos[fila][columna] = true;
            //Guardamos los valores en los objetos de tipo Soldado
            (ejercito2.get(indice)).setVida(vida);
            (ejercito2.get(indice)).setColumna(columna);
            (ejercito2.get(indice)).setFila(fila);
        }
        //Imprimimos el tablero
        impTablero(tablero, ejercito1, ejercito2);
        //Imprimimos el soldado con mas vida
        soldadoMayorVida(ejercito1, ejercito2);
        //Imprimimos el promedio de vida
        promedioVida(ejercito1, ejercito2);
        //Imprimimos la lista
        soldadosCreados(ejercito1, ejercito2);
        //Imprimimos el ranking
        rankingDePoder(ejercito1, ejercito2);
        //Imprimimos el ganador
        EjercitoGanador(ejercito1, ejercito2);

    }
    public static ArrayList<Soldado> nombresEjercito1(ArrayList<Soldado> nombres, int cantidadEjercito){
        for(int indice = 0; indice < cantidadEjercito; indice++){
            String nombre = "Sold ";
            //Asignamos el nombre de cada soldado segun la posicion del indice más uno
            nombre += String.valueOf(indice+1) + "X1";
            //Creamos un objeto de tipo soldado para cambiar el nombre
            Soldado nombreSold = new Soldado();
            nombreSold.setNombre(nombre);
            nombres.add(nombreSold);
        }
        return nombres;
    }
    public static ArrayList<Soldado> nombresEjercito2(ArrayList<Soldado> nombres, int cantidadEjercito){
        for(int indice = 0; indice < cantidadEjercito; indice++){
            String nombre = "Sold ";
            nombre += String.valueOf(indice+1) + "X2";
            Soldado nombreSold = new Soldado();
            nombreSold.setNombre(nombre);
            nombres.add(nombreSold);
        }
        return nombres;
    }

    public static void impTablero(Soldado[][] tablero, ArrayList<Soldado> soldado1, ArrayList<Soldado> soldado2){
		//Establecemos las posiciones del ejercito 1
        for (int i = 0; i < soldado1.size(); i++) {
            int fila = soldado1.get(i).getFila();
            int columna = soldado1.get(i).getColumna();
            tablero[fila][columna] = soldado1.get(i);
        }
        //Establecemos las posiciones del ejercito 2
        for (int i = 0; i < soldado2.size(); i++) {
            int fila = soldado2.get(i).getFila();
            int columna = soldado2.get(i).getColumna();
            tablero[fila][columna] = soldado2.get(i);
        }
        //Imprimimos la tabla
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
    public static void soldadoMayorVida(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
		int mayorV1 = ejercito1.get(0).getVida();
        int mayorV2 = ejercito2.get(0).getVida();
        String soldado1 = ejercito1.get(0).getNombre();
        String soldado2 = ejercito2.get(0).getNombre();

        for(int i = 1; i < ejercito1.size(); i++){
            if(ejercito1.get(i).getVida() > mayorV1){
                mayorV1 = ejercito1.get(i).getVida();
                soldado1 = ejercito1.get(i).getNombre();
            }
        }

        for(int i = 1; i < ejercito2.size(); i++){
            if(ejercito2.get(i).getVida() > mayorV2){
                mayorV2 = ejercito2.get(i).getVida();
                soldado2 = ejercito2.get(i).getNombre();
            }
        }
        System.out.println("El soldado con mayor vida de Ejercito 1 es: " + soldado1); 
        System.out.println("El soldado con mayor vida de Ejercito 2 es: " + soldado2); 
	}
    public static void promedioVida(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
		int suma1 = 0;
		int suma2 = 0;
		for(int i = 0; i < ejercito1.size(); i++){
			suma1 += ejercito1.get(i).getVida();
		}
		int promedio1 = suma1/ejercito1.size();
		for(int i = 0; i < ejercito2.size(); i++){
			suma2 += ejercito2.get(i).getVida();
		}
		int promedio2 = suma2/ejercito2.size();
		System.out.println("El promedio de puntos de vida de los soldados del Ejercito 1 es: " + promedio1);
		System.out.println("El promedio de puntos de vida de los soldados del Ejercito 2 es: " + promedio2);
	}
	public static void soldadosCreados(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
		System.out.println("Ejercito 1:");
		for(int i = 0; i < ejercito1.size(); i++){
			System.out.println(ejercito1.get(i).getNombre() + " --> Vida: " + ejercito1.get(i).getVida());
		}
		System.out.println("Ejercito 2:");
		for(int i = 0; i < ejercito2.size(); i++){
			System.out.println(ejercito2.get(i).getNombre() + " --> Vida: " + ejercito2.get(i).getVida());
		}
	}
	public static void rankingDePoder(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
		for (int i = 1; i < ejercito1.size(); i++) {
			Soldado actual = ejercito1.get(i);
            int j = i - 1;
            while (j >= 0 && ejercito1.get(j).getVida() < actual.getVida()) {
                ejercito1.set(j+1, ejercito1.get(j));
                j--;
            }
            ejercito1.set(j+1, actual);
		}
		System.out.println("Ranking de poder de Ejercito 1:");
		for(int i = 0; i < ejercito1.size(); i++){
			System.out.println(ejercito1.get(i).getNombre() + "\t" + ejercito1.get(i).getVida());
		}
 		for (int i = 1; i < ejercito2.size(); i++) {
            Soldado actual = ejercito2.get(i);
            int j = i - 1;
            while (j >= 0 && ejercito2.get(j).getVida() < actual.getVida()) {
                ejercito2.set(j+1, ejercito2.get(j));
                j--;
            }
            ejercito2.set(j+1, actual);
        }
        System.out.println("Ranking de poder de Ejercito 2:");
        for(int i = 0; i < ejercito2.size(); i++){
            System.out.println(ejercito2.get(i).getNombre() + "\t" + ejercito2.get(i).getVida());
        }
	}
	public static void EjercitoGanador(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
		int suma1 = 0;
		int suma2 = 0;
		for(int i = 0; i < ejercito1.size(); i++){
			suma1 += ejercito1.get(i).getVida();
		}
		for(int i = 0; i < ejercito2.size(); i++){
			suma2 += ejercito2.get(i).getVida();
		}
		if(suma1 > suma2){
			System.out.println("EL EJERCITO 1 ES EL GANADOR");
		} else {
			System.out.println("EL EJERCITO 2 ES EL GANADOR");
		}
	}
}