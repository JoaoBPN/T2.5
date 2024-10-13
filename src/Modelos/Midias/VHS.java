package Modelos.Midias;

import java.util.Set;

public class VHS extends MidiaVisual {

    public VHS(String titulo, String genero, int dataLancamento,
               String diretor, Set<String> atores, Integer duracaoEmMinutos){

        super(titulo,genero,dataLancamento,diretor,atores,duracaoEmMinutos);
    }

    @Override
    public String toString(){
        // metodo incompleto ainda falta exibir os atores
        return "Título: "+getNome()+
                "\nGênero: "+getGenero()+
                "\nAno de publicação: "+getData()+
                "\nDiretor: "+getDiretor()+
                "\nDuracao em minutos: "+getDuracaoEmMinutos();
    }
}
