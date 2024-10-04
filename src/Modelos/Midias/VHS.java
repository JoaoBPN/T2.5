package Modelos.Midias;

import java.util.Date;
import java.util.Set;

public class VHS extends MidiaVisual {

    public VHS(String titulo, String genero, Date dataLancamento,
               String diretor, Set<String> atores, Integer duracaoEmMinutos){

        super(titulo,genero,dataLancamento,diretor,atores,duracaoEmMinutos);
    }

}
