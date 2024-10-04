package Modelos;

import Modelos.Midias.Midia;


public class CopiaMidia {

    Midia midia;
    int numeroCopia;
    boolean alugada;

    public CopiaMidia(Midia midia, int numeroCopia){
        this.midia = midia;
        this.numeroCopia = numeroCopia;
        this.alugada = false;
    }

    public Midia getMidia(){
        return midia;
    }

    public int getNumeroCopia(){
        return numeroCopia;
    }

    public boolean isAlugada(){
        return alugada;
    }

    public void setAlugada(boolean alugada){
        this.alugada = alugada;
    }

}
