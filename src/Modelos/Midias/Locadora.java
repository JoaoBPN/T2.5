package Modelos.Midias;

import Modelos.Sequenciador;
import Modelos.CopiaMidia;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Locadora {
    private final Scanner scanner = new Scanner(System.in);
    private final HashMap<String,Midia> midias = new HashMap<>();
    private final HashMap<String, CopiaMidia> copias = new HashMap<>();
    private final HashMap<String, BigDecimal> midiaPrecoAluguel = new HashMap<>();

    private final Sequenciador sequenciador = new Sequenciador();

    public void adicionaMidia(Midia midia, int quantidadeDeCopias, BigDecimal aluguelDiario){
        String sequencial = sequenciador.getNovoSerial();

        midias.put(sequencial,midia);

        for (int i = 1; i < quantidadeDeCopias; i++) {
            copias.put(sequencial,new CopiaMidia(midia,i));
        }

        midiaPrecoAluguel.put(sequencial,aluguelDiario);
    }

    public void buscaMidia(String identificador){
        Midia midia = midias.get(identificador);

        if(midia == null){
            System.out.println("Midia não encontrada");
            return;
        }

        System.out.println(midia);
        System.out.println(midiaPrecoAluguel.get(identificador));
    }

    public void exibeMidiaPorClasse(Class<? extends Midia> classe){
        for(Map.Entry<String,Midia> entry : midias.entrySet()){
            Midia midia = entry.getValue();

            if(midia.getClass().equals(classe)) System.out.println(midia);
        }
    }



}
