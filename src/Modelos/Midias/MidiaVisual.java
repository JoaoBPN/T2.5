package Modelos.Midias;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public abstract class MidiaVisual extends Midia{
    private final String diretor;
    private final Set<String> atores;
    private final Integer duracaoEmMinutos;

    public MidiaVisual(String nome, String genero, Date dataLancamento,
                       String diretor, Set<String> atores, Integer duracaoEmMinutos){

        super(nome,genero,dataLancamento);
        this.diretor = diretor;
        this.atores = atores;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getDiretor(){
        return diretor;
    }

    public Set<String> getAtores(){
        return atores;
    }

    public Integer getDuracaoEmMinutos(){
        return duracaoEmMinutos;
    }

}
