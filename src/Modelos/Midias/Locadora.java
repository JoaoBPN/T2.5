package Modelos.Midias;

import Modelos.Sequenciador;
import Modelos.copiaMidia;

import java.math.BigDecimal;
import java.util.HashMap;

public class Locadora {

    private HashMap<String,Midia> midias;
    private HashMap<String, copiaMidia> copias;
    private HashMap<String, BigDecimal> midiaPrecoAluguel;

    private final Sequenciador sequenciador = new Sequenciador();

    public void adicionaMidia(Midia midia){
        int quantidadeMidias = midias.size();

        if(quantidadeMidias == 200){
            System.out.println("Quantidade máxima de mídias distintas atingidas");
            return;
        }

        midias.put(sequenciador.getNovoSerial(),midia);

    }

}
