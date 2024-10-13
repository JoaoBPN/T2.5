package Modelos.Midias;

public abstract class Midia {

    private final String nome;
    private final String genero;
    private final int ano;

    public Midia(String nome, String genero, int ano){
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero(){
        return genero;
    }

    public int getData(){
        return ano;
    }

    public abstract boolean hasParticipante(String participante);
}
