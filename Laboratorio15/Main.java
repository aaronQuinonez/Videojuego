package Laboratorio15;
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
                Mapa tableroReinos = new Mapa();
                tableroReinos.setTipoTerritorio(territorio);
                tableroReinos.establecerPosReino(reino1.getReino(), reino2.getReino());
                System.out.println("--------------------------------------");
                System.out.println("Datos de los reinos");
                System.out.println(reino1.toString());
                System.out.println(reino2.toString());
                System.out.println("--------------------------------------");
                System.out.println(tableroReinos.getTipoTerritorio());
                mejoraPorTerritorio(tableroReinos, reino1);
                mejoraPorTerritorio(tableroReinos, reino2);
                tableroReinos.impTableroReino(reino1.getReino(), reino2.getReino());
                int ganadorReino = 0;
                boolean contReino = true;
                while(contReino){
                    //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                    System.out.println("=============================================\nReino 1:");
                    actitudReino(reino1.getReino(), reino2, tableroReinos.getEjercito());
                    tableroReinos.impTableroActualReino();
                    if(estaVacioReino(reino2.getReino())){
                        ganadorReino = 1;
                        contReino = false;
                        break;
                    }
                    System.out.println("\nTOTAL DE EJERCITOS EN REINO 1: " + reino1.getSize());
                    System.out.println("\nTOTAL DE EJERCITOS EN REINO 2: " + reino2.getSize());
                    System.out.println("=============================================\nEJERCITO 2:");
                    actitudReino(reino2.getReino(), reino1, tableroReinos.getEjercito());
                    tableroReinos.impTableroActualReino();
                    //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
                    if(estaVacioReino(reino1.getReino())){
                        ganadorReino = 2;
                        contReino = false;
                        break;
                    }
                    System.out.println("\nTOTAL DE EJERCITOS EN EJÉRCITO 1: " + reino1.getSize());
                    System.out.println("\nTOTAL DE EJERCITOS EN EJÉRCITO 2: " + reino2.getSize());
                    System.out.println("Desea continuar?\n(1)Sí\n(2)No");
                    int cont = sc.nextInt();
                    while(cont != 1 && cont !=2){
                        System.out.println("Escoja una opción válida");
                        cont = sc.nextInt();
                    }
                    if(cont == 1)
                        continue;
                    else if(cont == 2)
                        contReino = false;
                }
                if(ganadorReino == 1){
                    System.out.println("EL GANADOR ES EL JUGADOR 1");
                }else{
                    System.out.println("EL GANADOR ES EL JUGADOR 2");                
                }
            }
            else if(opcion==2){
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
                
                String territorio = crearTipoTerritorio();
                //Creamos otro tablero para los reinos
                Mapa tableroReinos = new Mapa();
                tableroReinos.setTipoTerritorio(territorio);
                tableroReinos.establecerPosReino(reino1.getReino(), reino2.getReino());
                System.out.println("--------------------------------------");
                System.out.println("Datos de los reinos");
                System.out.println(reino1.toString());
                System.out.println(reino2.toString());
                System.out.println("--------------------------------------");
                System.out.println(tableroReinos.getTipoTerritorio());
                tableroReinos.impTableroReino(reino1.getReino(), reino2.getReino());
                
                boolean continuar = true;
                while(continuar){
                    //Pedimos a que ejército va a personalizar
                    System.out.println("Escoja el reino a personalizar:");
                    int numReino = sc.nextInt();
                    Reino ejercitoReino = new Reino();
                    if(numReino == 1){
                        ejercitoReino = reino1;
                    }else if(numReino == 2){
                        ejercitoReino = reino2;
                    }
                    //Pedimos que escoja a un ejercito del reino
                    System.out.println("Escoja el ejercito:");
                    int numEjer = sc.nextInt();
                    while(numEjer < 0 || numEjer >= ejercitoReino.getSize()){
                        System.out.println("Escoja en numero valido");
                        numEjer = sc.nextInt();
                    }
                    Ejercito ejercitoPerson = ejercitoReino.getReino().get(numEjer);
                    System.out.println(ejercitoPerson.toString());
                    //Mostramos las opciones para personalizar al ejército
                    System.out.println("Escoja las siguientes opciones:\n(a)Crear Soldado\n(b)Eliminar Soldado\n(c)Clonar Soldado\n(d)Modificar Soldado\n(e)Comparar Soldados\n(f)Intercambiar soldados\n(g)Ver soldado\n(h)Ver ejército\n(i)Sumar niveles\n(j)Jugar\n(k)Volver");
                    String opc = sc.next();
                    if(opc.equals("a")){
                        //Crear Soldado, permitirá crear un nuevo soldado personalizado y añadir al final del ejército (recordar que límite es de 10 soldados por ejército)
                        if(ejercitoPerson.getLength() == 10){
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
                            soldadoNuevo.setEjercito(numReino);
                            soldadoNuevo.setNombre("Soldado" + (ejercitoPerson.getEjercito().size()) + "x" + numEjer);
                            tableroReinos.establecerNuevaPos(soldadoNuevo);
                            //Agregamos al soldado nuevo en nuestro ArrayList
                            ejercitoPerson.getEjercito().add(soldadoNuevo);
                            System.out.println("\n\nVOLVIENDO AL MENÚ\n\n");
                        }
                    }
                    else if(opc.equals("b")){
                        //Eliminar Soldado (no debe permitir un ejército vacío)
                        if(ejercitoPerson.getLength()== 1){
                            System.out.println("El ejército no debe quedar vacío");
                        }
                        else{
                            //Eliminamos al último soldado del ejército
                            System.out.println("El " + ejercitoPerson.getEjercito().get(ejercitoPerson.getEjercito().size()-1).getNombre() + " será eliminado");
                            tableroReinos.quitarPos(ejercitoPerson.getEjercito().get(ejercitoPerson.getEjercito().size()-1).getFila(), ejercitoPerson.getEjercito().get(ejercitoPerson.getEjercito().size()-1).getColumna());
                            ejercitoPerson.getEjercito().remove(ejercitoPerson.getEjercito().size()-1);
                        }
                    }
                    else if(opc.equals("c")){
                        //Clonar Soldado (crea una copia exacta del soldado) y se añade al final del ejército (recordar que límite es de 10 soldados por ejército)
                        if(ejercitoPerson.getLength() == 10){
                            System.out.println("No se puede crear más soldados, volviendo al menú");
                        }
                        else{
                            System.out.println("Escoja el numero del soldado a clonar:");
                            int num = sc.nextInt();
                            if(num >= 0 && num < ejercitoPerson.getEjercito().size()){
                                //Creamos un soldado con las características del soldado elegido;
                                Soldado soldadoClon = new Soldado(ejercitoPerson.getEjercito().get(num));
                                soldadoClon.setNombre("Soldado" + ejercitoPerson.getEjercito().size() + "x" + numReino);
                                tableroReinos.establecerNuevaPos(soldadoClon);
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
                        if(num >= 0 && num <ejercitoPerson.getLength()){
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
                            if((primerSoldado >= 0 && primerSoldado < ejercitoPerson.getLength()) && (segundoSoldado >= 0 && segundoSoldado < ejercitoPerson.getLength())){
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
                            tableroReinos.cambiarPos(ejercitoPerson.getEjercito().get(primerSoldado), ejercitoPerson.getEjercito().get(segundoSoldado));
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
                        System.out.println(ejercitoPerson.toString());
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
                        System.out.println(tableroReinos.getTipoTerritorio());
                        tableroReinos.impTableroReino(reino1.getReino(), reino2.getReino());
                        int ganadorRein = 0;
                        boolean contReino = true;
                        while(contReino){
                            //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                            System.out.println("=============================================\nReino 1:");
                            actitudReino(reino1.getReino(), reino2, tableroReinos.getEjercito());
                            tableroReinos.impTableroActualReino();
                            if(estaVacioReino(reino2.getReino())){
                                ganadorRein = 1;
                                contReino = false;
                                break;
                            }
                            System.out.println("\nTOTAL DE EJERCITOS EN REINO 1: " + reino1.getSize());
                            System.out.println("\nTOTAL DE EJERCITOS EN REINO 2: " + reino2.getSize());
                            System.out.println("=============================================\nEJERCITO 2:");
                            actitudReino(reino2.getReino(), reino1, tableroReinos.getEjercito());
                            tableroReinos.impTableroActualReino();
                            //Usamos un metodo para comprobar si un ejercito ya está vacío, para decidir al ganador
                            if(estaVacioReino(reino1.getReino())){
                                ganadorRein = 2;
                                contReino = false;
                                break;
                            }
                            System.out.println("\nTOTAL DE EJERCITOS EN EJÉRCITO 1: " + reino1.getSize());
                            System.out.println("\nTOTAL DE EJERCITOS EN EJÉRCITO 2: " + reino2.getSize());
                            System.out.println("Desea continuar?\n(1)Sí\n(2)No");
                            int cont = sc.nextInt();
                            while(cont != 1 && cont !=2){
                                System.out.println("Escoja una opción válida");
                                cont = sc.nextInt();
                            }
                            if(cont == 1)
                                continue;
                            else if(cont == 2)
                                contReino = false;
                        }
                        if(ganadorRein == 1){
                            System.out.println("EL GANADOR ES EL JUGADOR 1");
                        }else{
                            System.out.println("EL GANADOR ES EL JUGADOR 2");                
                        }
                    }
                    else if(opc.equals("k"))
                        continuar = false;
                    else
                        System.out.println("Opcion no válida");
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
    public static void actitudReino(ArrayList<Ejercito> ejercito, Reino ejercito2, Ejercito[][] tablero){
        System.out.println("Escoja al ejercito:");
        Scanner sc = new Scanner(System.in);
        int numEjercito = sc.nextInt();
        int filaAnterior = ejercito.get(numEjercito).getFila();
        int columnaAnterior = ejercito.get(numEjercito).getColumna();
        //Le preguntamos al usuario hacia donde va a mover el soldado (arriba, derecha o izquierda)
        System.out.println("Hacia donde se moverá el ejercito\n(1)Arriba\n(2)Derecha\n(3)Izquierda\n(4)Abajo");
        int mov = sc.nextInt();
        while(1<2){
            if(mov != 3 && mov != 2 && mov != 1 && mov != 4)
                System.out.println("Ingrese una opción válida");
            else break;
            System.out.println("Hacia donde se moverá el ejercito\n(1)Arriba\n(2)Derecha\n(3)Izquierda\n(4)Abajo");
            mov = sc.nextInt();
        }
        ejercito.get(numEjercito).moverEjercito(mov);
        //Comprobamos si cruza con un enemigo o aliado. Si es enemigo, lo ataca; si es aliado, vuelve a su posicion original
        int numEjercit = ejercito.get(numEjercito).getNumReino();
        int fila = ejercito.get(numEjercito).getFila();
        int columna = ejercito.get(numEjercito).getColumna();
        if(tablero[fila][columna] != null){
            //Si es aliado
            if(tablero[fila][columna].getNumReino() == numEjercit){
                System.out.println("Es aliado, volviendo a la casilla original");
                if(mov == 1){
                    ejercito.get(numEjercito).retroceder();
                }
                else if(mov == 2){
                    ejercito.get(numEjercito).izquierda();
                }
                else if(mov == 3){
                    ejercito.get(numEjercito).derecha();
                }
                else{
                    ejercito.get(numEjercito).avanzar();
                }
            }
            //Si es enemigo, entraremos ahora a la tabla de solo soldados
            else{
                Mapa tableroSoldados = new Mapa();
                tableroSoldados.establecerPosEjercito(ejercito.get(numEjercito).getEjercito(), tablero[fila][columna].getEjercito());
                System.out.println("--------------------------------------");
                System.out.println("Ejército 1");
                System.out.println("--------------------------------------");
                System.out.println(ejercito.get(numEjercito).getEjercito().toString());
                System.out.println("--------------------------------------");
                System.out.println("Ejército 2");
                System.out.println("--------------------------------------");
                System.out.println(tablero[fila][columna].getEjercito().toString());
                //Mostramos la cantidad total de soldados y la cantidad de soldados por ejército
                System.out.println("\nTOTAL DE SOLDADOS CREADOS: " + (ejercito.get(numEjercito).getLength()+tablero[fila][columna].getLength()));
                System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + ejercito.get(numEjercito).getLength());
                System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + tablero[fila][columna].getLength());
                //Imprimimos el tablero
                tableroSoldados.impTableroPers(ejercito.get(numEjercito).getEjercito(), tablero[fila][columna].getEjercito());
                //Comienza el juego entre los usuarios
                int ganador = 0;
                boolean continuar = true;
                while(continuar){
                    //Usamos el metodo actitudSoldado para que el usuario escoja la actitud, serán 2 turnos
                    System.out.println("=============================================\nEJERCITO 1:");
                    actitudSoldadoPers(ejercito.get(numEjercito).getEjercito(), tablero[fila][columna], tableroSoldados.getTablero());
                    tableroSoldados.impTableroActual();

                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + ejercito.get(numEjercito).getLength());
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + tablero[fila][columna].getLength());
                    System.out.println("=============================================\nEJERCITO 2:");
                    actitudSoldadoPers(tablero[fila][columna].getEjercito(), ejercito.get(numEjercito), tableroSoldados.getTablero());
                    tableroSoldados.impTableroActual();

                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 1: " + ejercito.get(numEjercito).getLength());
                    System.out.println("\nTOTAL DE SOLDADOS EN EJÉRCITO 2: " + tablero[fila][columna].getLength());
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
                if(ganador == 1){
                    System.out.println("EL GANADOR ES EL EJÉRCITO 1");
                    tablero[fila][columna].setVive(false);
                }
                else if(ganador == 2){
                    System.out.println("EL GANADOR ES EL EJÉRCITO 2");
                    ejercito.get(numEjercito).setVive(false);
                }
                //Comprobamos quien muere para actualizar el tablero
                if(!ejercito.get(numEjercito).getVive()){
                    tablero[filaAnterior][columnaAnterior] = null;
                    ejercito.remove(numEjercito);
                }
                else{
                    ejercito2.eliminarEjercito(fila, columna);
                    tablero[fila][columna] = ejercito.get(numEjercito);
                    tablero[filaAnterior][columnaAnterior] = null;
                }
            }
        }
        else{
            tablero[fila][columna] = ejercito.get(numEjercito);
            tablero[filaAnterior][columnaAnterior] = null;
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
    public static boolean estaVacioReino(ArrayList<Ejercito> ejercito){
        int muerteTotal = 0;
        for(int i=0; i<ejercito.size(); i++){
            if(!ejercito.get(i).getVive())
                muerteTotal++;
        }
        if(muerteTotal == ejercito.size())
            return true;
        return false;
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
        int random = (int) (Math.random()*10+1);
        for(int i=0; i<random; i++){
            //Creamos un objeto de tipo ejercito que se almacenarán en nuestro reino
            Ejercito ejercito = new Ejercito();
            ejercito.asignarEstadisticas();
            ejercito.establecerEquipo(eleccion);
            ejercito.asignarNombres();
            reino.getReino().add(ejercito);
        }
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
        //Obtenemos el tipo de terriotio y comprobamos si es apto para darle mejoras al respectivo reino
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