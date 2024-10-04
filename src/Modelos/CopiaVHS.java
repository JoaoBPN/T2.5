package Modelos;

import Modelos.Midias.Midia;

public class CopiaVHS extends CopiaMidia {
    private boolean rebobinada;

    CopiaVHS(Midia midia, int numeroDeCopias){
        super(midia, numeroDeCopias);
        this.rebobinada = true;
    }

    public boolean isRebobinada(){
        return rebobinada;
    }

    public void setRebobinada(boolean rebobinada){
        this.rebobinada = rebobinada;
    }
}
