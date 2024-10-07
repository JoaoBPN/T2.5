package Modelos.Sequenciadores;

public class SequenciadorInt {

    int valorAtual;

    public SequenciadorInt(){
        valorAtual = 0;
    }

    public int getProximo(){
        valorAtual++;
        return valorAtual;
    }

}
