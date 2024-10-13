package Modelos.Midias;

import java.util.Set;

public abstract class MidiaVisual extends Midia{
    private final String diretor;
    private final Set<String> atores;
    private final Integer duracaoEmMinutos;

    public MidiaVisual(String nome, String genero, int dataLancamento,
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

    @Override
    public boolean hasParticipante(String participante) {
        if(getAtores().contains(participante)) return true;
        return getDiretor().equals(participante);
    }
}
