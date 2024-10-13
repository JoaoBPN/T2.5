package Atores;

import Modelos.Midias.Midia;
import Modelos.Sequenciadores.SequenciadorString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Locadora {

    private final Scanner scanner = new Scanner(System.in);
    private final SequenciadorString sequenciador = new SequenciadorString();

    private final Map<String, Midia> serialMidia = new HashMap<>();
    private final Map<Midia, BigDecimal> midiaAluguel = new HashMap<>();
    private final Map<Midia, GerenciadorCopias> copias = new HashMap<>();

    private final int LIMITE_DE_MIDIAS = 200;

    // Mais de uma vez nos métodos adicionaMidia eu chamei os metodos de valição com repetição, fiquei na dúvida se seria
    // uma má prática fazer isso ou se ficaria dificil entender a porque em alguns lugares é chamado ou em outros não

    // ADIÇÃO DE MÍDIA - INÍCIO

    public String adicionaMidia(Midia midia){
                            // == bastaria
        if(serialMidia.size() >= LIMITE_DE_MIDIAS){
            throw new RuntimeException("Não é possível registrar mais mídias");
        }

        validaMidia(midia);

        var serial = sequenciador.getNovoSerial();
        serialMidia.put(serial,midia);
        return serial;
    }

    public String adicionaMidia(Midia midia, BigDecimal aluguel){
        validaMidia(midia);
        validaAluguel(aluguel);

        var serial = adicionaMidia(midia);
        midiaAluguel.put(midia ,aluguel);
        return serial;
    }

    public String adicionaMidia(Midia midia, int quantidadeDeCopias){

        validaMidia(midia);
        validaQuantidadeDeCopias(quantidadeDeCopias);

        var serial = adicionaMidia(midia);
        var gerenciadorCopias = new GerenciadorCopias();

        for(int i = 0;i < quantidadeDeCopias; i++){
            gerenciadorCopias.adicionaCopia();
        }

        copias.put(midia,gerenciadorCopias);
        return serial;
    }

    public String adicionaMidia(Midia midia, int quantidadeDeCopias, BigDecimal aluguel){
        validaMidia(midia);
        validaQuantidadeDeCopias(quantidadeDeCopias);
        validaAluguel(aluguel);

        var serial = adicionaMidia(midia,quantidadeDeCopias);
        midiaAluguel.put(midia ,aluguel);
        return serial;
    }

    // ADIÇÃO DE MÍDIA - FIM

    // REMOÇÃO DE MÍDIA - INÍCIO

    public void removeMidia(String serial){
        var midia = serialMidia.get(serial);
        validaMidia(midia);
        midiaAluguel.remove(midia);
        copias.remove(midia);
        midiaAluguel.remove(midia);
    }

    // REMOÇÃO DE MÍDIA - FIM

    // ADIÇÃO DE CÓPIAS - INÍCIO

    public void adicionaCopias(String serial, int quantidadeDeCopias){

        var midia = serialMidia.get(serial);

        validaMidia(midia);
        validaQuantidadeDeCopias(quantidadeDeCopias);

        var gerenciador = copias.get(midia);

        if(gerenciador == null){
            gerenciador = new GerenciadorCopias();
            copias.put(midia,gerenciador);
        }

        for (int i = 0; i < quantidadeDeCopias; i++) {
            gerenciador.adicionaCopia();
        }

    }

    // ADIÇÃO DE CÓPIAS - FIM

    // REMOÇÃO DE CÓPIA - INÍCIO

    public void removeCopia(String serial, int numeroDaCopia){

        var midia = serialMidia.get(serial);

        validaMidia(midia);
        var gerenciador = copias.get(midia);

        gerenciador.removeCopia(numeroDaCopia);
    }

    // REMOÇÃO DE CÓPIA - FIM

    // ALUGUEL DE CÓPIA - INÍCIO

    public void alugaCopia(String serial){
        var midia = serialMidia.get(serial);

        var gerenciador = copias.get(midia);

        gerenciador.alugaCopia();
    }

    public void alugaCopia(String serial, int numeroCopia){
        var midia = serialMidia.get(serial);

        var gerenciador = copias.get(midia);

        gerenciador.alugaCopia(numeroCopia);
    }

    // ALUGUEL DE CÓPIA - FIM

    public void alteraAluguel(String serial, BigDecimal aluguel){
        var midia = serialMidia.get(serial);

        validaMidia(midia);
        validaAluguel(aluguel);

        midiaAluguel.replace(midia, aluguel);
    }


    public void buscaMidia(String serial){
        var midia = serialMidia.get(serial);
        validaMidia(midia);
        System.out.println(midia);
    }

    public void buscaMidia(Class<? extends Midia> classe){
        for (Map.Entry<String, Midia> entry : serialMidia.entrySet()) {
            Midia midia = entry.getValue();
            if(midia.getClass().equals(classe)) System.out.println(midia);
        }
    }

    public void buscaMidia(String participante, boolean isParticipante){
        for(Map.Entry <String, Midia> entry : serialMidia.entrySet()){
            Midia midia = entry.getValue();
            if(midia.hasParticipante(participante)) System.out.println(midia);
        }
    }

    private void validaMidia(Midia midia){
        if(midia == null){
            throw new IllegalArgumentException("Mídia invalida");
        }
    }

    private void validaAluguel(BigDecimal aluguel){
        if(aluguel == null || aluguel.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor de aluguel invalido");
        }
    }

    private void validaQuantidadeDeCopias(int quantidadeDeCopias){
        if(quantidadeDeCopias < 0){
            throw new IllegalArgumentException("Valor invalido de copias");
        }
    }

}
