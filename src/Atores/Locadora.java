package Atores;

import Modelos.Copias.CopiaMidia;
import Modelos.Midias.Midia;
import Modelos.Sequenciadores.SequenciadorString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Locadora {

    private final Scanner scanner = new Scanner(System.in);
    private final SequenciadorString sequenciador = new SequenciadorString();

    private final HashMap<String, Midia> serialMidia = new HashMap<>();
    private final HashMap<String, BigDecimal> midiaAluguel = new HashMap<>();
    private final HashMap<String, CopiaMidia> serialCopiaMidia = new HashMap<>();

    public String adicionaMidia(Midia midia){
        var serial = getSerialNovo();
        putMidia(serial, midia);
        return serial;
    }

    public void adicionaMidia(Midia midia, BigDecimal aluguel){
        var serial = adicionaMidia(midia);
        setAluguel(serial, aluguel);
    }

    private void putMidia(String serial, Midia midia){
        serialMidia.put(serial,midia);
    }

    private void setAluguel(String serial,BigDecimal aluguel){
        midiaAluguel.put(serial,aluguel);
    }

    private String getSerialNovo(){
        return sequenciador.getNovoSerial();
    }

}
