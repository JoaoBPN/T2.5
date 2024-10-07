package Modelos.Midias;

import java.util.Date;
import java.util.Set;

public class DVD extends MidiaVisual{

    private final int classificaoEtaria;
    private final String regiao;

    public DVD(String titulo, String genero, Date anoDePublicacao,
               String diretor, Set<String> atores, Integer duracaoEmMinutos,
               int classificaoEtaria, String regiao){

        super(titulo,genero,anoDePublicacao,diretor,atores,duracaoEmMinutos);
        this.classificaoEtaria = classificaoEtaria;
        this.regiao = regiao;
    }

    public int getClassificaoEtaria() {
        return classificaoEtaria;
    }

    public String getRegiao() {
        return regiao;
    }

}
