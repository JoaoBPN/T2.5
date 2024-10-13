package Atores;

import Modelos.Copias.CopiaMidia;
import Modelos.Copias.CopiaVHS;
import Modelos.Sequenciadores.SequenciadorInt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GerenciadorCopias {
    private final SequenciadorInt sequenciador = new SequenciadorInt();
    private final Map<Integer, CopiaMidia> copias = new HashMap<>();
    private final Set<Integer> valoresRemovidos = new HashSet<>();

    public GerenciadorCopias(){}

    public void adicionaCopia(){

        if(valoresRemovidos.iterator().hasNext()) {
            var numeroCopia = valoresRemovidos.iterator().next();
            copias.put(numeroCopia,new CopiaMidia());
            return;
        }

        var numeroCopia = sequenciador.getProximo();
        copias.put(numeroCopia,new CopiaMidia());

    }

    public void removeCopia(Integer numeroCopia){

        if(copiaExiste(numeroCopia)){

            if(copias.get(numeroCopia).isAlugada()){
                System.out.println("Primeiro defina a copia como não alugada");
                return;
            }

            copias.remove(numeroCopia);
            valoresRemovidos.add(numeroCopia);
        }

    }

    public void alugaCopia(){
        for(Map.Entry<Integer, CopiaMidia> entry : copias.entrySet()){
            var copia = entry.getValue();
            if(copia.isDisponivel()){
                copia.setAlugada(true);
                System.out.println("Copia alugada com sucesso\n Numero copia: "+entry.getKey());
                return;
            }
        }

        System.out.println("Nenhuma cópia esta disponível para aluguel");
    }

    public void alugaCopia(Integer numeroCopia){

        if(copiaExiste(numeroCopia)){

            var copia = copias.get(numeroCopia);

            if(copia.isDisponivel()){
                copia.setAlugada(true);
                System.out.println("Cópia alguada com sucesso");
                return;
            }

            System.out.println("Cópia indisponível pra aluguel");
        }

    }

    public void retornaCopia(Integer numeroCopia){
        if(copiaExiste(numeroCopia)){
            var copia = copias.get(numeroCopia);

            if(copia.isAlugada()){
                copia.setAlugada(false);
                System.out.println("Cópia retornada com sucesso");
            }
        }
    }

    public void retornaCopia(Integer numeroCopia, boolean rebobinada){
        if(copiaExiste(numeroCopia)){

            var copia = copias.get(numeroCopia);

            if(!(copia instanceof CopiaVHS)) throw new IllegalArgumentException("Essa copia não é um VHS," +
                    "não deveria ter sido informado o estado da fita");

            if(copia.isAlugada()){
                ((CopiaVHS) copia).setRebobinada(rebobinada);
                copia.setAlugada(false);
                System.out.println("Cópia retornada com sucesso");
            }
        }
    }

    public boolean copiaExiste(Integer numeroCopia){
        var copia = copias.get(numeroCopia);

        if(copia == null){
            System.out.println("Copia não encontrada");
            return false;
        }
        return true;
    }

}
