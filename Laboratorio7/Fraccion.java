package Laboratorio7;

public class Fraccion {
    private int numerador;
    private int denominador;

    //Constructores
    public Fraccion(){
        this.numerador = 1;
        this.denominador = 1;
    }
    public Fraccion(int numerador){
        this.numerador = numerador;
        this.denominador = 1;
    }
    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        if(denominador == 0){
            System.out.println("No se puede ingresar '0' en el denominador. Cambiando a '1'");
            this.denominador = 1;
        }else
            this.denominador = denominador;
    }
    public Fraccion(Fraccion f){
        this.numerador = f.numerador;
        this.denominador = f.denominador;
    }

    //Metodo get y set
    public void setNumerador(int numerador){
        this.numerador = numerador;
    }
    public void setDenominador(int denominador){
        if(denominador == 0){
            System.out.println("No se puede ingresar '0' en el denominador. Cambiando a '1'");
            this.denominador = 1;
        }else
            this.denominador = denominador;
    }
    public String getFraccion(){
        return numerador + "/" + denominador;
    }
    //Metodo toString
    public String toString(){
        double decimal = (double) numerador/denominador;
        return "Fraccion: " + numerador + "/" + denominador + "\nDecimal: " + decimal; 
    }
    //Metodo suma
    public Fraccion suma(Fraccion f2){
        Fraccion fsum = new Fraccion(f2);
        int den = 0;
        int num = 0;
        //Comprobamos que los denominadores son distintos
        if(this.denominador != fsum.denominador){
            num = (fsum.denominador*this.numerador) + (this.denominador*fsum.numerador);
            den = this.denominador * fsum.denominador;
            fsum.setNumerador(num);
            fsum.setDenominador(den);
        }else{
            num = this.numerador + fsum.numerador;
            fsum.setNumerador(num);
        }
        return fsum;
    }
    //Metodo resta
    public Fraccion resta(Fraccion f2){
        Fraccion frest = new Fraccion(f2);
        int num = 0;
        int den = 0;
        if(this.denominador == frest.denominador){
            num = this.numerador - frest.numerador;
            frest.setNumerador(num);
        }else{
            num = (this.numerador*frest.denominador)-(frest.numerador*this.denominador);
            den = this.denominador*frest.denominador;
            frest.setNumerador(num);
            frest.setDenominador(den);
        }
        return frest;
    }
    //Metodo multiplicar
    public Fraccion multiplicacion(Fraccion f2){
        Fraccion fmul = new Fraccion(f2);
        //Realizamos las operaciones correspondientes
        int num = fmul.numerador * this.numerador;
        int den = fmul.denominador * this.denominador;
        fmul.setNumerador(num);
        fmul.setDenominador(den);
        return fmul;
    }
    //Metodo division
    public Fraccion division(Fraccion f2){
        Fraccion fdiv = new Fraccion(f2);
        //Realizamos las operaciones correspondientes
        int num = fdiv.denominador * this.numerador;
        int den = fdiv.numerador * this.denominador;
        fdiv.setNumerador(num);
        fdiv.setDenominador(den);
        return fdiv;
    }
    //Metodo para simplificar fracciones
    public Fraccion simplificar(){
        Fraccion fSimplificada = new Fraccion();
        //Asignamos los atributos del nuevo objeto con los de la fraccion original a simplificar
        fSimplificada.setNumerador(this.numerador);
        fSimplificada.setDenominador(this.denominador);
        //Implementamos una función similar al MCD para simplificar
        //Creamos un indicador que guardara cada simplificacion a la fraccion
        int i = 2;
        while(i > 1){
            if(fSimplificada.denominador%i == 0 && fSimplificada.numerador%i == 0){
                fSimplificada.setNumerador(fSimplificada.numerador/i);
                fSimplificada.setDenominador(fSimplificada.denominador/i);
            }
            else if(i > fSimplificada.numerador || i > fSimplificada.denominador){
                break;
            }
            else{
                i++;
            }
        }
        return fSimplificada;
    }

}