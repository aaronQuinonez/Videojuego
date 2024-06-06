package Laboratorio10;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Creamos el menu que contendrá los 2 modos de juego
        System.out.println("BIENVENIDO");
        while(1<2){
            System.out.println("Escoja el modo de juego:\n(1)Juego rápido\n(2)Juego personalizado\n(3)Salir");
            int opcion = sc.nextInt();
            if(opcion==1){
                Tablero tablero = new Tablero();
                System.out.println("--------------------------------------");
                System.out.println("Generando ejércitos");
                System.out.println("--------------------------------------");
                Personalizado ejercito1 = new Personalizado();
                ejercito1.asignarEstadisticas();
                ejercito1.establecerEquipo(1);
                ejercito1.asignarNombres();
                Personalizado ejercito2 = new Personalizado();
                ejercito2.asignarEstadisticas();
                ejercito2.establecerEquipo(2);
                ejercito2.asignarNombres();
                tablero.establecerPosPersonalizado(ejercito1.getEjercito(), ejercito2.getEjercito());
                System.out.println("--------------------------------------");
                System.out.println("Ejército 1");
                System.out.println("--------------------------------------");
                System.out.println(ejercito1.toString());
                System.out.println("--------------------------------------");
                System.out.println("Ejército 2");
                System.out.println("--------------------------------------");
                System.out.println(ejercito2.toString());
                //Imprimimos el tablero
                tablero.impTableroPers(ejercito1.getEjercito(), ejercito2.getEjercito());
                //Comienza el juego entre los usuarios
                int ganador = 0;
                boolean continuar = true;
                while(continuar){
                    //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                    System.out.println("=============================================\nEJERCITO 1:");
                    actitudSoldadoPers(ejercito1.getEjercito(), tablero.getTablero());
                    tablero.impTableroActual();
                    if(estaVacioPers(ejercito2.getEjercito())){
                        ganador = 1;
                        continuar = false;
                        break;
                    }
                    System.out.println("=============================================\nEJERCITO 2:");
                    actitudSoldadoPers(ejercito2.getEjercito(), tablero.getTablero());
                    tablero.impTableroActual();
                    //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
                    if(estaVacioPers(ejercito1.getEjercito())){
                        ganador = 2;
                        continuar = false;
                    }
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
            }
            else if(opcion==2){
                Tablero tablero = new Tablero();
                //Personalizado (Usaremos ArrayList para evitar conflictos con las opciones de agregar y eliminar soldados)
                System.out.println("--------------------------------------");
                System.out.println("Generando ejércitos");
                System.out.println("--------------------------------------");
                Personalizado ejercito1 = new Personalizado();
                ejercito1.asignarEstadisticas();
                ejercito1.establecerEquipo(1);
                ejercito1.asignarNombres();
                Personalizado ejercito2 = new Personalizado();
                ejercito2.asignarEstadisticas();
                ejercito2.establecerEquipo(2);
                ejercito2.asignarNombres();
                
                tablero.establecerPosPersonalizado(ejercito1.getEjercito(), ejercito2.getEjercito());

                System.out.println("DATOS\n\n");
                System.out.println("EJERCITO 1:\n"); 
                ejercito1.toString();
                System.out.println("\n\nEJERCITO 2:\n");
                ejercito2.toString();
                boolean continuar = true;
                while(continuar){
                    //Pedimos a que ejército va a personalizar
                    System.out.println("Escoja el ejército a personalizar:");
                    int numEjer = sc.nextInt();
                    //Creamos un ArrayList de tipo soldado que tendrá las mismas estadísticas que el ejército escogido
                    Personalizado ejercitoPerson = new Personalizado();
                    if(numEjer == 1){
                        ejercitoPerson = ejercito1;
                    }else if(numEjer == 2){
                        ejercitoPerson = ejercito2;
                    }
                    //Mostramos las opciones para personalizar al ejército
                    System.out.println("Escoja las siguientes opciones:\n(a)Crear Soldado\n(b)Eliminar Soldado\n(c)Clonar Soldado\n(d)Modificar Soldado\n(e)Comparar Soldados\n(f)Intercambiar soldados\n(g)Ver soldado\n(h)Ver ejército\n(i)Sumar niveles\n(j)Jugar\n(k)Volver");
                    String opc = sc.next();
                    if(opc.equals("a")){
                        //Crear Soldado, permitirá crear un nuevo soldado personalizado y añadir al final del ejército (recordar que límite es de 10 soldados por ejército)
                        if(ejercitoPerson.getEjercito().size() == 10){
                            System.out.println("No se puede crear más soldados, volviendo al menú");
                        }
                        else{
                            System.out.println("Ingrese las estadísticas del soldado:");
                            System.out.println("Ataque:");
                            int ataque = sc.nextInt();
                            System.out.println("Defensa:");
                            int defensa = sc.nextInt();
                            System.out.println("Vida:");
                            int vida = sc.nextInt();
                            //Asignamos los valores ingresados en un nuevo objeto Soldado
                            Soldado soldadoNuevo = new Soldado(ataque, defensa, vida);
                            soldadoNuevo.setEjercito(numEjer);
                            soldadoNuevo.setNombre("Soldado" + (ejercitoPerson.getEjercito().size()) + "x" + numEjer);
                            tablero.establecerNuevaPos(soldadoNuevo);
                            //Agregamos al soldado nuevo en nuestro ArrayList
                            ejercitoPerson.getEjercito().add(soldadoNuevo);
                            System.out.println("\n\nVOLVIENDO AL MENÚ\n\n");
                        }
                    }
                    else if(opc.equals("b")){
                        //Eliminar Soldado (no debe permitir un ejército vacío)
                        if(ejercitoPerson.getEjercito().size() == 1){
                            System.out.println("El ejército no debe quedar vacío");
                        }
                        else{
                            //Eliminamos al último soldado del ejército
                            System.out.println("El " + ejercitoPerson.getEjercito().get(ejercitoPerson.getEjercito().size()-1).getNombre() + " será eliminado");
                            tablero.quitarPos(ejercitoPerson.getEjercito().get(ejercitoPerson.getEjercito().size()-1).getFila(), ejercitoPerson.getEjercito().get(ejercitoPerson.getEjercito().size()-1).getColumna());
                            ejercitoPerson.getEjercito().remove(ejercitoPerson.getEjercito().size()-1);
                        }
                    }
                    else if(opc.equals("c")){
                        //Clonar Soldado (crea una copia exacta del soldado) y se añade al final del ejército (recordar que límite es de 10 soldados por ejército)
                        if(ejercitoPerson.getEjercito().size() == 10){
                            System.out.println("No se puede crear más soldados, volviendo al menú");
                        }
                        else{
                            System.out.println("Escoja el numero del soldado a clonar:");
                            int num = sc.nextInt();
                            if(num >= 0 && num < ejercitoPerson.getEjercito().size()){
                                //Creamos un soldado con las características del soldado elegido;
                                Soldado soldadoClon = new Soldado();
                                soldadoClon = ejercitoPerson.getEjercito().get(num);
                                soldadoClon.setNombre("Soldado" + ejercitoPerson.getEjercito().size() + "x" + numEjer);
                                tablero.establecerNuevaPos(soldadoClon);
                                //Agregamos al soldado clonado a nuestro ejército
                                ejercitoPerson.getEjercito().add(soldadoClon);
                            }
                            else{
                                System.out.println("Ingrese un numero que pertenezca a uno de los soldados");
                            }
                        }
                    }
                    else if(opc.equals("d")){
                        //Modificar Soldado (con submenú para cambiar alguno de los atributos nivelAtaque, nivelDefensa, vidaActual)
                        System.out.println("Escoja el numero del soldado a modificar");
                        int num = sc.nextInt();
                        if(num >= 0 && num <ejercitoPerson.getEjercito().size()){
                            System.out.println("Escoja el atributo a modificar:\n(1)Ataque\n(2)Defensa\n(3)Vida");
                            int atributo = sc.nextInt();
                            if(atributo == 1){
                                System.out.println("Cambie el nivel de ataque");
                                int ataque = sc.nextInt();
                                ejercitoPerson.getEjercito().get(num).setNivelAtaque(ataque);
                            }
                            else if(atributo == 2){
                                System.out.println("Cambie el nivel de defensa");
                                int defensa = sc.nextInt();
                                ejercitoPerson.getEjercito().get(num).setNivelDefensa(defensa);
                            }
                            else if(atributo == 3){
                                System.out.println("Cambie el nivel de vida");
                                int vida = sc.nextInt();
                                ejercitoPerson.getEjercito().get(num).setNivelVida(vida);
                            }
                            else{
                                System.out.println("Ingrese una opción válida");
                            }
                        }
                        else{
                            System.out.println("Ingrese un numero que pertenezca a uno de los soldados");
                        }
                    }
                    else if(opc.equals("e")){
                        //Comparar Soldados (verifica si atributos: nivelAtaque, nivelDefensa, vidaActual y vive son iguales)
                        for(int i=0; i<ejercitoPerson.getEjercito().size(); i++){
                            System.out.println("Ingrese el numero del primer soldado a comparar");
                            int primerSoldado = sc.nextInt();
                            System.out.println("Ingrese el numero del segundo soldado a comparar");
                            int segundoSoldado = sc.nextInt();
                            if((primerSoldado >= 0 && primerSoldado < ejercitoPerson.getEjercito().size()) && (segundoSoldado >= 0 && segundoSoldado < ejercitoPerson.getEjercito().size())){
                                //Comparamos ataque
                                if(ejercitoPerson.getEjercito().get(primerSoldado).getNivelAtaque() == ejercitoPerson.getEjercito().get(segundoSoldado).getNivelAtaque()){
                                    System.out.println("Poseen el mismo nivel de ataque " + "(" + ejercitoPerson.getEjercito().get(primerSoldado).getNivelAtaque() + ")");
                                }
                                //Comparamos defensa
                                if(ejercitoPerson.getEjercito().get(primerSoldado).getNivelDefensa() == ejercitoPerson.getEjercito().get(segundoSoldado).getNivelDefensa()){
                                    System.out.println("Poseen el mismo nivel de defensa " + "(" + ejercitoPerson.getEjercito().get(primerSoldado).getNivelDefensa() + ")");
                                }
                                //Comparamos vida
                                if(ejercitoPerson.getEjercito().get(primerSoldado).getNivelVida() == ejercitoPerson.getEjercito().get(segundoSoldado).getNivelVida()){
                                    System.out.println("Poseen el mismo nivel de vida " + "(" + ejercitoPerson.getEjercito().get(primerSoldado).getNivelVida() + ")");
                                }
                            }
                            else{
                                System.out.println("Ingrese un numero que pertenezca a uno de los soldados");
                            }
                        }
                    }
                    else if(opc.equals("f")){
                        //Intercambiar Soldados (intercambia 2 soldados en sus posiciones en la estructura de datos del ejército)
                        System.out.println("Ingrese el numero del primer soldado a intercambiar");
                        int primerSoldado = sc.nextInt();
                        System.out.println("Ingrese el numero del segundo soldado a intercambiar");
                        int segundoSoldado = sc.nextInt();
                        if((primerSoldado >= 0 && primerSoldado < ejercitoPerson.getEjercito().size()) && (segundoSoldado >= 0 && segundoSoldado < ejercitoPerson.getEjercito().size())){
                            int filaPrimerSold = ejercitoPerson.getEjercito().get(primerSoldado).getFila();
                            int filaSegundoSold = ejercitoPerson.getEjercito().get(segundoSoldado).getFila();
                            int columnaPrimerSold = ejercitoPerson.getEjercito().get(primerSoldado).getColumna();
                            int columnaSegundoSold = ejercitoPerson.getEjercito().get(segundoSoldado).getColumna();
                            tablero.cambiarPos(ejercitoPerson.getEjercito().get(primerSoldado), ejercitoPerson.getEjercito().get(segundoSoldado));
                            ejercitoPerson.getEjercito().get(primerSoldado).setFila(filaSegundoSold);
                            ejercitoPerson.getEjercito().get(primerSoldado).setColumna(columnaSegundoSold);
                            ejercitoPerson.getEjercito().get(segundoSoldado).setFila(filaPrimerSold);
                            ejercitoPerson.getEjercito().get(segundoSoldado).setColumna(columnaPrimerSold);
                        }
                    }
                    else if(opc.equals("g")){
                        //Ver soldado (Búsqueda por nombre) 
                        System.out.println("Ingrese el numero del soldado a ver:");
                        int numSold = sc.nextInt();
                        if((numSold >= 0 && numSold < ejercitoPerson.getEjercito().size())){
                            System.out.println(ejercitoPerson.getEjercito().get(numSold).toString());
                        }
                        else{
                            System.out.println("Ingrese un numero que pertenezca a uno de los soldados");
                        }
                    }
                    else if(opc.equals("h")){
                        //Ver ejercito
                        ejercitoPerson.toString();
                    }
                    else if(opc.equals("i")){
                        //Sumar niveles
                        int sumAtaque = 0;
                        int sumDefensa = 0;
                        int sumVida = 0;
                        for(int i=0; i<ejercitoPerson.getEjercito().size(); i++){
                            sumAtaque += ejercitoPerson.getEjercito().get(i).getNivelAtaque();
                            sumDefensa += ejercitoPerson.getEjercito().get(i).getNivelDefensa();
                            sumVida += ejercitoPerson.getEjercito().get(i).getNivelVida();
                        }
                        System.out.println("SUMATORIA:\nAtaque: " + sumAtaque + "\nDefensa: " + sumDefensa + "\nVida: " + sumVida);
                    }
                    else if(opc.equals("j")){
                        tablero.impTableroPers(ejercito1.getEjercito(), ejercito2.getEjercito());
                        //Comienza el juego entre los usuarios
                        int ganador = 0;
                        boolean cont = true;
                        while(cont){
                            //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                            System.out.println("=============================================\nEJERCITO 1:");
                            actitudSoldadoPers(ejercito1.getEjercito(), tablero.getTablero());
                            tablero.impTableroActual();
                            if(estaVacioPers(ejercito2.getEjercito())){
                                ganador = 1;
                                cont = false;
                                break;
                            }
                            System.out.println("=============================================\nEJERCITO 2:");
                            actitudSoldadoPers(ejercito2.getEjercito(), tablero.getTablero());
                            //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
                            if(estaVacioPers(ejercito1.getEjercito())){
                                ganador = 2;
                                cont = false;
                            }
                        }
                        if(ganador == 1)
                            System.out.println("EL GANADOR ES EL EJÉRCITO 1");
                        else if(ganador == 2)
                            System.out.println("EL GANADOR ES EL EJÉRCITO 2");
                        break;
                    }
                    else if(opc.equals("k"))
                        continuar = false;
                    else
                        System.out.println("Opcion no válida");
                    if(numEjer == 1)
                        ejercito1 = ejercitoPerson;
                    else if(numEjer == 2)
                        ejercito2 = ejercitoPerson;
                }
            }
            else if(opcion==3)
                //Salir
                break;
            else
                System.out.println("Escoja una opción válida");
        }
        System.out.println("Saliendo del juego...");
    }
    public static void actitudSoldadoPers(ArrayList<Soldado> ejercito, Soldado[][] tablero){
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
            ejercito.get(numSoldado).moverSoldado();
            //Comprobamos si cruza con un enemigo o aliado. Si es enemigo, lo ataca; si es aliado, vuelve a su posicion original
            int numEjercito = ejercito.get(numSoldado).getEjercito();
            int fila = ejercito.get(numSoldado).getFila();
            int columna = ejercito.get(numSoldado).getColumna();
            if(tablero[fila][columna] != null){
                //Si es aliado
                if(tablero[fila][columna].getEjercito() == numEjercito){
                    System.out.println("Es aliado, volviendo a la casilla original");
                    ejercito.get(numSoldado).retroceder();
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
                        if(tablero[fila][columna].getEjercito() == ejercito.get(numSoldado).getEjercito()){
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
}