package Modelos.Midias;


import java.util.Date;

public abstract class Midia {

    private final String nome;
    private final String genero;
    private final Date data;

    public Midia(String nome, String genero, Date data){
        this.nome = nome;
        this.genero = genero;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero(){
        return genero;
    }

    public Date getData(){
        return data;
    }

}
