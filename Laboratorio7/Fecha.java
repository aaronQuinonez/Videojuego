package Laboratorio7;

public class Fecha{
    private int dia;
    private int mes;
    private int year;

    //Constructores
    public Fecha(){
        this(1, 1, 1900);
    }
    public Fecha(int year){
        this.dia = 1;
        this.mes = 1;
        this.year = year;
    }
    public Fecha(int mes, int year){
        this.dia = 1;
        this.mes = mes;
        this.year = year;
    }
    public Fecha(int dia, int mes, int year){
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }
    public Fecha(Fecha f){
        this.dia = f.dia;
        this.mes = f.mes;
        this.year = f.year;
    }
    
    public void setDia(int dia){
        //Para comprobar caso especial si el mes es febrero
        if(this.mes == 2){
            //Comprobamos el dia 29 cuando sea año bisiesto
            if(esBisiesto()){
                if(dia < 0 || dia > 29){
                    System.out.println("Dato no valido");
                }else{
                    this.dia = dia;
                }
            }else{
                if(dia < 0 || dia > 28){
                    System.out.println("Dato no valido, no es año bisiesto");
                }else{
                    this.dia = dia;
                }
            }
        }
        //Comprobamos los meses que acaban con 31 o 30 dias respectivamente
        else if(this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12){
            if(dia < 0 || dia > 31){
                System.out.println("Dato no valido");
            }else{
                this.dia = dia;
            }
        }
        else if(this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11){
            if(dia < 0 || dia > 30){
                System.out.println("Dato no valido");
            }else{
                this.dia = dia;
            }
        }
        else{
            System.out.println("Mes no valido");
        }
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public void setAño(int year){
        this.year = year;
    }

    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getYear(){
        return year;
    }

    public String toString(){
        return "Dia: " + dia + "\nMes: " +  mes + "\nAño: " + year;
    }

    public boolean esBisiesto(){
        if(this.year%4 == 0){
            if(this.year%100 == 0){
                if(this.year%400 == 0){
                    return true;
                }
            }else{
                return true;
            }
        }
        return false;
    }
}