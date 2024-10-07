package Modelos.Copias;

public class CopiaMidia {

    boolean alugada;

    public CopiaMidia(){
        this.alugada = false;
    }

    public boolean isAlugada(){
        return alugada;
    }

    public void setAlugada(boolean alugada){
        this.alugada = alugada;
    }

    public boolean isDisponivel(){
        return !isAlugada();
    }

}
