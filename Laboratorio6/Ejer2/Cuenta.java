package Laboratorio6.Ejer2;

public class Cuenta {
    private String nombre;
    private int saldo;

    public Cuenta(){}

    public Cuenta(String nombre, int saldo){
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getSaldo(){
        return saldo;
    }
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

    public void depositar(int saldo, int deposito){
        this.saldo += deposito;
    }

    public void retirar(int saldo, int retiro){
        this.saldo -= retiro;
    }

    public boolean esPremium(){
        if(saldo >= 10000){
            return true;
        }
        return false;
    }
}
