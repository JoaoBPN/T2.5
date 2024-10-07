package Modelos.Copias;

public class CopiaVHS extends CopiaMidia {
    private boolean rebobinada;

    CopiaVHS(){
        this.rebobinada = true;
    }

    public boolean isRebobinada(){
        return rebobinada;
    }

    public void setRebobinada(boolean rebobinada){
        this.rebobinada = rebobinada;
    }

    @Override
    public boolean isDisponivel(){
        return isRebobinada() && !isAlugada();
    }
}
