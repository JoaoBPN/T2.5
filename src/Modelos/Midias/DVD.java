package Modelos.Midias;

import java.util.Set;

public class DVD extends MidiaVisual{

    private final int classificaoEtaria;
    private final String regiao;

    public DVD(String titulo, String genero, int anoDePublicacao,
               String diretor, Set<String> atores, int duracaoEmMinutos,
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


    @Override
    public String toString(){
        // metodo incompleto, ainda falta exibir os atores
        return "Título: "+getNome()+
                "\nGênero: "+getGenero()+
                "\nAno de publicação: "+getData()+
                "\nDiretor: "+getDiretor()+
                "\nDuracao em minutos: "+getDuracaoEmMinutos()+
                "\nClassificação etária: "+getClassificaoEtaria()+
                "\nRegião: "+getRegiao();

    }

}
